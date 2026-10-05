public class Reception implements Department {
    private String name;
    private HospitalMediator mediator;

    public Reception(String name) {
        this.name = name;
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
        registerPatient();
    }

    @Override
    public void sendMessage(Department to, String message) {
        mediator.sendMessage(this, to, message);
    }

    @Override
    public String getName() {
        return name;
    }

    public void registerPatient() {
        System.out.println("Patient registered.");
    }
}
