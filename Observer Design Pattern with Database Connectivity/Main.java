public class Main {
        public static void main(String[] args) {
                Faculty f1 = FacultyFactory.getFaculty(
                                1001,
                                "Permanent",
                                "Saumya");

                Faculty f2 = FacultyFactory.getFaculty(
                                1002,
                                "Contract",
                                "John");

                ProxyStore pstore = new ProxyStore();
                Proxy proxy = new Proxy();

                pstore.register(
                                f1,
                                "XYZ");

                pstore.register(
                                f2,
                                "ABC");

                Leave leave = LeaveAbstractFactory.getLeave(
                                new MedicalLeave(
                                                "MedicalLeave",
                                                f1,
                                                5),
                                f1,
                                5);

                leave.setNotification(
                                new SMSNotification());

                LeaveDAO leaveDAO = new LeaveDAO();

                int leaveId = leaveDAO.createLeave(leave);

                leaveDAO.getLeave(leaveId);

                proxy.submitLeaveRequest(
                                f1,
                                "XYZ",
                                leave);

                leaveDAO.getLeave(leaveId);

                leaveDAO.updateLeaveStatus(
                                leaveId,
                                "REVIEWED");

                leaveDAO.getLeave(leaveId);
        }
}
