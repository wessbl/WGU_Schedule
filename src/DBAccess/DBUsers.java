/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Model.User;
import Database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author wessl
 */
public class DBUsers {
    public static User currentUser;
    
    public static User login(String user, String password) throws Exception
    {
        String query = "SELECT * FROM users WHERE User_Name = \"" + user + "\"";
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            if (password.equals(rs.getString("Password"))){
                int id = rs.getInt("User_ID");
                String username = rs.getString("User_Name");
                currentUser = new User(id, username);
            } else {
                throw new Exception("Login credentials are incorrect!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return currentUser;
    }
}
