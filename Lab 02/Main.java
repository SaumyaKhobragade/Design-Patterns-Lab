public class Main {
    public static void main(String[] args) {
        ProxyStore pstore = new ProxyStore();
        Proxy p = new Proxy();
        System.out.println(ProxyStore.db.containsKey("Saumya") ? "User exists." : "Does not exist.");
        p.submitLeaveRequest("Saumya", "XYZ", "CasualLeave", 10);
    }
}
