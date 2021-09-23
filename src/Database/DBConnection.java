package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author wessl
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://wgudb.ucertify.com:3306/WJ07pEy";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "U07pEy";
    private static final String PASSWORD = "53689095355";
    
    private static Connection connection = null;
    
    public static Connection startConnection()
    {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public static Connection getConnection()
    {
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
        }
        catch (Exception e){
            // No worries :)
        }
    }
}
