public class LoggerTest {
    public static void main(String[] args) {
        // Retrieve Logger instance for the first time
        Logger logger1 = Logger.getInstance();
        logger1.log("User has opened the application dashboard.");

        // Retrieve Logger instance again
        Logger logger2 = Logger.getInstance();
        logger2.log("User has clicked on the 'Generate Report' button.");

        // Verify both instances are the same
        if (logger1 == logger2) {
            System.out.println("Confirmed: Both logger1 and logger2 point to the same Logger instance.");
        } else {
            System.out.println("Warning: logger1 and logger2 are different instances!");
        }
    }
}
