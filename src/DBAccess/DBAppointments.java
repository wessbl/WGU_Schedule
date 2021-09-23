package DBAccess;

import Database.DBConnection;
import Model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Dictionary;
import java.util.Hashtable;

public class DBAppointments {
    public static Dictionary<Integer, Appointment> appointments;
    private static int nextID = -1;
    
    public static ObservableList<Appointment> getAllAppointments(){
        appointments = new Hashtable<Integer, Appointment>();
        ObservableList<Appointment> aList = FXCollections.observableArrayList();
        String query = "SELECT * FROM appointments";
        
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDate date = rs.getDate("Start").toLocalDate();
                LocalTime time = rs.getTime("Start").toLocalTime();
                LocalDateTime start = LocalDateTime.of(date, time);
                date = rs.getDate("End").toLocalDate();
                time = rs.getTime("End").toLocalTime();
                LocalDateTime end = LocalDateTime.of(date, time);
                int customerID = rs.getInt("Customer_ID");
                int userID = rs.getInt("User_ID");
                int contactID = rs.getInt("Contact_ID");
                
                Appointment apt = new Appointment(id, title, description, location, 
                        type, start, end, customerID, userID, contactID);
                aList.add(apt);
                appointments.put(id, apt);
                if (nextID < id)
                    id = nextID;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return aList;
    }
    
    //  Gives returns an incremented ID
    public static int getNextID()
    {
        return ++nextID;
    }
    
    //  Saves a NEW appointment into the DB
    public static void saveAppointment(Appointment apt) throws SQLException
    {
        String user = DBUsers.currentUser.getUsername();
        // Give the appointment a new ID
        String command = "INSERT INTO appointments VALUES (";
        command += apt.id                   + ", ";
        command += "'" + apt.title          + "', ";
        command += "'" + apt.description    + "', ";
        command += "'" + apt.location       + "', ";
        command += "'" + apt.type           + "', ";
        command += "'" + apt.getStartText() + "', ";
        command += "'" + apt.getEndText()   + "', ";
        command += "NOW(), ";
        command += "'" + user               + "', ";
        command += "NOW(), ";
        command += "'" + user               + "', ";
        command += apt.customerID           + ", ";
        command += apt.userID               + ", ";
        command += apt.contactID            + ")";
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(command);
        ps.executeUpdate();
    }
    
    //  Updates an EXISTING appointment in the DB
    public static void updateAppointment (Appointment apt) throws SQLException
    {
        String user = DBUsers.currentUser.getUsername();
        
        String command = "UPDATE appointments SET ";
        command += "Title = '"          + apt.title             + "', ";
        command += "Description = '"    + apt.description       + "', ";
        command += "Location = '"       + apt.location          + "', ";
        command += "Type = '"           + apt.type              + "', ";
        command += "Start = '"          + apt.getStartText()    + "', ";
        command += "End = '"            + apt.getEndText()      + "', ";
        command += "Last_Update = NOW(), ";
        command += "Last_Updated_By = '"+ user                  + "', ";
        command += "Customer_ID = "     + apt.customerID        + ", ";
        command += "User_ID = "         + apt.userID            + ", ";
        command += "Contact_ID = "      + apt.contactID         + " ";
        command += "WHERE Appointment_ID = " + apt.id;
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(command);
        ps.executeUpdate();
    }
    
    public static void deleteAppointment(Appointment apt) throws SQLException
    {
        String command = "DELETE FROM appointments WHERE Appointment_ID = " + apt.id;
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(command);
        ps.executeUpdate();
    }
}
