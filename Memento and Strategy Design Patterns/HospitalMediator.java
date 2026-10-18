public interface HospitalMediator {
    void registerDepartment(Department dept);
    void sendMessage(Department from, Department to, String message);
    void notify(String message);
}
