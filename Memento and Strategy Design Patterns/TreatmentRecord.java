import java.util.Date;

public class TreatmentRecord {
    private int id;
    private int patientId;
    private String notes;
    private Date lastUpdated;

    public TreatmentRecord(int id, int patientId, String initialNotes) {
        this.id = id;
        this.patientId = patientId;
        this.notes = initialNotes;
        this.lastUpdated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
        this.lastUpdated = new Date();
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public TreatmentMemento createMemento() {
        return new TreatmentMemento(this.notes, this.lastUpdated);
    }

    public void restore(TreatmentMemento memento) {
        if (memento != null) {
            this.notes = memento.getNotes();
            this.lastUpdated = memento.getTimestamp();
        }
    }

    @Override
    public String toString() {
        return "TreatmentRecord [Record ID: " + id + ", Patient ID: " + patientId
                + ", Notes: \"" + notes + "\", Last Updated: " + lastUpdated + "]";
    }
}
