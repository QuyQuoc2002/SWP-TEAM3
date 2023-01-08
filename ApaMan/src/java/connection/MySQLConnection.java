package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AnhDT
 */
public class MySQLConnection {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "3306";
    public static final String DBNAME = "apamandb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345678";

    /**
     * Get connection to MSSQL Server
     * @return Connection
     */
    public static Connection getConnection() {
        
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DBNAME; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        }
        // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
