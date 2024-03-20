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

        System.out.println("Where would you like to make your reservation?");
        System.out.println("1) Montreal\n2) Toronto\n3) Vancouver\n4) Ottawa\n5) Halifax\n6) Calgary");
        String location1 = scan.nextLine();

        boolean valid = false;
        while (!valid) {
            switch (location1) {
                case "1":
                    valid = true;
                    location1 = "Montreal";
                    break;
                case "2":
                    valid = true;
                    location1 = "Toronto";
                    break;
                case "3":
                    valid = true;
                    location1 = "Vancouver";
                    break;
                case "4":
                    valid = true;
                    location1 = "Ottawa";
                    break;
                case "5":
                    valid = true;
                    location1 = "Halifax";
                    break;
                case "6":
                    valid = true;
                    location1 = "Calgary";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 6.");
                    location1 = scan.nextLine();
            }
        }

        System.out.println("Please enter the start date for your reservation (YYYY-MM-DD)...");
        Date startDate1 = Date.valueOf(scan.nextLine());
        System.out.println("...and the end date.");
        Date endDate1 = Date.valueOf(scan.nextLine());
        System.out.println("How many people will be there?");
        int numberOfPeople1 = Integer.parseInt(scan.nextLine());

        String addToReservation = "INSERT INTO Reservation (cid, numberOfPeople, startDate, endDate) VALUES (?, ?, ?, ?)";

        // DB2 GENERATES UNIQUE CID AUTOMATICALLY
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
                System.out.println("Here is your reservation ID: " + generatedRID + "\n");
            }
        } catch (SQLException e) {
            return -1;
        }

        valid = false;
        while (!valid) {
            System.out.println("Please select the type of reservation you would like to make.");
            System.out.println("1) Room reservation\n2) Event booking\n3) Use amenity");
            String reservationType = scan.nextLine();
            switch (reservationType) {
                case "1":
                    valid = true;
                    int roomResult = reserveRoom(c, s, location1, generatedRID);
                    if (roomResult == -1) {
                        return -1;
                    }
                    break;
                case "2":
                    valid = true;
                    int eventResult = bookEvent(c, s, startDate1, location1, generatedRID);
                    if (eventResult == -1) {
                        return -1;
                    }
                    break;
                case "3":
                    valid = true;
                    // TODO: test book amenity
                    scheduleAmenity(c, s, startDate1, location1, generatedRID);
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 3.");
                    reservationType = scan.nextLine();
            }
        }

        return 0;
    }

    public static int reserveRoom(Connection c, Statement s, String location1, int rid1) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which type of room would you like?");
        System.out.println("1) Single\n2) Double\n3) Suite");
        String roomType1 = scan.nextLine();

        boolean valid = false;
        while (!valid) {
            switch (roomType1) {
                case "1":
                    valid = true;
                    roomType1 = "Single";
                    break;
                case "2":
                    valid = true;
                    roomType1 = "Double";
                    break;
                case "3":
                    valid = true;
                    roomType1 = "Suite";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 3.");
                    roomType1 = scan.nextLine();
            }
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
            return 0; // indicate success
        } catch (SQLException e) {
            return -1; // indicate failure
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
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int bookEvent(Connection c, Statement s, Date eventDate1, String location1, int rid1) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What venue?");
        System.out.println("1) Garden\n2) Ballroom\n3) Rooftop");
        String venue1 = scan.nextLine();

        boolean valid = false;
        while (!valid) {
            switch (venue1) {
                case "1":
                    valid = true;
                    venue1 = "Garden";
                    break;
                case "2":
                    valid = true;
                    venue1 = "Ballroom";
                    break;
                case "3":
                    valid = true;
                    venue1 = "Rooftop";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 3.");
                    venue1 = scan.nextLine();
            }
        }

        System.out.println("Will it be a catered event? (y/n)");
        String userInput = scan.nextLine();
        boolean cateredFlag1 = false;

        valid = false;
        while (!valid) {
            switch (userInput) {
                case "y":
                    valid = true;
                    cateredFlag1 = true;
                    break;
                case "n":
                    valid = true;
                    cateredFlag1 = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter yes (y) or no (n).");
                    userInput = scan.nextLine();
            }
        }

        String addToEvent = "INSERT INTO Event (location, eventDate, venue, cateredFlag, rid) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = c.prepareStatement(addToEvent)) {
            pstmt.setString(1, location1);
            pstmt.setDate(2, eventDate1);
            pstmt.setString(3, venue1);
            pstmt.setBoolean(4, cateredFlag1);
            pstmt.setInt(5, rid1);

            pstmt.executeUpdate();
            System.out.println("Event booked successfully.");
            return 0; // success
        } catch (SQLException e) {
            return -1; // failure
        }
    }

    public static int scheduleAmenity(Connection c, Statement s, Date date1, String location1, int rid1) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Which amenity or service would you like to schedule?");
        System.out.println("1) Spa\n2) Gym\n3) Pool\n4) Movie Room\n5) Bar & Restaurant\n6) Game Room");
        String amenityType1 = scan.nextLine();

        boolean valid = false;
        while (!valid) {
            switch (amenityType1) {
                case "1":
                    valid = true;
                    amenityType1 = "Spa";
                    break;
                case "2":
                    valid = true;
                    amenityType1 = "Gym";
                    break;
                case "3":
                    valid = true;
                    amenityType1 = "Pool";
                    break;
                case "4":
                    valid = true;
                    amenityType1 = "Movie Room";
                    break;
                case "5":
                    valid = true;
                    amenityType1 = "Bar & Restaurant";
                    break;
                case "6":
                    valid = true;
                    amenityType1 = "Game Room";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 6.");
                    amenityType1 = scan.nextLine(); // rescan
            }
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
            return -1;
        }

        String addToSchedule = "INSERT INTO Schedule (rid, location, timeSlot, floorNumber, amenityName) VALUES (?, ?, ?, ?, ?)";

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
            return -1;
        }
    }

    public static int initializeCustomer(Connection c, Statement s) {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        int CID = 0;

        System.out.println("Are you an existing Rewards Member? (y/n)");
        String userInput = scan.nextLine();

        while (!valid) {
            switch (userInput) {
                case "y":
                    valid = true;
                    System.out.println("Please enter your Rewards Member number (CID).");
                    userInput = scan.nextLine();

                    boolean valid2 = false;
                    while (!valid2) {
                        try {
                            CID = Integer.parseInt(userInput);
                            valid2 = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, please enter a number.");
                            userInput = scan.nextLine();
                        }
                    }

                    if (!checkCIDExists(c, CID)) {
                        valid = false;
                        System.out.println("This CID does not exist in our records.\n");
                        System.out.println("Are you an existing Rewards Member? (y/n)");
                        userInput = scan.nextLine();
                    }
                    break;

                case "n":
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
                    break;

                default:
                    System.out.println("Invalid input, please enter yes (y) or no (n).");
                    userInput = scan.nextLine();
            }
        }
        return CID;
    }

    public static boolean checkCIDExists(Connection c, int cid) {
        boolean exists = false;
        String query = "SELECT COUNT(*) FROM RewardsMember WHERE cid = ?";

        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setInt(1, cid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    exists = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("An error has occurred, please try again with a valid input.");
        }

        return exists;
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
            return -1; // failure
        }

        //RewardsMembers: cid, login, pwd, points
        if (isRewards) {
            String addToRewards = "INSERT INTO RewardsMember (cid, login, pwd, points) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = c.prepareStatement(addToRewards)) {
                pstmt.setInt(1, generatedCID);
                pstmt.setString(2, username1);
                pstmt.setString(3, pwd1);
                pstmt.setInt(4, points1);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                return -1; // failure
            }
        } else {
            String addToGuest = "INSERT INTO Guest VALUES (?)";
            try (PreparedStatement pstmt = c.prepareStatement(addToGuest)) {
                pstmt.setInt(1, generatedCID);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                return -1; // failure
            }
        }
        return generatedCID;
    }


    public static int availableRooms(Connection c, Statement s) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a hotel location.");
        System.out.println("1) Montreal\n2) Toronto\n3) Vancouver\n4) Ottawa\n5) Halifax\n6) Calgary");
        String location1 = scan.nextLine();

        boolean valid = false;
        while (!valid) {
            switch (location1) {
                case "1":
                    valid = true;
                    location1 = "Montreal";
                    break;
                case "2":
                    valid = true;
                    location1 = "Toronto";
                    break;
                case "3":
                    valid = true;
                    location1 = "Vancouver";
                    break;
                case "4":
                    valid = true;
                    location1 = "Ottawa";
                    break;
                case "5":
                    valid = true;
                    location1 = "Halifax";
                    break;
                case "6":
                    valid = true;
                    location1 = "Calgary";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 6.");
            }
        }

        System.out.println("Select a room type.");
        System.out.println("1) Single\n2) Double\n3) Suite");
        String roomType1 = scan.nextLine();

        int roomCount = 0;
        valid = false;
        while (!valid) {
            switch (roomType1) {
                case "1":
                    valid = true;
                    roomType1 = "Single";
                    break;
                case "2":
                    valid = true;
                    roomType1 = "Double";
                    break;
                case "3":
                    valid = true;
                    roomType1 = "Suite";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 3.");
            }
        }

        String getCountOfAvailRooms = "SELECT COUNT(*) FROM Room r WHERE (r.location = ? AND r.roomType = ?)";

        try (PreparedStatement pstmt = c.prepareStatement(getCountOfAvailRooms)) {
            pstmt.setString(1, location1);
            pstmt.setString(2, roomType1);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                roomCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            return -1;
        }

        return roomCount;
    }

    public static int cancelRes (Connection c, Statement s){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the rid of the reservation you would like to cancel: ");
        int rid1 = Integer.parseInt(sc.nextLine());

        String[] tablesToDeleteFrom = {"Reservation", "Reserve", "Schedule", "Event"};
        for (String table : tablesToDeleteFrom) {
            String deleteQuery = "DELETE FROM " + table + " WHERE rid = ?";
            try (PreparedStatement pstmt = c.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, rid1);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    return 0; // Successfully deleted from at least one table
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1; // Rid not found in any table
    }

    public static int getSupport (Connection c, Statement s){
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

        boolean valid = false;
        while (!valid) {
            switch (hotelLocation) {
                case "1":
                    valid = true;
                    loc = "Montreal";
                    break;
                case "2":
                    valid = true;
                    loc = "Ottawa";
                    break;
                case "3":
                    valid = true;
                    loc = "Toronto";
                    break;
                case "4":
                    valid = true;
                    loc = "Halifax";
                    break;
                case "5":
                    valid = true;
                    loc = "Calgary";
                    break;
                case "6":
                    valid = true;
                    loc = "Vancouver";
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1 to 6.");
            }
        }

        String query = "SELECT name, phone_number FROM Employee WHERE (location = ? AND department = ?)";
        try (PreparedStatement pstmt = c.prepareStatement(query)) {
            pstmt.setString(1, loc);
            pstmt.setString(2, "Front Desk");

            ResultSet rs = pstmt.executeQuery();
            System.out.println("Here is a front desk employee at your desired location:");
            while (rs.next()) {
                for(int i = 1; i <= 2; i++){
                    //1: prints employee name
                    //2: prints employee phone number
                    System.out.println(rs.getString(i));
                }
                System.out.println("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

}