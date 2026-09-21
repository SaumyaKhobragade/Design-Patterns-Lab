public class EmergencyPatient extends Patient {
    private String emergencyContact;

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
        super.setEmergencyContact(emergencyContact);
    }

    @Override
    public String toString() {
        return "EMERGENCY PATIENT\n"
                + super.toString()
                + "\nEmergency Contact: " + emergencyContact;
    }
}
