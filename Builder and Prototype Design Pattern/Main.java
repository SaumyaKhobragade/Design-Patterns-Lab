public class Main {

        public static void main(String[] args) {

                // =========================================
                // BUILDER PATTERN
                // =========================================

                PatientBuilder builder1 = new ConcretePatientBuilder();

                Director director1 = new Director(builder1, "Outpatient");

                director1.constructPatient();

                Patient outpatient = director1.getPatient();

                System.out.println(outpatient);

                System.out.println(
                                "\n==========================================");

                PatientBuilder builder2 = new ConcretePatientBuilder();

                Director director2 = new Director(builder2, "Inpatient");

                director2.constructPatient();

                Patient inpatient = director2.getPatient();

                System.out.println(inpatient);

                System.out.println(
                                "\n==========================================");

                PatientBuilder builder3 = new ConcretePatientBuilder();

                Director director3 = new Director(builder3, "Emergency Patient");

                director3.constructPatient();

                Patient emergencyPatient = director3.getPatient();

                System.out.println(emergencyPatient);

                System.out.println(
                                "\n==========================================");

                // =========================================
                // PROTOTYPE PATTERN
                // =========================================

                ConcretePatientPrototype prototype = new ConcretePatientPrototype(inpatient);

                Patient clonedPatient = prototype.clone();

                clonedPatient.setName("Priya Sharma");
                clonedPatient.setRoomType("ICU");

                System.out.println("\nOriginal Patient:");

                System.out.println(inpatient);

                System.out.println("\nCloned Patient:");

                System.out.println(clonedPatient);
        }
}
