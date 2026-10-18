public interface Department {
    void setMediator(HospitalMediator mediator);
    void receiveMessage(String message);
    void sendMessage(Department to, String message);

    String getName();
}
