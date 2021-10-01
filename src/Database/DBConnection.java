package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author wessl
 */
public abstract class DBConnection {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcURL = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sqlUser";
    private static String password = "Passw0rd!";
    public static Connection connection;

    public static void startConnection()
    {
            try {
                    Class.forName(driver);
                    connection = DriverManager.getConnection(jdbcURL, userName, password);
            }
            catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
            }
    }
    
    public static Connection getConnection()
    {
        return connection;
    }

    public static void closeConnection() {
            try{
                connection.close();
            }
            catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
    }
}
