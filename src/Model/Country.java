/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Database.DBConnection;

/**
 *
 * @author wessl
 */
public class Country {
    private final int id;
    private final String name;
    
    public Country(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int getID(){
        return id;
    }
    
    @Override
    public String toString(){
        String s = "Country " + String.valueOf(id) + ":\t";
        s += name;
        return s;
    }
  //    This was in the sample code, I don't think it's necessary here...
//    public static void checkDateConversion(){
//        System.out.println("Create date test:");
//        String sql = "select Create_Date from countries";
//        try {
//            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Timestamp ts = rs.getTimestamp()
//            }
//        }
//    }
}
