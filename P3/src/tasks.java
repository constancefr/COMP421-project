import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.* ;

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
                } catch (NumberFormatException e) {
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

    public static int createAccount(Statement s, boolean isRewards) {
        //generate cid
        String countCustomers = "SELECT COUNT(cid) FROM Customer";
        int rs = 0;
        try {
            rs = s.executeUpdate(countCustomers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int cid = rs + 1;
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();
        //get name
        System.out.print("Input your name: \n");
        String name = scan.nextLine();
        //get email
        System.out.print("Input your email: \n");
        String email = scan.nextLine();
        //get phone number
        System.out.print("Input your phone number: \n");
        String phoneNumber = scan.nextLine();
        //get address
        System.out.print("Input your address: \n");
        String address = scan.nextLine();
        //get ccnum
        System.out.print("Input your credit card number: \n");
        Integer cc_num = Integer.parseInt(scan.nextLine());
        int ccnum = (int) cc_num;
        //get ccexpdate
        System.out.print("Input your credit card expiration date: \n");
        Date ccexpdate = Date.valueOf(scan.nextLine());
        String username = "";
        String pwd = "";
        int points = 0;
        if (isRewards) {
            //get login
            System.out.print("Input your login username: \n");
            username = scan.nextLine();
            //get pwd
            System.out.print("Input your login password: \n");
            pwd = scan.nextLine();
            //initialize points
            points = 0;
        }

        //execute SQL statement that inserts this new user into the Customer table and RewardsMember table
        //Customer: cid, name, address, ccnum, ccexp
        String addToCustomer = "INSERT INTO Customer" +
                "VALUES (" + cid + ", " + name + ", " + phoneNumber + ", " + address + ", " +
                ccnum + ", " + ccexpdate + ")";
        try {
            s.executeUpdate(addToCustomer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //RewardsMembers: cid, login, pwd, points
        if (isRewards) {
            String addToRewards = "INSERT INTO RewardsMember " +
                    "VALUES (" + cid + ", " + username + ", " + pwd + ", " + points + ")";
            try {
                s.executeUpdate(addToRewards);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String addToGuest = "INSERT INTO Guest " +
                    "VALUES (" + cid + ")";
            try {
                s.executeUpdate(addToGuest);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cid;
    }


    public static boolean isRoomAvailable(Statement s, String location, String type){
        String getCountOfAvailRooms = "SELECT COUNT(*) FROM Room r" +
                "WHERE (r.location = " + location + " AND r.roomType = " + type +
                ")";
        int rs = 0;
        try {
            rs = s.executeUpdate(getCountOfAvailRooms);
        } catch(SQLException e){
            e.printStackTrace();
        }
        if(rs == 0){
            return false;
        }
        return true;
    }


}
