import java.util.ArrayList;
import java.util.List;

public class Main {

        public static void main(String[] args) {

                // =========================================
                // BUILDER PATTERN
                // =========================================

                PatientBuilder builder1 = new ConcretePatientBuilder();

                Director director1 = new Director(
                                builder1,
                                "Outpatient");

                director1.constructPatient();

                Patient outpatient = director1.getPatient();

                System.out.println(outpatient);

                System.out.println(
                                "\n==========================================");

                PatientBuilder builder2 = new ConcretePatientBuilder();

                Director director2 = new Director(
                                builder2,
                                "Inpatient");

                director2.constructPatient();

                Patient inpatient = director2.getPatient();

                System.out.println(inpatient);

                System.out.println(
                                "\n==========================================");

                PatientBuilder builder3 = new ConcretePatientBuilder();

                Director director3 = new Director(
                                builder3,
                                "Emergency Patient");

                director3.constructPatient();

                Patient emergencyPatient = director3.getPatient();

                System.out.println(emergencyPatient);

                // =========================================
                // PROTOTYPE PATTERN
                // =========================================

                System.out.println(
                                "\n==========================================");

                ConcretePatientPrototype prototype = new ConcretePatientPrototype(
                                inpatient);

                Patient clonedPatient = prototype.clone();

                clonedPatient.setName(
                                "Priya Sharma");

                clonedPatient.setRoomType(
                                "ICU");

                System.out.println(
                                "\nOriginal Patient:");

                System.out.println(inpatient);

                System.out.println(
                                "\nCloned Patient:");

                System.out.println(clonedPatient);

                // =========================================
                // MEDIATOR PATTERN
                // =========================================

                System.out.println(
                                "\n==========================================");

                System.out.println(
                                "\nMEDIATOR PATTERN");

                HospitalMediator coordinator = new HospitalCoordinator();

                Department reception = new Reception("Reception");

                Department doctor = new Doctor("Doctor");

                Department laboratory = new Laboratory("Laboratory");

                Department pharmacy = new Pharmacy("Pharmacy");

                Department billing = new Billing("Billing");

                coordinator.registerDepartment(
                                reception);

                coordinator.registerDepartment(
                                doctor);

                coordinator.registerDepartment(
                                laboratory);

                coordinator.registerDepartment(
                                pharmacy);

                coordinator.registerDepartment(
                                billing);

                reception.sendMessage(
                                doctor,
                                "Patient P102 has arrived for consultation.");

                doctor.sendMessage(
                                laboratory,
                                "Diagnostic tests are required for Patient P102.");

                laboratory.sendMessage(
                                pharmacy,
                                "Test results are ready for Patient P102.");

                pharmacy.sendMessage(
                                billing,
                                "Prescription generated for Patient P102.");

                coordinator.notify(
                                "Patient P102 treatment workflow completed.");

                // =========================================
                // TEMPLATE METHOD PATTERN
                // =========================================

                System.out.println(
                                "\n==========================================");

                System.out.println(
                                "\nTEMPLATE METHOD PATTERN");

                System.out.println(
                                "\nOUTPATIENT TREATMENT");

                AbstractPatientTreatment outpatientTreatment = new OutpatientTreatment(
                                outpatient);

                outpatientTreatment.processTreatment();

                System.out.println(
                                "\nINPATIENT TREATMENT");

                AbstractPatientTreatment inpatientTreatment = new InpatientTreatment(
                                inpatient);

                inpatientTreatment.processTreatment();

                System.out.println(
                                "\nEMERGENCY TREATMENT");

                AbstractPatientTreatment emergencyTreatment = new EmergencyTreatment(
                                emergencyPatient);

                emergencyTreatment.processTreatment();

                // =========================================
                // STRATEGY PATTERN (Practical 7)
                // =========================================

                System.out.println(
                                "\n==========================================");

                System.out.println(
                                "\nSTRATEGY PATTERN - BILLING");

                HospitalSystem hospitalSystem = new HospitalSystem();

                Patient billingPatient = new Patient(105, "Ananya Verma", "Insurance", "9876501234");
                billingPatient.setType(PatientType.INPATIENT);

                List<Service> services = new ArrayList<>();
                services.add(new Service(1, "General Consultation", 500.00));
                services.add(new Service(2, "Complete Blood Count (CBC)", 1200.00));
                services.add(new Service(3, "Chest X-Ray", 1800.00));
                services.add(new Service(4, "Pharmacy Medication", 1500.00));

                billingPatient.setServices(services);

                System.out.println("\nPatient Details for Billing:");
                System.out.println("Patient ID: " + billingPatient.getPatientId()
                                + ", Name: " + billingPatient.getName()
                                + ", Default Payment Category: " + billingPatient.getPaymentCategory());

                System.out.println("\nServices Availed:");
                double totalServiceAmount = 0.0;
                for (Service s : services) {
                        System.out.println(" - " + s);
                        totalServiceAmount += s.getAmount();
                }
                System.out.println(String.format("Total Service Cost: ₹%.2f", totalServiceAmount));

                System.out.println("\n--- Calculating Bills Across All Strategies ---");

                // 1. Self-Pay Strategy
                hospitalSystem.selectBillingStrategy("Self-Pay");
                double selfPayBill = hospitalSystem.generateBill(billingPatient);
                System.out.println(String.format("1. Strategy: Self-Pay (100%% payable)       -> Amount Due: ₹%.2f", selfPayBill));

                // 2. Insurance Strategy
                hospitalSystem.selectBillingStrategy("Insurance");
                double insuranceBill = hospitalSystem.generateBill(billingPatient);
                System.out.println(String.format("2. Strategy: Insurance (20%% payable)      -> Amount Due: ₹%.2f", insuranceBill));

                // 3. Corporate Strategy
                hospitalSystem.selectBillingStrategy("Corporate");
                double corporateBill = hospitalSystem.generateBill(billingPatient);
                System.out.println(String.format("3. Strategy: Corporate (70%% payable)      -> Amount Due: ₹%.2f", corporateBill));

                // 4. Senior Citizen Strategy
                hospitalSystem.selectBillingStrategy("Senior Citizen");
                double seniorBill = hospitalSystem.generateBill(billingPatient);
                System.out.println(String.format("4. Strategy: Senior Citizen (80%% payable) -> Amount Due: ₹%.2f", seniorBill));

                // Demonstrate input validation for invalid strategy
                try {
                        hospitalSystem.selectBillingStrategy("Charity");
                } catch (IllegalArgumentException e) {
                        System.out.println("Dynamic validation: " + e.getMessage());
                }

                // =========================================
                // MEMENTO PATTERN (Practical 7)
                // =========================================

                System.out.println(
                                "\n==========================================");

                System.out.println(
                                "\nMEMENTO PATTERN - TREATMENT RECORDS");

                Doctor attendingDoctor = new Doctor(201, "Dr. Rajesh Kulkarni");

                System.out.println("\nDoctor: " + attendingDoctor.getName() + " (ID: " + attendingDoctor.getDoctorId() + ")");

                TreatmentRecord treatmentRecord = new TreatmentRecord(
                                501,
                                102,
                                "Initial Consultation: Patient reports persistent fever and dry cough for 3 days."
                );

                System.out.println("\n[Initial State]");
                System.out.println(treatmentRecord);

                System.out.println("\n--- Doctor Updates Treatment Notes ---");

                // Note Update 1
                System.out.println("\n>> Doctor Update 1: Ordered lab tests and prescribed antipyretic.");
                attendingDoctor.updateNotes(
                                treatmentRecord,
                                "Lab Investigation: CBC and Chest X-Ray ordered. Prescribed Paracetamol 650mg TDS."
                );
                System.out.println("Current Record: " + treatmentRecord.getNotes());
                System.out.println("Last Updated: " + treatmentRecord.getLastUpdated());

                // Note Update 2
                System.out.println("\n>> Doctor Update 2: Lab results reviewed, diagnosed mild bronchitis.");
                attendingDoctor.updateNotes(
                                treatmentRecord,
                                "Diagnosis: Mild acute bronchitis. Commenced Amoxicillin 500mg TDS and steam inhalation."
                );
                System.out.println("Current Record: " + treatmentRecord.getNotes());
                System.out.println("Last Updated: " + treatmentRecord.getLastUpdated());

                // Note Update 3
                System.out.println("\n>> Doctor Update 3: Final follow-up notes.");
                attendingDoctor.updateNotes(
                                treatmentRecord,
                                "Follow-up: Patient stable. Chest clear on auscultation. Advised discharge with 3-day rest."
                );
                System.out.println("Current Record: " + treatmentRecord.getNotes());
                System.out.println("Last Updated: " + treatmentRecord.getLastUpdated());

                System.out.println("\n--- Demonstrating Undo Operations (Memento Restoration) ---");

                // Undo 1
                System.out.println("\n>> Performing Undo 1 (Revert to Update 2)...");
                attendingDoctor.undoLastChange(treatmentRecord);
                System.out.println("Restored Notes: " + treatmentRecord.getNotes());
                System.out.println("Restored Timestamp: " + treatmentRecord.getLastUpdated());
                System.out.println("Can further undo? " + attendingDoctor.getCaretaker().canUndo());

                // Undo 2
                System.out.println("\n>> Performing Undo 2 (Revert to Update 1)...");
                attendingDoctor.undoLastChange(treatmentRecord);
                System.out.println("Restored Notes: " + treatmentRecord.getNotes());
                System.out.println("Restored Timestamp: " + treatmentRecord.getLastUpdated());
                System.out.println("Can further undo? " + attendingDoctor.getCaretaker().canUndo());

                // Undo 3
                System.out.println("\n>> Performing Undo 3 (Revert to Initial State)...");
                attendingDoctor.undoLastChange(treatmentRecord);
                System.out.println("Restored Notes: " + treatmentRecord.getNotes());
                System.out.println("Restored Timestamp: " + treatmentRecord.getLastUpdated());
                System.out.println("Can further undo? " + attendingDoctor.getCaretaker().canUndo());

                // Undo 4 when stack is empty
                System.out.println("\n>> Attempting Undo 4 (Stack is now empty)...");
                if (attendingDoctor.getCaretaker().canUndo()) {
                        attendingDoctor.undoLastChange(treatmentRecord);
                } else {
                        System.out.println("canUndo() returned false: No previous states remaining. Undo skipped safely.");
                }
                System.out.println("Final Record State: " + treatmentRecord.getNotes());
        }
}
