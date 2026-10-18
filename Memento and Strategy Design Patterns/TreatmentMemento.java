import java.util.Date;

public class TreatmentMemento {
    private final String notes;
    private final Date timestamp;

    public TreatmentMemento(String notes, Date timestamp) {
        this.notes = notes;
        this.timestamp = timestamp != null ? new Date(timestamp.getTime()) : new Date();
    }

    public String getNotes() {
        return notes;
    }

    public Date getTimestamp() {
        return new Date(timestamp.getTime());
    }

    @Override
    public String toString() {
        return "TreatmentMemento [Notes: \"" + notes + "\", Timestamp: " + timestamp + "]";
    }
}
