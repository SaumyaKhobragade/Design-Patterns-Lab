import java.util.HashMap;

public class ProxyStore {
    public static HashMap<String,String> db = new HashMap<>();

    public ProxyStore() {
        db.put("demo", "demo");
        db.put("demo1", "demo1");
        db.put("demo2", "demo2");
        db.put("demo3", "demo3");
        db.put("demo4", "demo4");
    }

    public void register(Faculty faculty, String password) {
        if(db.containsKey(faculty.getFacultyName())) {
            System.out.println("User already exists.");
        } else {
            db.put(faculty.getFacultyName(), password);
        }
    }

    public static boolean authenticate(Faculty faculty, String password) {
        if(!db.containsKey(faculty.getFacultyName())) {
            return false;   
        } else if(!db.get(faculty.getFacultyName()).equals(password)) {
            return false;
        } else {
            return true;
        }
    }
}
