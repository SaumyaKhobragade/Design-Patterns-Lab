public class Billing implements Department {
    private String name;
    private HospitalMediator mediator;

    public Billing(String name) {
        this.name = name;
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
        processBilling();
    }

    @Override
    public void sendMessage(Department to, String message) {
        mediator.sendMessage(this, to, message);
    }

    @Override
    public String getName() {
        return name;
    }

    public void processBilling() {
        System.out.println("Processing payment.");
    }
}
