import java.sql.* ;
import java.util.Scanner;
public class tasks {

    public static int createAccount(Statement s, boolean isRewards){
        //generate cid
        String countCustomers = "SELECT COUNT(cid) FROM Customer";
        int rs = 0;
        try {
           rs = s.executeUpdate(countCustomers);
        } catch (SQLException e){
            e.printStackTrace();
        }
        int cid = rs+1;
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
        int ccnum = (int)cc_num;
        //get ccexpdate
        System.out.print("Input your credit card expiration date: \n");
        Date ccexpdate = Date.valueOf(scan.nextLine());
        String username = "";
        String pwd = "";
        int points = 0;
        if(isRewards) {
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        //RewardsMembers: cid, login, pwd, points
        if(isRewards){
            String addToRewards = "INSERT INTO RewardsMember " +
                    "VALUES (" + cid + ", " + username + ", " + pwd + ", " + points + ")";
            try {
                s.executeUpdate(addToRewards);
            } catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            String addToGuest = "INSERT INTO Guest " +
                    "VALUES (" + cid + ")";
            try {
                s.executeUpdate(addToGuest);
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return cid;
    }
}
