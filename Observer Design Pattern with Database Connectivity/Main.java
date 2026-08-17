public class Main {
        public static void main(String[] args) {

                System.out.println(
                                "======================================================");
                System.out.println(
                                "       ONLINE LEAVE MANAGEMENT SYSTEM");
                System.out.println(
                                "       DESIGN PATTERN + JDBC DEMONSTRATION");
                System.out.println(
                                "======================================================");

                FacultyDAO facultyDAO = new FacultyDAO();
                LeaveDAO leaveDAO = new LeaveDAO();

                // =====================================================
                // 1. SINGLETON DESIGN PATTERN
                // =====================================================

                System.out.println(
                                "\n\n========== 1. SINGLETON PATTERN ==========");

                LeaveManagementSystem system1 = LeaveManagementSystem.getInstance();

                LeaveManagementSystem system2 = LeaveManagementSystem.getInstance();

                if (system1 == system2) {

                        System.out.println(
                                        "SUCCESS: Both references point to "
                                                        + "the same Leave Management System.");

                } else {

                        System.out.println(
                                        "ERROR: Multiple instances detected.");
                }

                // =====================================================
                // 2. FACTORY METHOD + JDBC
                // =====================================================

                System.out.println(
                                "\n\n========== 2. FACTORY METHOD + JDBC ==========");

                System.out.println(
                                "\nFaculty records are retrieved from MySQL.");

                Faculty permanentFaculty = facultyDAO.getFacultyById(1001);

                Faculty contractFaculty = facultyDAO.getFacultyById(1003);

                if (permanentFaculty == null ||
                                contractFaculty == null) {

                        System.out.println(
                                        "Required faculty records were not found.");

                        return;
                }

                System.out.println(
                                "\nPermanent Faculty:");

                System.out.println(
                                "ID   : "
                                                + permanentFaculty.getFacultyId());

                System.out.println(
                                "Name : "
                                                + permanentFaculty.getFacultyName());

                System.out.println(
                                "Type : "
                                                + permanentFaculty.getFacultyType());

                System.out.println(
                                "\nContract Faculty:");

                System.out.println(
                                "ID   : "
                                                + contractFaculty.getFacultyId());

                System.out.println(
                                "Name : "
                                                + contractFaculty.getFacultyName());

                System.out.println(
                                "Type : "
                                                + contractFaculty.getFacultyType());

                // =====================================================
                // 3. ABSTRACT FACTORY
                // =====================================================

                System.out.println(
                                "\n\n========== 3. ABSTRACT FACTORY ==========");

                System.out.println(
                                "\n--- Permanent Faculty Leave Family ---");

                Leave permanentCL = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                permanentFaculty,
                                2);

                Leave permanentML = LeaveAbstractFactory.getLeave(
                                "MedicalLeave",
                                permanentFaculty,
                                5);

                Leave permanentOD = LeaveAbstractFactory.getLeave(
                                "OnDutyLeave",
                                permanentFaculty,
                                10);

                System.out.println(
                                "Casual Leave  : "
                                                + (permanentCL != null
                                                                ? "Created"
                                                                : "Not Created"));

                System.out.println(
                                "Medical Leave : "
                                                + (permanentML != null
                                                                ? "Created"
                                                                : "Not Created"));

                System.out.println(
                                "On-Duty Leave : "
                                                + (permanentOD != null
                                                                ? "Created"
                                                                : "Not Created"));

                System.out.println(
                                "\n--- Contract Faculty Leave Family ---");

                Leave contractCL = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                contractFaculty,
                                2);

                Leave contractOD = LeaveAbstractFactory.getLeave(
                                "OnDutyLeave",
                                contractFaculty,
                                3);

                Leave contractML = LeaveAbstractFactory.getLeave(
                                "MedicalLeave",
                                contractFaculty,
                                5);

                System.out.println(
                                "Casual Leave  : "
                                                + (contractCL != null
                                                                ? "Created"
                                                                : "Not Created"));

                System.out.println(
                                "On-Duty Leave : "
                                                + (contractOD != null
                                                                ? "Created"
                                                                : "Not Created"));

                System.out.println(
                                "Medical Leave : "
                                                + (contractML != null
                                                                ? "Created"
                                                                : "Rejected - Not allowed"));

                // =====================================================
                // 4. BRIDGE DESIGN PATTERN
                // =====================================================

                System.out.println(
                                "\n\n========== 4. BRIDGE PATTERN ==========");

                System.out.println(
                                "\nThe same leave type can use different "
                                                + "notification channels.");

                Leave bridgeLeave = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                permanentFaculty,
                                1);

                System.out.println(
                                "\nCasual Leave + Email:");

                bridgeLeave.setNotification(
                                new EmailNotification());

                bridgeLeave.notifyFaculty();

                System.out.println(
                                "\nCasual Leave + SMS:");

                bridgeLeave.setNotification(
                                new SMSNotification());

                bridgeLeave.notifyFaculty();

                System.out.println(
                                "\nCasual Leave + Mobile App:");

                bridgeLeave.setNotification(
                                new MobileAppNotification());

                bridgeLeave.notifyFaculty();

                // =====================================================
                // 5. JDBC CREATE + CHAIN + OBSERVER
                // =====================================================

                System.out.println(
                                "\n\n======================================================");

                System.out.println(
                                "5. COMPLETE APPROVAL WORKFLOW");

                System.out.println(
                                "======================================================");

                // -----------------------------------------------------
                // SCENARIO 1
                // 2 DAYS -> HOD
                // -----------------------------------------------------

                System.out.println(
                                "\n\n******** SCENARIO 1 ********");

                System.out.println(
                                "Permanent Faculty | 2 Days | Casual Leave");

                System.out.println(
                                "Expected Approver: HOD");

                Leave hodLeave = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                permanentFaculty,
                                2);

                hodLeave.setNotification(
                                new EmailNotification());

                System.out.println(
                                "\nCreating leave request in database...");

                int hodLeaveId = leaveDAO.createLeave(hodLeave);

                System.out.println(
                                "\nReading newly created record:");

                leaveDAO.getLeave(hodLeaveId);

                System.out.println(
                                "\nSubmitting through Proxy...");

                Proxy proxy = new Proxy();

                proxy.submitLeaveRequest(
                                permanentFaculty,
                                "aarav123",
                                hodLeave);

                System.out.println(
                                "\nDatabase record after approval:");

                leaveDAO.getLeave(hodLeaveId);

                // -----------------------------------------------------
                // SCENARIO 2
                // 5 DAYS -> PRINCIPAL
                // -----------------------------------------------------

                System.out.println(
                                "\n\n******** SCENARIO 2 ********");

                System.out.println(
                                "Permanent Faculty | 5 Days | Medical Leave");

                System.out.println(
                                "Expected Approver: Principal");

                Leave principalLeave = LeaveAbstractFactory.getLeave(
                                "MedicalLeave",
                                permanentFaculty,
                                5);

                principalLeave.setNotification(
                                new SMSNotification());

                int principalLeaveId = leaveDAO.createLeave(
                                principalLeave);

                System.out.println(
                                "\nSubmitting through Proxy...");

                proxy.submitLeaveRequest(
                                permanentFaculty,
                                "aarav123",
                                principalLeave);

                System.out.println(
                                "\nDatabase record after approval:");

                leaveDAO.getLeave(
                                principalLeaveId);

                // -----------------------------------------------------
                // SCENARIO 3
                // 10 DAYS -> DIRECTOR
                // ALSO DEMONSTRATES SALARY DEDUCTION
                // -----------------------------------------------------

                System.out.println(
                                "\n\n******** SCENARIO 3 ********");

                System.out.println(
                                "Permanent Faculty | 10 Days | On-Duty Leave");

                System.out.println(
                                "Expected Approver: Director");

                System.out.println(
                                "If available leave is insufficient, "
                                                + "salary deduction will occur.");

                Leave directorLeave = LeaveAbstractFactory.getLeave(
                                "OnDutyLeave",
                                permanentFaculty,
                                10);

                directorLeave.setNotification(
                                new MobileAppNotification());

                int directorLeaveId = leaveDAO.createLeave(
                                directorLeave);

                System.out.println(
                                "\nSubmitting through Proxy...");

                proxy.submitLeaveRequest(
                                permanentFaculty,
                                "aarav123",
                                directorLeave);

                System.out.println(
                                "\nDatabase record after approval:");

                leaveDAO.getLeave(
                                directorLeaveId);

                // =====================================================
                // 6. PROXY - AUTHENTICATION FAILURE
                // =====================================================

                System.out.println(
                                "\n\n========== 6. PROXY - AUTHENTICATION FAILURE ==========");

                Leave unauthorizedLeave = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                permanentFaculty,
                                1);

                unauthorizedLeave.setNotification(
                                new EmailNotification());

                System.out.println(
                                "\nAttempting request with incorrect password...");

                proxy.submitLeaveRequest(
                                permanentFaculty,
                                "WRONG_PASSWORD",
                                unauthorizedLeave);

                System.out.println(
                                "\nResult: Request rejected before "
                                                + "reaching Leave Management System.");

                // =====================================================
                // 7. ABSTRACT FACTORY - CONTRACT MEDICAL LEAVE
                // =====================================================

                System.out.println(
                                "\n\n========== 7. CONTRACT FACULTY POLICY ==========");

                System.out.println(
                                "\nContract faculty requesting Medical Leave:");

                Leave invalidContractLeave = LeaveAbstractFactory.getLeave(
                                "MedicalLeave",
                                contractFaculty,
                                5);

                if (invalidContractLeave == null) {

                        System.out.println(
                                        "SUCCESS: Contract Faculty "
                                                        + "cannot create Medical Leave.");

                } else {

                        System.out.println(
                                        "ERROR: Medical Leave was created.");
                }

                // -----------------------------------------------------
                // CONTRACT CASUAL LEAVE
                // -----------------------------------------------------

                System.out.println(
                                "\nContract faculty requesting "
                                                + "Casual Leave:");

                Leave validContractLeave = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                contractFaculty,
                                2);

                if (validContractLeave != null) {

                        System.out.println(
                                        "SUCCESS: Contract Faculty "
                                                        + "can create Casual Leave.");

                }

                // =====================================================
                // 8. JDBC CRUD DEMONSTRATION
                // =====================================================

                System.out.println(
                                "\n\n========== 8. JDBC CRUD ==========");

                // -----------------------------------------------------
                // CREATE
                // -----------------------------------------------------

                System.out.println(
                                "\n--- CREATE ---");

                Leave crudLeave = LeaveAbstractFactory.getLeave(
                                "CasualLeave",
                                contractFaculty,
                                1);

                crudLeave.setNotification(
                                new EmailNotification());

                int crudLeaveId = leaveDAO.createLeave(
                                crudLeave);

                System.out.println(
                                "Created Leave ID: "
                                                + crudLeaveId);

                // -----------------------------------------------------
                // READ
                // -----------------------------------------------------

                System.out.println(
                                "\n--- READ ---");

                leaveDAO.getLeave(
                                crudLeaveId);

                // -----------------------------------------------------
                // UPDATE
                // -----------------------------------------------------

                System.out.println(
                                "\n--- UPDATE ---");

                leaveDAO.updateLeaveStatus(
                                crudLeaveId,
                                "REVIEWED");

                System.out.println(
                                "Record after UPDATE:");

                leaveDAO.getLeave(
                                crudLeaveId);

                // -----------------------------------------------------
                // DELETE
                // -----------------------------------------------------

                System.out.println(
                                "\n--- DELETE ---");

                leaveDAO.deleteLeave(
                                crudLeaveId);

                System.out.println(
                                "Trying to READ deleted record:");

                leaveDAO.getLeave(
                                crudLeaveId);

                // =====================================================
                // 9. FINAL FACULTY RECORDS
                // =====================================================

                System.out.println(
                                "\n\n========== 9. DATABASE FACULTY RECORDS ==========");

                facultyDAO.displayAllFaculty();

                // =====================================================
                // END
                // =====================================================

                System.out.println(
                                "\n\n======================================================");

                System.out.println(
                                "        DEMONSTRATION COMPLETED");

                System.out.println(
                                "======================================================");
        }
}
