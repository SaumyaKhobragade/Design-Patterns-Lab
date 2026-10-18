import java.util.ArrayList;
import java.util.List;

public class Patient {
    protected int id;
    protected String patientId;
    protected String name;
    protected int age;

    protected PatientType type;

    protected String paymentCategory;
    protected String contactNo;
    protected String insuranceDetails;
    protected String roomType;
    protected String bloodGroup;
    protected String allergies;
    protected String emergencyContact;
    protected String medicalHistory;
    protected List<Service> services = new ArrayList<>();

    public Patient() {
    }

    public Patient(int id, String name, String paymentCategory, String contactNo) {
        this.id = id;
        this.patientId = "P" + id;
        this.name = name;
        this.paymentCategory = paymentCategory;
        this.contactNo = contactNo;
        this.emergencyContact = contactNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
        if (this.emergencyContact == null) {
            this.emergencyContact = contactNo;
        }
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services != null ? services : new ArrayList<>();
    }

    public void addService(Service service) {
        if (service != null) {
            this.services.add(service);
        }
    }

    public void setInsuranceDetails(String insuranceDetails) {
        this.insuranceDetails = insuranceDetails;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
        if (this.contactNo == null) {
            this.contactNo = emergencyContact;
        }
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setType(PatientType type) {
        this.type = type;
    }

    public PatientType getType() {
        return type;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Type: " + type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Patient ID: ").append(patientId);
        if (id != 0) {
            sb.append(" (Numeric ID: ").append(id).append(")");
        }
        sb.append("\nName: ").append(name)
          .append("\nAge: ").append(age)
          .append("\nType: ").append(type);
        if (paymentCategory != null) {
            sb.append("\nPayment Category: ").append(paymentCategory);
        }
        if (contactNo != null) {
            sb.append("\nContact No: ").append(contactNo);
        }
        sb.append("\nInsurance Details: ").append(insuranceDetails)
          .append("\nRoom Type: ").append(roomType)
          .append("\nBlood Group: ").append(bloodGroup)
          .append("\nAllergies: ").append(allergies)
          .append("\nEmergency Contact: ").append(emergencyContact)
          .append("\nMedical History: ").append(medicalHistory);
        return sb.toString();
    }
}

