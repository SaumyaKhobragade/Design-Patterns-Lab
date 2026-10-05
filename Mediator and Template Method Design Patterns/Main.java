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
        }
}
