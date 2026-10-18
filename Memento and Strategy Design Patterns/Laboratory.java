public class Laboratory implements Department {
    private String name;
    private HospitalMediator mediator;

    public Laboratory(String name) {
        this.name = name;
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
        performTests();
    }

    @Override
    public void sendMessage(Department to, String message) {
        mediator.sendMessage(this, to, message);
    }

    @Override
    public String getName() {
        return name;
    }

    public void performTests() {
        System.out.println("Performing laboratory tests.");
    }
}
