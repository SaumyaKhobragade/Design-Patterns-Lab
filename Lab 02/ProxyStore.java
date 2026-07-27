import java.util.HashMap;

public class ProxyStore {
    public static HashMap<String,String> db = new HashMap<>();

    public ProxyStore() {
        db.put("Saumya", "XYZ");
        db.put("Hardik", "ABC");
        db.put("Saptanshu", "1010");
    }

    public static void register(String user,String password) {

        if(db.containsKey(user)) {
            System.out.println("User already exists.");
        } else {
            db.put(user,password);
        }
    }

    public static boolean authenticate(String user,String password) {
        if(!db.containsKey(user)) {
            return false;   
        } else if(!db.get(user).equals(password)) {
            return false;
        } else {
            return true;
        }
    }

}
