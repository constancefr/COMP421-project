import java.sql.* ;
import java.util.Scanner;
import java.sql.Connection;

class simpleJDBC {
    public static void main(String[] args) throws SQLException {

        // Registering the driver
        try {
            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());
        } catch (Exception cnfe) {
            System.out.println("Class not found");
        }

        // DB2 url
        String url = "jdbc:db2://winter2024-comp421.cs.mcgill.ca:50000/comp421";

        // TODO REMEMBER to remove your user id and password before submitting your code!!
//        String your_userid = "cfrach";
//        String your_password = "BQAEknFZT2W1";
        String your_userid = "cs421g41";
        String your_password = "group41queens";

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
                "\nHello and welcome to The Queen!\nGet ready for a data-driven delight in hospitality where SQL queries " +
                        "are as smooth as our freshly fluffed pillows.\n");
        int userInput = 0;
        while (userInput != 6) { // loop until user quits.
            userInput = menuPrompt();

            switch (userInput) {
                case 1: // make reservation
                    tasks.makeReservation(con, statement);
                    System.out.println("Your reservation was made. See you soon!");
                    break;
                case 2: // TODO cancel reservation

                    break;
                case 3: // check room availability
                    int availableCount = tasks.availableRooms(con, statement);
                    if (availableCount == 0) {
                        System.out.println("There are no rooms of this type available.");
                    } else {
                        System.out.println("There are " + availableCount + " rooms available.");
                    }
                    break;
                case 4: // TODO get customer support

                    break;
                case 5: // create rewards member account
                    int cid = tasks.createAccount(con, statement, true);
                    System.out.println("Your account was created. Here is you unique Rewards Member ID: " + cid);
                    break;
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
                    break;
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