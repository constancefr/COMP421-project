import java.sql.* ;
import java.util.Scanner;

class simpleJDBC
{
    public static void main ( String [ ] args ) throws SQLException
    {
        // Unique table names.  Either the user supplies a unique identifier as a command line argument, or the program makes one up.
        String tableName = "";
        int sqlCode=0;      // Variable to hold SQLCODE
        String sqlState="00000";  // Variable to hold SQLSTATE

        if ( args.length > 0 )
            tableName += args [ 0 ] ;
        else
            tableName += "exampletbl";

        // Register the driver.  You must register the driver before you can use it.
        try { DriverManager.registerDriver ( new com.ibm.db2.jcc.DB2Driver() ) ; }
        catch (Exception cnfe){ System.out.println("Class not found"); }

        // This is the url you must use for DB2.
        //Note: This url may not valid now ! Check for the correct year and semester and server name.
        String url = "jdbc:db2://winter2024-comp421.cs.mcgill.ca:50000/comp421";

        //REMEMBER to remove your user id and password before submitting your code!!
        String your_userid = "cfrach";
        String your_password = "BQAEknFZT2W1";

        //AS AN ALTERNATIVE, you can just set your password in the shell environment in the Unix (as shown below) and read it from there.
        //$  export SOCSPASSWD=yoursocspasswd
        if(your_userid == null && (your_userid = System.getenv("SOCSUSER")) == null)
        {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        if(your_password == null && (your_password = System.getenv("SOCSPASSWD")) == null)
        {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }

        Connection con = DriverManager.getConnection (url,your_userid,your_password) ;

        Statement statement = con.createStatement ( ) ;


        // TODO
        String userInput = printMenu();

        // TODO: while user input != 6 (loop and print menu again after task complete)

        if (userInput.equals("1")) {

        if (userInput.equals("1")) {
            // call method 1
        } else if (userInput.equals("2")) {
            // etc.
        } else {
            // print error message
            // reprint menu
        }

        // Finally but importantly close the statement and connection
        statement.close ( ) ;
        con.close ( ) ;
        System.out.println("here now");
    }

    public static String printMenu() {
        // TODO: print menu
        // Parse input and read arguments
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        System.out.println(userInput);
        return userInput;
    }
}
