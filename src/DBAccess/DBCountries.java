/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Database.DBConnection;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wessl
 */
public class DBCountries {
    public static Dictionary<Integer, Country> countries = new Hashtable<Integer, Country>();
    
    public static ObservableList<Country> getAllCountries(){
        ObservableList<Country> cList = FXCollections.observableArrayList();
        String query = "select * from countries";
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("Country_Id");
                String name = rs.getString("Country");
                Country c = new Country(id, name);
                cList.add(c);
                countries.put(id, c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cList;
    }

    public static void checkDateConversion(){
        // TODO remove debug print
        System.out.println("CREATE DATE TEST");
        String query = "select Create_Date from countries";
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Timestamp ts = rs.getTimestamp("Create_Date");
                System.out.println("CD: " + ts.toLocalDateTime().toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
