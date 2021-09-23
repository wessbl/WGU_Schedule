/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Database.DBConnection;
import Model.Contact;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author wessl
 */
public class DBContacts {
    public static Dictionary <Integer, Contact> contacts = new Hashtable<Integer, Contact>();
    
    //  Get all the contacts
    public static ObservableList<Contact> getAllContacts(){
        ObservableList<Contact> cList = FXCollections.observableArrayList();
        String query = "SELECT * from contacts";
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                int id = rs.getInt("Contact_ID");
                String name = rs.getString("Contact_Name");
                String email = rs.getString("Email");
                
                Contact c = new Contact(id, name, email);
                cList.add(c);
                contacts.put(id, c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cList;
    }
}
