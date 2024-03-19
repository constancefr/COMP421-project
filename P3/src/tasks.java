import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.* ;

public class tasks {

    public static int makeReservation(Connection c, Statement s) {
        Scanner scan = new Scanner(System.in);

        int cid1 = initializeCustomer(c, s);

        System.out.println("Where would you like to make your reservation?\n");
        System.out.println("1) Montreal\n2) Toronto\n3) Vancouver\n4) Ottawa\n5) Halifax\n6) Calgary");
        String location1 = scan.nextLine();
        switch (location1) {
            case "1":
                location1 = "Montreal";
                break;
            case "2":
                location1 = "Toronto";
                break;
            case "3":
                location1 = "Vancouver";
                break;
            case "4":
                location1 = "Ottawa";
                break;
            case "5":
                location1 = "Halifax";
                break;
            case "6":
                location1 = "Calgary";
                break;
            default:
                System.out.println("Invalid input.");
        }

        System.out.println("Please enter the start date for your reservation (YYYY-MM-DD)...");
        String startDate1 = "'" + scan.nextLine() + "'";
        System.out.println("...and the end date.");
        String endDate1 = "'" + scan.nextLine() + "'";
        System.out.println("How many people will be there?");
        int numberOfPeople1 = Integer.valueOf(scan.nextLine());

        String addToReservation = "INSERT INTO Reservation" + " (cid, numberOfPeople, startDate, endDate)"
                + " VALUES (" + cid1 + ", " + numberOfPeople1 + ", " + startDate1 + ", " + endDate1 + ")";
        System.out.println(addToReservation);

        // DB2 GENERATES UNIQUE CID AUTOMATICALLY!!
        int generatedRID = 0;
        try (PreparedStatement pstmt = c.prepareStatement(addToReservation, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.executeUpdate(addToReservation);
            ResultSet generatedKey = pstmt.getGeneratedKeys();
            generatedRID = generatedKey.getInt(1);
            System.out.println("New CID generated: " + generatedRID);
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
        }
//        String tableName = "Reservation";
//        try {
//            String insertSQL = "INSERT INTO " + tableName + " (cid, numberOfPeople, startDate, endDate)" + " VALUES (CID, numPeople, startDate, endDate)";
//            System.out.println(insertSQL);
//            s.executeUpdate(insertSQL);
//            System.out.println("DONE");
//        } catch (SQLException e) {
//            int sqlCode = e.getErrorCode(); // Get SQLCODE
//            String sqlState = e.getSQLState(); // Get SQLSTATE
//            // something more meaningful than a print would be good
//            System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
//            System.out.println(e);
//        }

        boolean valid = false;
        while (!valid) {
            System.out.println("Please select the type of reservation you would like to make.\n");
            System.out.println("1) Room reservation\n2) Event booking\n3) Use amenity");
            String reservationType = scan.nextLine();
            switch (reservationType) {
                case "1":
                    valid = true;
                    // TODO: test reserve room
                    reserveRoom(c, s, location1, generatedRID);
                case "2":
                    valid = true;
                    // TODO: test event booking
                    bookEvent(c, s, startDate1, location1, generatedRID);
                case "3":
                    valid = true;
                    // TODO: test book amenity
                    scheduleAmenity(c, s, location1, startDate1, generatedRID);
                default:
                    System.out.println("Invalid input.");
            }
        }

        return 0;
    }

    public static int reserveRoom(Connection c, Statement s, String location1, int rid1) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which type of room would you like?\n");
        System.out.println("1) Single\n2) Double\n3) Suite");
        String roomType1 = scan.nextLine();
        switch (roomType1) {
            case "1":
                roomType1 = "Single";
                break;
            case "2":
                roomType1 = "Double";
                break;
            case "3":
                roomType1 = "Suite";
                break;
            default:
                System.out.println("Invalid input.");
        }

        // Allocate room number automatically
        int roomNumber1 = findAvailableRoom(c, location1, roomType1);
        if (roomNumber1 == 0) {
            System.out.println("No available " + roomType1 + " room found.");
        }

        String addToReserve = "INSERT INTO Reserve" + " (rid, location, roomNumber)" + " VALUES (" + rid1 + ", " + location1 + ", " + roomNumber1 + ")";
        System.out.println(addToReserve);

        try (PreparedStatement pstmt = c.prepareStatement(addToReserve)) {
            pstmt.executeUpdate(addToReserve);
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
        }
        return 0;
    }

    public static int findAvailableRoom(Connection c, String location1, String roomType1) {
        String query = "SELECT * FROM Room WHERE roomAvail = ? AND location = ? AND roomType = ? LIMIT 1";

        // Find first available room matching the required type
        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setBoolean(1, true);
            pstmt.setString(2, location1);
            pstmt.setString(3, roomType1);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Retrieve room details from the ResultSet
                int roomNumber1 = rs.getInt("roomNumber");
                return roomNumber1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int bookEvent(Connection c, Statement s, String eventDate1, String location1, int rid1) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What venue?\n");
        System.out.println("1) Garden\n2) Ballroom\n3) Rooftop");
        String venue1 = scan.nextLine();
        switch (venue1) {
            case "1":
                venue1 = "Garden";
                break;
            case "2":
                venue1 = "Ballroom";
                break;
            case "3":
                venue1 = "Rooftop";
                break;
            default:
                System.out.println("Invalid input.");
        }

        System.out.println("Will it be a catered event? (y/n)");
        String userInput = scan.nextLine();
        boolean cateredFlag1 = false;
        switch (userInput) {
            case "y":
                cateredFlag1 = true;
                break;
            case "n":
                cateredFlag1 = false;
                break;
            default:
                System.out.println("Invalid input.");
        }

        String addToEvent = "INSERT INTO Event" + " (location, eventDate, venue, cateredFlag, rid)"
                + " VALUES (" + location1 + ", " + eventDate1 + ", " + venue1 + ", " + cateredFlag1 + ", " + rid1 + ")";
        System.out.println(addToEvent);

        try (PreparedStatement pstmt = c.prepareStatement(addToEvent)) {
            pstmt.executeUpdate(addToEvent);
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
        }
        return 0;
    }

    public static int scheduleAmenity(Connection c, Statement s, String date1, String location1, int rid1) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which amenity or service would you like to schedule?\n");
        System.out.println("1) Spa\n2) Gym\n3) Pool\n4) Movie Room\n5) Bar & Restaurant\n6) Game Room");
        String amenityType1 = scan.nextLine();
        switch (amenityType1) {
            case "1":
                amenityType1 = "Spa";
            case "2":
                amenityType1 = "Gym";
            case "3":
                amenityType1 = "Pool";
            case "4":
                amenityType1 = "Movie Room";
            case "5":
                amenityType1 = "Bar & Restaurant";
            case "6":
                amenityType1 = "Game Room";
            default:
                System.out.println("Invalid input.");
        }

        System.out.println("Please enter a time for your reservation (e.g. 18:30:00)");
        String timeSlot1 = date1 + " " + scan.nextLine();

        String query = "SELECT * FROM Amenity WHERE location = ? AND amenityType = ? LIMIT 1";


        int floorNumber1 = 0;
        String amenityName1 = "";
        // Find first available room matching the required type
        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setString(1, location1);
            pstmt.setString(2, amenityType1);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Retrieve room details from the ResultSet
                amenityName1 = rs.getString("amenityName");
                floorNumber1 = rs.getInt("floorNumber");
            } else {
                System.out.println("This amenity is unavailable in " + location1 + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String addToSchedule = "INSERT INTO Schedule" + " (rid, location, timeSlot, floorNumber, amenityName)"
                + " VALUES (" + rid1 + ", " + location1 + ", " + timeSlot1 + ", " + floorNumber1 + ", " + amenityName1 + ")";
        System.out.println(addToSchedule);

        try (PreparedStatement pstmt = c.prepareStatement(addToSchedule)) {
            pstmt.executeUpdate(addToSchedule);
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
        }

        return 0;
    }

    public static int initializeCustomer(Connection c, Statement s) {
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
                    CID = createAccount(c, s, true); // create member account
                } else if (userInput.equals("n")) {
                    CID = createAccount(c, s, false); // create guest account
                } else {
                    valid = false;
                }

            } else {
                System.out.println("Invalid input.");
            }
        }
        return CID;
    }

    public static int createAccount(Connection c, Statement s, boolean isRewards) {
        //generate cid
//        String countCustomers = "SELECT COUNT(cid) FROM Customer";
//        int rs = 0;
//        try {
//            rs = s.executeUpdate(countCustomers);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        int cid = rs + 1;
        Scanner scan = new Scanner(System.in);

        //get name
        System.out.print("Input your name: \n");
        String name1 = scan.nextLine();
        //get email
        System.out.print("Input your email: \n");
        String email1 = scan.nextLine();
        //get phone number
        System.out.print("Input your phone number: \n");
        String phoneNumber1 = scan.nextLine();
        //get address
        System.out.print("Input your address: \n");
        String address1 = scan.nextLine();
        //get ccnum
        System.out.print("Input your credit card number: \n");
        String ccnum1 = scan.nextLine();
//        Integer cc_num = Integer.parseInt(scan.nextLine());
//        int ccnum = (int) cc_num;
        //get ccexpdate
        System.out.println("Input your credit card expiration date (YYYY-MM-DD):");
        String ccexpdate1 = "'" + scan.nextLine() + "'"; // reformatted so it fits DB2's DATE format
//        System.out.print("Input your credit card expiration date: \n");
//        Date ccexpdate = Date.valueOf(scan.nextLine());

        String username1 = "";
        String pwd1 = "";
        int points1 = 0;
        if (isRewards) {
            //get login
            System.out.print("Input your login username: \n");
            username1 = scan.nextLine();
            //get pwd
            System.out.print("Input your login password: \n");
            pwd1 = scan.nextLine();
            //initialize points
            points1 = 0;
        }

        //execute SQL statement that inserts this new user into the Customer table and RewardsMember table
        //Customer: cid, name, email, phone_number, address, ccnum, ccexp

      //  String addToCustomer = "INSERT INTO Customer" + " (name, email, phone_number, address, ccnum, ccexpdate)" + " VALUES (name1, email1, phoneNumber1, address1, ccnum1, ccexpdate1)";
       // System.out.println(addToCustomer);
        String addToCustomer = "INSERT INTO Customer" + " (name, email, phone_number, address, ccnum, ccexpdate)" +
                "VALUES (" + name1 + ", " + phoneNumber1 + ", " + address1 + ", " +
                ccnum1 + ", " + ccexpdate1 + ")";

        // DB2 GENERATES UNIQUE CID AUTOMATICALLY!!
        int generatedCID = 0;
        try (PreparedStatement pstmt = c.prepareStatement(addToCustomer, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.executeUpdate(addToCustomer);
            ResultSet generatedKey = pstmt.getGeneratedKeys();
            generatedCID = generatedKey.getInt(1);
            System.out.println("New CID generated: " + generatedCID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try {
//            s.executeUpdate(addToCustomer);
//            System.out.println("DONE");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        //RewardsMembers: cid, login, pwd, points
        if (isRewards) {
        //    String addToRewards = "INSERT INTO RewardsMember" + " (cid, login, pwd, points)" + " VALUES (generatedCID, username1, pwd1, points1)";
           // System.out.println(addToRewards);
            String addToRewards = "INSERT INTO RewardsMember " +
                    "VALUES (" + generatedCID + ", " + username1 + ", " + pwd1 + ", " + points1 + ")";
            try {
                s.executeUpdate(addToRewards);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String addToGuest = "INSERT INTO Guest " +
                    "VALUES (" + generatedCID + ")";
           /* String addToGuest = "INSERT INTO Guest " +
                    "VALUES (generatedCID)";*/
            try {
                s.executeUpdate(addToGuest);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return generatedCID;
    }


    public static int availableRooms(Statement s) { // , String location, String type
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a hotel location.\n");
        System.out.println("1) Montreal\n2) Toronto\n3) Vancouver\n4) Ottawa\n5) Halifax\n6) Calgary");
        String location1 = scan.nextLine();
        switch (location1) {
            case "1":
                location1 = "Montreal";
                break;
            case "2":
                location1 = "Toronto";
                break;
            case "3":
                location1 = "Vancouver";
                break;
            case "4":
                location1 = "Ottawa";
                break;
            case "5":
                location1 = "Halifax";
                break;
            case "6":
                location1 = "Calgary";
                break;
            default:
                System.out.println("Invalid input.");
        }

        System.out.println("Select a room type.\n");
        System.out.println("1) Single\n2) Double\n3) Suite");
        String roomType1 = scan.nextLine();

        int rs = 0;
        switch (roomType1) {
            case "1":
                roomType1 = "Single";
                break;
            case "2":
                roomType1 = "Double";
                break;
            case "3":
                roomType1 = "Suite";
                break;
            default:
                System.out.println("Invalid input.");

                String getCountOfAvailRooms = "SELECT COUNT(*) FROM Room r" +
                        "WHERE (r.location = " + location1 + " AND r.roomType = " + roomType1 +
                        ")";

                try {
                    rs = s.executeUpdate(getCountOfAvailRooms);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return rs;
    }

    public static void cancelRes (Connection c, Statement s){
        //Scanner to get rid from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the rid of the reservation you would like to cancel: ");
        Integer i = Integer.parseInt(sc.nextLine());
        int rid1 = (int) i;

        //delete rid from reservation table
        String deleteRes = "DELETE FROM Reservation" +
                "WHERE rid = " + rid1 + "";
        try {
            s.executeUpdate(deleteRes);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int whichRelation = 0;
        //scan tables to see if it is a room, amenity, or event
        String roomDeleteQuery = "SELECT * FROM Reserve WHERE rid = ?";
        try (PreparedStatement pstmt1 = c.prepareStatement(roomDeleteQuery)) {
            pstmt1.setInt(1, rid1);
            ResultSet rs = pstmt1.executeQuery();
            if (rs.next()) {
                whichRelation = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String amenityDeleteQuery = "SELECT * FROM Schedule WHERE rid = ?";
        try (PreparedStatement pstmt2 = c.prepareStatement(amenityDeleteQuery)) {
            pstmt2.setInt(1, rid1);
            ResultSet rs = pstmt2.executeQuery();
            if (rs.next()) {
                whichRelation = 2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String eventDeleteQuery = "SELECT * FROM Event WHERE rid = ?";
        try (PreparedStatement pstmt3 = c.prepareStatement(eventDeleteQuery)) {
            pstmt3.setInt(1, rid1);
            ResultSet rs = pstmt3.executeQuery();
            if (rs.next()) {
                whichRelation = 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String deleteBooking = "DELETE FROM ? WHERE rid = " + rid1 + "";
        switch (whichRelation) {
            case 1:
                try (PreparedStatement delstmt1 = c.prepareStatement(deleteBooking)) {
                    delstmt1.setString(1, "Reserve");
                    delstmt1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 2:
                try (PreparedStatement delstmt2 = c.prepareStatement(deleteBooking)) {
                    delstmt2.setString(1, "Schedule");
                    delstmt2.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 3:
                try (PreparedStatement delstmt3 = c.prepareStatement(deleteBooking)) {
                    delstmt3.setString(1, "Event");
                    delstmt3.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getSupport (Connection c, Statement s){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the location of the hotel you would like to contact:\n" +
                "1: Montreal\n" +
                "2: Ottawa\n" +
                "3: Toronto\n" +
                "4: Halifax\n" +
                "5: Calgary\n" +
                "6: Vancouver");
        String hotelLocation = scan.nextLine();
        String loc = "";
        switch (hotelLocation) {
            case "1":
                loc = "Montreal";
            case "2":
                loc = "Ottawa";
            case "3":
                loc = "Toronto";
            case "4":
                loc = "Halifax";
            case "5":
                loc = "Calgary";
            case "6":
                loc = "Vancouver";
        }

        String query = "SELECT * FROM Employee WHERE (location = ? AND department = ?";
        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setString(1, loc);
            pstmt.setString(2, "Front Desk");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                //retrieve phone number of first front desk employee
                String phoneNumber = rs.getString("phone_number");
                return phoneNumber;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

}