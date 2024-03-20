import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
//        String startDate1 = scan.nextLine();
//        String startDate1 = "'" + scan.nextLine() + "'";
        Date startDate1 = Date.valueOf(scan.nextLine());
        System.out.println("...and the end date.");
//        String endDate1 = scan.nextLine();
//        String endDate1 = "'" + scan.nextLine() + "'";
        Date endDate1 = Date.valueOf(scan.nextLine());
        System.out.println("How many people will be there?");
        int numberOfPeople1 = Integer.parseInt(scan.nextLine());

//        String addToReservation = "INSERT INTO Reservation" + " (cid, numberOfPeople, startDate, endDate)"
//                + " VALUES (" + cid1 + ", " + numberOfPeople1 + ", " + startDate1 + ", " + endDate1 + ")";
//        String addToReservation = "INSERT INTO Reservation" + " (cid, numberOfPeople, startDate, endDate)"
//                + " VALUES (" + cid1 + ", " + numberOfPeople1 + ", CAST(" + startDate1 + " AS DATE)" + ", CAST(" + endDate1 + " AS DATE)" + ")";
        String addToReservation = "INSERT INTO Reservation (cid, numberOfPeople, startDate, endDate) VALUES (?, ?, ?, ?)";

        System.out.println(addToReservation);

        // DB2 GENERATES UNIQUE CID AUTOMATICALLY!!
        int generatedRID = 0;
        try (PreparedStatement pstmt = c.prepareStatement(addToReservation, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, cid1);
            pstmt.setInt(2, numberOfPeople1);
            pstmt.setDate(3, startDate1);
            pstmt.setDate(4, endDate1);
            pstmt.executeUpdate();
            ResultSet generatedKey = pstmt.getGeneratedKeys();
            if (generatedKey.next()) {
                generatedRID = generatedKey.getInt(1);
                System.out.println("New RID generated: " + generatedRID);
            }
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
        }

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
                    break;
                case "2":
                    valid = true;
                    // TODO: test event booking
                    bookEvent(c, s, startDate1, location1, generatedRID);
                    break;
                case "3":
                    valid = true;
                    // TODO: test book amenity
                    scheduleAmenity(c, s, startDate1, location1, generatedRID);
                    break;
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

        String addToReserve = "INSERT INTO Reserve (rid, location, roomNumber) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = c.prepareStatement(addToReserve)) {
            pstmt.setInt(1, rid1);
            pstmt.setString(2, location1);
            pstmt.setInt(3, roomNumber1);

            pstmt.executeUpdate();
            System.out.println("Reservation added successfully.");
            return 1; // indicate success
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // indicate failure
        }
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

    public static int bookEvent(Connection c, Statement s, Date eventDate1, String location1, int rid1) {
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

        String addToEvent = "INSERT INTO Event (location, eventDate, venue, cateredFlag, rid) VALUES (?, ?, ?, ?, ?)";
        System.out.println(addToEvent);

        try (PreparedStatement pstmt = c.prepareStatement(addToEvent)) {
            pstmt.setString(1, location1);
            pstmt.setDate(2, eventDate1);
            pstmt.setString(3, venue1);
            pstmt.setBoolean(4, cateredFlag1);
            pstmt.setInt(5, rid1);

            pstmt.executeUpdate();
            System.out.println("Event booked successfully.");
            return 1; // success
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
            return 0; // failure
        }
    }

    public static int scheduleAmenity(Connection c, Statement s, Date date1, String location1, int rid1) {
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
        String dateTime = date1 + " " + scan.nextLine();
        Timestamp timeSlot1 = Timestamp.valueOf(dateTime);

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

        String addToSchedule = "INSERT INTO Schedule (rid, location, timeSlot, floorNumber, amenityName) VALUES (?, ?, ?, ?, ?)";
//        String addToSchedule = "INSERT INTO Schedule" + " (rid, location, timeSlot, floorNumber, amenityName)"
//                + " VALUES (" + rid1 + ", " + location1 + ", CAST(" + timeSlot1 + " AS DATETIME), " + floorNumber1 + ", " + amenityName1 + ")";
        System.out.println(addToSchedule);

        try (PreparedStatement pstmt = c.prepareStatement(addToSchedule)) {
            pstmt.setInt(1, rid1);
            pstmt.setString(2, location1);
            pstmt.setTimestamp(3, timeSlot1);
            pstmt.setInt(4, floorNumber1);
            pstmt.setString(5, amenityName1);

            pstmt.executeUpdate();
            System.out.println("Amenity scheduled successfully.");
            return 1;
        } catch (SQLException e) {
//          TODO: handle errors??
            e.printStackTrace();
            return 0;
        }
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
                // TODO!! Check that CID exists
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
        //get ccexpdate
        System.out.println("Input your credit card expiration date (YYYY-MM-DD):");
        Date ccexpdate1 = Date.valueOf(scan.nextLine());

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
        String addToCustomer = "INSERT INTO Customer (name, email, phone_number, address, ccnum, ccexpdate) VALUES (?, ?, ?, ?, ?, ?)";

        // DB2 GENERATES UNIQUE CID AUTOMATICALLY!!
        int generatedCID = 0;
        try (PreparedStatement pstmt = c.prepareStatement(addToCustomer, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, name1);
            pstmt.setString(2, email1);
            pstmt.setString(3, phoneNumber1);
            pstmt.setString(4, address1);
            pstmt.setString(5, ccnum1);
            pstmt.setDate(6, ccexpdate1);

            pstmt.executeUpdate();
            ResultSet generatedKey = pstmt.getGeneratedKeys();
            if (generatedKey.next()) {
                generatedCID = generatedKey.getInt(1);
                System.out.println("New CID generated: " + generatedCID);
            }
            System.out.println("Account created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //RewardsMembers: cid, login, pwd, points
        if (isRewards) {
            String addToRewards = "INSERT INTO RewardsMember (cid, login, pwd, points) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(addToRewards)) {
                //generateCID
                //username1
                //pwd1
                //points1
                pstmt.setInt(1, generatedCID);
                pstmt.setString(2, username1);
                pstmt.setString(3, pwd1);
                pstmt.setInt(4, points1);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String addToGuest = "INSERT INTO Guest " +
                    "VALUES (?)";
           /* String addToGuest = "INSERT INTO Guest " +
                    "VALUES (generatedCID)";*/
            try (PreparedStatement pstmt = c.prepareStatement(addToGuest)) {
                pstmt.setInt(1, generatedCID);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return generatedCID;
    }


    public static int availableRooms(Connection c, Statement s) { // , String location, String type
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

        int roomCount = 0;
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
                        "WHERE (r.location = ? AND r.roomType = ?)";

                try (PreparedStatement pstmt = c.prepareStatement(getCountOfAvailRooms)) {
                    pstmt.setString(1, location1);
                    pstmt.setString(2, roomType1);
                    ResultSet rs = pstmt.executeQuery();
                    if(rs.next()){
                        roomCount = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return roomCount;
    }

    public static int cancelRes (Connection c, Statement s){
        //Scanner to get rid from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the rid of the reservation you would like to cancel: ");
        Integer i = Integer.parseInt(sc.nextLine());
        int rid1 = (int) i;

        //delete rid from reservation table
        String deleteRes = "DELETE FROM Reservation" +
                "WHERE rid = ?";
        try (PreparedStatement pstmt = c.prepareStatement(deleteRes)) {
            pstmt.setInt(1, rid1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int whichRelation = 0;
        //scan tables to see if it is a room, amenity, or event
        String roomDeleteQuery = "SELECT * FROM ? WHERE rid = ?";
        try (PreparedStatement pstmt1 = c.prepareStatement(roomDeleteQuery)) {
            pstmt1.setString(1, "Reserve");
            pstmt1.setInt(2, rid1);
            ResultSet rs = pstmt1.executeQuery();
            if (rs.next()) {
                whichRelation = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String amenityDeleteQuery = "SELECT * FROM ? WHERE rid = ?";
        try (PreparedStatement pstmt2 = c.prepareStatement(amenityDeleteQuery)) {
            pstmt2.setString(1, "Schedule");
            pstmt2.setInt(2, rid1);
            ResultSet rs = pstmt2.executeQuery();
            if (rs.next()) {
                whichRelation = 2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String eventDeleteQuery = "SELECT * FROM ? WHERE rid = ?";
        try (PreparedStatement pstmt3 = c.prepareStatement(eventDeleteQuery)) {
            pstmt3.setString(1, "Event");
            pstmt3.setInt(2, rid1);
            ResultSet rs = pstmt3.executeQuery();
            if (rs.next()) {
                whichRelation = 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String deleteBooking = "DELETE FROM ? WHERE rid = ?";
        switch (whichRelation) {
            case 1:
                try (PreparedStatement delstmt1 = c.prepareStatement(deleteBooking)) {
                    delstmt1.setString(1, "Reserve");
                    delstmt1.setInt(2, rid1);
                    delstmt1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try (PreparedStatement delstmt2 = c.prepareStatement(deleteBooking)) {
                    delstmt2.setString(1, "Schedule");
                    delstmt2.setInt(2, rid1);
                    delstmt2.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try (PreparedStatement delstmt3 = c.prepareStatement(deleteBooking)) {
                    delstmt3.setString(1, "Event");
                    delstmt3.setInt(2, rid1);
                    delstmt3.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        return 0;
    }

    public static void getSupport (Connection c, Statement s){
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

        String query = "SELECT name, phone_number FROM Employee WHERE (location = ? AND department = ?)";
        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setString(1, loc);
            pstmt.setString(2, "Front Desk");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //retrieve phone number of first front desk employee
                //String phoneNumber = rs.getString("phone_number");
                //String employeeName = rs.getString("name");
                for(int i = 1; i <= 2; i++){
                    //1: prints employee name
                    //2: prints employee phone number
                    System.out.println(rs.getString(i));
                }
                //return phoneNumber;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return "";
    }

}