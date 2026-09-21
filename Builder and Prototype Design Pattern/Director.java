public class Director {
    private PatientBuilder builder;
    private String type;

    public Director(PatientBuilder builder, String type) {
        this.builder = builder;
        this.type = type;
    }

    public void constructPatient() {
        builder.reset();

        if (type.equalsIgnoreCase("Outpatient")) {
            builder.setPatientId("P101");
            builder.setName("Rahul Sharma");
            builder.setAge(25);

            builder.setBloodGroup("B+");
            builder.setAllergies("None");
            builder.setMedicalHistory("Seasonal Allergy");
        } else if (type.equalsIgnoreCase("Inpatient")) {
            builder.setPatientId("P102");
            builder.setName("Priya Patel");
            builder.setAge(42);

            builder.setInsuranceDetails("Health Insurance");
            builder.setRoomType("Private Room");
            builder.setBloodGroup("O+");
            builder.setAllergies("Penicillin");
            builder.setEmergencyContact("9876543210");
            builder.setMedicalHistory("Diabetes");
        } else if (type.equalsIgnoreCase("Emergency Patient")) {
            builder.setPatientId("P103");
            builder.setName("Amit Verma");
            builder.setAge(31);

            builder.setBloodGroup("A-");
            builder.setAllergies("None");
            builder.setEmergencyContact("9123456789");
            builder.setMedicalHistory("Asthma");
        }
    }

    public Patient getPatient() {
        return builder.getPatient();
    }
}
