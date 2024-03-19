import java.sql.* ;
import java.util.Scanner;
import java.sql.Connection;

class simpleJDBC {
    public static void main(String[] args) throws SQLException {
        // Unique table names.  Either the user supplies a unique identifier as a command line argument, or the program makes one up.
        String tableName = "";
        int sqlCode = 0;      // Variable to hold SQLCODE
        String sqlState = "00000";  // Variable to hold SQLSTATE

        if (args.length > 0)
            tableName += args[0];
        else
            tableName += "exampletbl";

        // Register the driver.  You must register the driver before you can use it.
        try {
            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());
        } catch (Exception cnfe) {
            System.out.println("Class not found");
        }

        // This is the url you must use for DB2.
        //Note: This url may not valid now ! Check for the correct year and semester and server name.
        String url = "jdbc:db2://winter2024-comp421.cs.mcgill.ca:50000/comp421";

        //REMEMBER to remove your user id and password before submitting your code!!
        String your_userid = "mcheck";
        String your_password = "Shell7712345$";

        //AS AN ALTERNATIVE, you can just set your password in the shell environment in the Unix (as shown below) and read it from there.
        //$  export SOCSPASSWD=yoursocspasswd
        if (your_userid == null && (your_userid = System.getenv("SOCSUSER")) == null) {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        if (your_password == null && (your_password = System.getenv("SOCSPASSWD")) == null) {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }

        Connection con = DriverManager.getConnection(url, your_userid, your_password);
        Statement statement = con.createStatement();


        // TODO
        Scanner scan = new Scanner(System.in);
        System.out.println(
            "Hello and welcome to The Queen! Get ready for a data-driven delight in hospitality where SQL queries " +
            "are as smooth as our freshly fluffed pillows. Your comfort is our primary key, and your satisfaction is " +
            "our indexed priority. Enjoy a stay where even the nerdiest get a warm, relational welcome!\n");
        int userInput = 0;
        while (userInput != 6) { // loop until user quits.
            userInput = menuPrompt();

            switch (userInput) {
                case 1: // make reservation
                    tasks.makeReservation(con, statement);
                    System.out.println("Your reservation was made. See you soon!");
                case 2: // cancel reservation

                case 3: // check room availability
                    int availableCount = tasks.availableRooms(statement);
                    if (availableCount == 0) {
                        System.out.println("There are no rooms of this type available.");
                    } else {
                        System.out.println("There are " + availableCount + " rooms available.");
                    }
                case 4: // get customer support

                case 5: // create rewards member account
                    int cid = tasks.createAccount(con, statement, true);
                    System.out.println("Your account was created. Here is you unique Rewards Member ID: " + cid);
                case 6: // quit
                    System.out.println("Thank you for staying at The Queen. Your satisfaction is our primary key, " +
                            "so please rate your experience with us today!\n");
                    System.out.println("* | ** | *** | **** | *****");
                    String userRating = scan.nextLine();
                    if (userRating.equals("*****")) {
                        System.out.println("Splendid, we hope to see you soon!");
                    } else {
                        System.out.println("Bye!");
                    }
            }
        }

        // Close the statement and connection
        statement.close();
        con.close();
    }

    public static int menuPrompt() {
        Scanner scan = new Scanner(System.in);
        int userInput = 0;
        String menu = "Please select an option to start:\n"
                + "1) Make a reservation for a room, event or amenity\n"
                + "2) Cancel a reservation\n"
                + "3) Check the availability of a certain room type\n"
                + "4) Redeem your points for a stay\n"
                + "5) Create a rewards member\n"
                + "6) Quit\n";
        System.out.println(menu);
        userInput = Integer.parseInt(scan.nextLine());

        return userInput;
    }

}
