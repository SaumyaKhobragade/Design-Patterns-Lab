import java.util.Stack;

public class Caretaker {
    private Stack<TreatmentMemento> history = new Stack<>();

    public void saveState(TreatmentRecord record) {
        if (record != null) {
            history.push(record.createMemento());
        }
    }

    public void undo(TreatmentRecord record) {
        if (!history.isEmpty() && record != null) {
            TreatmentMemento memento = history.pop();
            record.restore(memento);
        }
    }

    public boolean canUndo() {
        return !history.isEmpty();
    }

    public int getHistorySize() {
        return history.size();
    }
}
