import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class tasks {

    public static int makeReservation(Statement statement) {
        Scanner scan = new Scanner(System.in);

        // TODO: generate RID

        System.out.println("When would you like to arrive? (YYYY-MM-DD)");
        String startDate = scan.nextLine();
        System.out.println("When will you be leaving? (YYYY-MM-DD)");
        String endDate = scan.nextLine();
        System.out.println("How many people will be there?");
        int numPeople = Integer.valueOf(scan.nextLine());
        
        // TODO: set startDate, endDate, numPeople in DB



        try {
            String insertSQL = "INSERT INTO " + tableName + " VALUES ( 1 , \'Vicki\' ) ";
            System.out.println(insertSQL);
            statement.executeUpdate(insertSQL);
            System.out.println("DONE");

            insertSQL = "INSERT INTO " + tableName + " VALUES ( 2 , \'Vera\' ) ";
            System.out.println(insertSQL);
            statement.executeUpdate(insertSQL);
            System.out.println("DONE");
            insertSQL = "INSERT INTO " + tableName + " VALUES ( 3 , \'Franca\' ) ";
            System.out.println(insertSQL);
            statement.executeUpdate(insertSQL);
            System.out.println("DONE");

        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE

            // Your code to handle errors comes here;
            // something more meaningful than a print would be good
            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
            System.out.println(e);
        }
        return 0;
    }

    public static int initializeCustomer(Statement statement) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int CID = 0;

        while (!valid) {
            System.out.println("Are you an existing Rewards Member? (y/n)");
            String userInput = scan.nextLine();
            if (userInput.equals("y")) {
                valid = true;
                System.out.println("Please enter your Rewards Member number (CID).");
                userInput = scan.nextLine();
                try {
                    CID = Integer.parseInt(userInput);
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid CID.");
                    CID = 0;
                }

            } else if (userInput.equals("n")) {
                valid = true;
                System.out.println("Would you like to become a Rewards Member? Members accumulate points and can redeem them for discounts :) (y/n)");
                userInput = scan.nextLine();
                if (userInput.equals("y")) {
                    // TODO: call function to create new member
                    CID = 0; // createAccount(true);
                } else if (userInput.equals("n")) {
                    // TODO: call function to create guest
                    CID = 0; // createAccount(false);
                } else {
                    valid = false;
                }

            } else {
                System.out.println("Invalid input.");
            }
        }
        return CID;
    }

}
