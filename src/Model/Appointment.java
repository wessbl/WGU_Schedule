/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author wessl
 */
public class Appointment {
    public final int id;
    public String title;
    public String description;
    public String location;
    public String type;
    public LocalDateTime start;
    public LocalDateTime end;
//    public final LocalDateTime createDate;
//    public final String createdBy;
//    public final LocalDateTime lastUpdate;
//    public final String updatedBy;
    public int customerID;
    public int userID;
    public int contactID;
    
    public Appointment(int id, String title, String description, String location, 
            String type, LocalDateTime start, LocalDateTime end, int customerID, 
            int userID, int contactID){
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.start = start;
        this.end = end;
//        this.createDate = createDate;
//        this.createdBy = createdBy;
//        this.lastUpdate = lastUpdate;
//        this.updatedBy = updatedBy;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
    }
    
    //  Returns a database-friendly string version of start date/time
    public String getStartText() {
        String s = "";
        s += start;
        s = s.replace('T', ' ');
        if (s.length() > 19)
            return s.substring(0, 20);
        return s;
    }
    
    //  Returns a database-friendly string version of end date/time
    public String getEndText() {
        String s = "";
        s += end;
        s = s.replace('T', ' ');
        if (s.length() > 19)
            return s.substring(0, 20);
        return s;
    }
    
    @Override
    public String toString(){
        String s = "Appointment " + id + ":\t";
        s += title          + "\t";
        s += description    + "\t";
        s += location       + "\t";
        s += type           + "\t";
        s += getStartText() + "\t";
        s += getEndText()   + "\t";
        s += customerID     + "\t";
        s += userID         + "\t";
        s += contactID      + "\t";
        return s;
    }
}