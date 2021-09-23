/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Model.Customer;
import Database.DBConnection;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author wessl
 */
public class DBCustomers {
    public static Dictionary<Integer, Customer> customers = new Hashtable<Integer, Customer>();
    
    public static ObservableList<Customer> getAllCustomers() {
        ObservableList<Customer> cList = FXCollections.observableArrayList();
        String query = "SELECT * FROM customers";
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("Customer_ID");
                String name = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String zip = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int div = rs.getInt("Division_ID");
                Customer c = new Customer (id, name, address, zip, phone, div);
                customers.put(id, c);
                cList.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cList;
    }
    
    //  Saves a NEW Customer into the DB
    public static void save(Customer c) throws SQLException
    {
        String user = DBUsers.currentUser.getUsername();
        
        String command = "INSERT INTO customers VALUES (";
        
        command +=      c.id        + ", ";
        command += "'"  + c.name    + "', ";
        command += "'"  + c.address + "', ";
        command += "'"  + c.zip     + "', ";
        command += "'"  + c.phone   + "', ";
        command += "NOW(), ";
        command += "'"  + user      + "', ";
        command += "NOW(), ";
        command += "'"  + user      + "', ";
        command += c.division       + ") ";
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(command);
        ps.executeUpdate();
    }
    
    //  Updates an EXISTING Customer in the DB
    public static void update(Customer c) throws SQLException
    {
        String user = DBUsers.currentUser.getUsername();
        
        String command = "UPDATE customers SET ";
        
        command += "Customer_Name = '"  + c.name     + "', ";
        command += "Address = '"        + c.address  + "', ";
        command += "Postal_Code = '"    + c.zip      + "', ";
        command += "Phone = '"          + c.phone    + "', ";
        command += "Last_Update = NOW(), ";
        command += "Last_Updated_By = '" + user      + "', ";
        command += "Division_ID = "        + c.division + " ";
        
        command += "WHERE Customer_ID = " + c.id;
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(command);
        ps.executeUpdate();
    }
    
    //  Deletes an existing Customer
    public static void delete(Customer c) throws SQLException
    {
        String command = "DELETE FROM customers WHERE Customer_ID = " + c.id;
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(command);
        ps.executeUpdate();
    }
}
