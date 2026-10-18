public class Doctor implements Department {
    private int doctorId;
    private String name;
    private HospitalMediator mediator;
    private Caretaker caretaker;

    public Doctor(String name) {
        this(0, name, new Caretaker());
    }

    public Doctor(int doctorId, String name) {
        this(doctorId, name, new Caretaker());
    }

    public Doctor(int doctorId, String name, Caretaker caretaker) {
        this.doctorId = doctorId;
        this.name = name;
        this.caretaker = (caretaker != null) ? caretaker : new Caretaker();
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Caretaker getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public void updateNotes(TreatmentRecord record, String notes) {
        if (record != null) {
            caretaker.saveState(record);
            record.setNotes(notes);
        }
    }

    public void undoLastChange(TreatmentRecord record) {
        if (record != null) {
            caretaker.undo(record);
        }
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
        consultDoctor();
    }

    @Override
    public void sendMessage(Department to, String message) {
        mediator.sendMessage(this, to, message);
    }

    @Override
    public String getName() {
        return name;
    }

    public void consultDoctor() {
        System.out.println("Consulting doctor.");
    }
}

