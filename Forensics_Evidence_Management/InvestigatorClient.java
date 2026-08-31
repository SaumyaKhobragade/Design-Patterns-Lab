import java.util.Scanner; // Used to read user input from the keyboard
import java.sql.Connection; // JDBC: the open DB connection object
import java.sql.PreparedStatement; // JDBC: compiled SQL with ? placeholders
import java.sql.ResultSet; // JDBC: holds rows returned by a SELECT query

// ============================================================
// FILE: InvestigatorClient.java
// ROLE: Main entry point of the application (contains the main() method)
// PURPOSE: Drives the complete forensic evidence workflow:
//   Step 1 -> Login (auth via DB)
//   Step 2 -> Fetch Investigator_Type from DB (no manual input)
//   Step 3 -> Ask evidence details (type + risk score)
//   Step 4 -> Ask notification channel
//   Step 5 -> Validate evidence type compatibility (Abstract Factory)
//   Step 6 -> Validate pending case capacity (Audit_Dept table)
//   Step 7 -> INSERT evidence as 'Pending'
//   Step 8 -> Run Chain of Responsibility -> Observer -> DB updates
// ============================================================
public class InvestigatorClient {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ---- Singleton Pattern Proof ----
        EvidenceApproverSystem s1 = EvidenceApproverSystem.getInstance();
        EvidenceApproverSystem s2 = EvidenceApproverSystem.getInstance();
        System.out.println("Singleton check: " + (s1 == s2));
        System.out.println();

        ForensicSystemProxy proxy = new ForensicSystemProxy();
        EvidenceApproverSystem approverSystem = EvidenceApproverSystem.getInstance();

        // STEP 1: LOGIN
        System.out.print("Enter Investigator ID: ");
        String investigatorId = input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Password: ");
        int password = input.nextInt();
        input.nextLine(); // consume leftover newline

        if (!proxy.authenticateUser(investigatorId, name, password)) {
            System.out.println("Proxy: Authentication FAILED. Access Denied!");
            return;
        }

        System.out.println("Proxy: Authentication SUCCESSFUL. Access Granted!");
        System.out.println();

        // STEP 2: FETCH Investigator_Type from DB
        String investigatorTypeFromDB = null;
        Connection conn = DatabaseConnection.getInstance();
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT Investigator_Type FROM Investigator_Info WHERE InvestigatorID = ?");
                pstmt.setString(1, investigatorId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    investigatorTypeFromDB = rs.getString("Investigator_Type");
                }
                rs.close();
                pstmt.close();
            } catch (Exception e) {
                System.out.println("Error fetching investigator type: " + e.getMessage());
                return;
            }
        }

        if (investigatorTypeFromDB == null) {
            System.out.println("Could not fetch investigator type from database. Exiting.");
            return;
        }

        System.out.println("Investigator Type (from DB): " + investigatorTypeFromDB);

        AbstractFactory factory;
        if (investigatorTypeFromDB.toLowerCase().contains("senior")) {
            factory = new SeniorInvestigator();
        } else if (investigatorTypeFromDB.toLowerCase().contains("junior")) {
            factory = new JuniorInvestigator();
        } else {
            System.out.println("Unknown investigator type: " + investigatorTypeFromDB + ". Exiting.");
            return;
        }

        // STEP 3: ASK for Evidence Type and Risk Score
        System.out.print("Enter Evidence Type (DISK / MOBILE / NETWORK): ");
        String evidenceTypeInput = input.nextLine();

        System.out.print("Enter Evidence Risk Score (1-10): ");
        int riskScore = input.nextInt();
        input.nextLine();

        // STEP 4: BRIDGE PATTERN — Ask Notification Channel
        System.out.print("Enter Notification Channel (Email / SMS / App): ");
        String channelInput = input.nextLine();

        NotificationChannel channel = null;
        if (channelInput.equalsIgnoreCase("Email")) {
            channel = new EmailNotification();
        } else if (channelInput.equalsIgnoreCase("SMS")) {
            channel = new SMSNotification();
        } else if (channelInput.equalsIgnoreCase("App")) {
            channel = new MobileAppNotification();
        }
        System.out.println();

        // STEP 5: VALIDATE — Incompatible Evidence Type (Abstract Factory)
        Evidence evidence = null;
        if (evidenceTypeInput.equalsIgnoreCase("DISK")) {
            evidence = factory.createDiskImage(riskScore);
        } else if (evidenceTypeInput.equalsIgnoreCase("MOBILE")) {
            evidence = factory.createMobileBackup(riskScore); // null for JuniorInvestigator
        } else if (evidenceTypeInput.equalsIgnoreCase("NETWORK")) {
            evidence = factory.createNetworkCapture(riskScore);
        } else {
            System.out.println("Invalid evidence type entered. Exiting.");
            return;
        }

        if (evidence == null) {
            System.out.println("Evidence request REJECTED: Mobile Backup is restricted for Junior Investigators.");
            proxy.insertEvidence(investigatorId, evidenceTypeInput.toUpperCase(), riskScore, "Rejected", channelInput);
            return;
        }

        // STEP 6: VALIDATE — Check Pending Cases Capacity from Audit_Dept table
        int currentCapacity = 0;
        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT PendingCases FROM Audit_Dept WHERE InvestigatorID = ?");
                pstmt.setString(1, investigatorId);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    currentCapacity = rs.getInt("PendingCases");
                }
                rs.close();
                pstmt.close();
            } catch (Exception e) {
                System.out.println("Error checking case capacity: " + e.getMessage());
                return;
            }
        }

        System.out.println("Current Case Handling Capacity: " + currentCapacity + " case(s)");
        if (currentCapacity <= 0) {
            System.out.println("Evidence request REJECTED: No pending case capacity remaining.");
            proxy.insertEvidence(investigatorId, evidence.getEvidenceType(), riskScore, "Rejected", channelInput);
            return;
        }

        // STEP 7: SUBMIT — All validations passed. Insert as 'Pending'.
        proxy.insertEvidence(investigatorId, evidence.getEvidenceType(), riskScore, "Pending", channelInput);
        proxy.submitEvidence(evidence);

        if (channel != null) {
            evidence.setNotificationChannel(channel);
        }

        // STEP 8: APPROVAL — Chain of Responsibility -> Coordinator -> Observers
        approverSystem.processEvidence(evidence, investigatorId);
        System.out.println();
    }
}
