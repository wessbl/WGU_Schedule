/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import Database.DBConnection;
import Model.Division;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wessl
 */
public class DBDivisions {
    public static Dictionary<Integer, Division> divisions = new Hashtable<Integer, Division>();
    
    public static ObservableList<Division> getAllDivisions(){
        ObservableList<Division> dList = FXCollections.observableArrayList();
        String query = "SELECT * FROM first_level_divisions";
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("Division_ID");
                String name = rs.getString("Division");
                int country = rs.getInt("Country_ID");
                Division d = new Division (id, name, country);
                divisions.put(id, d);
                dList.add(d);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dList;
    }
    
}
