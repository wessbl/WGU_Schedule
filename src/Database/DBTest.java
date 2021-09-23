/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import DBAccess.DBContacts;
import DBAccess.DBCountries;
import DBAccess.DBCustomers;
import DBAccess.DBDivisions;
import DBAccess.DBAppointments;
import DBAccess.DBUsers;
import Database.DBConnection;
import Model.Appointment;
import Model.Contact;
import Model.Country;
import Model.Customer;
import Model.Division;
import Model.User;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author wessl
 */
public class DBTest {
    public static void main(String[] args){
        System.out.println("Hello! Connecting...");
        DBConnection.startConnection();

        System.out.println("\n- - - - - LOGIN - - - - -");
        try {
            User user = DBUsers.login("test", "test");
            System.out.println("Logged in successfully as: " + user.getUsername());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
//        readFromDatabase();

        writeToDatabase();
        
        DBConnection.closeConnection();
        System.out.println("\nLooks like we made it! :)");
    }
    
    public static void readFromDatabase(){
        // Print all countries
        System.out.println("\n- - - - - COUNTRIES - - - - -");
        for (Country c : DBCountries.getAllCountries()){
            System.out.println(c.toString());
        }
        
        // Print all divisions
        System.out.println("\n- - - - - DIVISIONS - - - - -");
        for (Division d : DBDivisions.getAllDivisions()){
            System.out.println(d.toString());
        }
        
        // Print all contacts
        System.out.println("\n- - - - - CONTACTS - - - - -");
        for (Contact c : DBContacts.getAllContacts()){
            System.out.println(c.toString());
        }
        
        // Print all customers
        System.out.println("\n- - - - - CUSTOMERS - - - - -");
        for (Customer c : DBCustomers.getAllCustomers()){
            System.out.println(c.toString());
        }
        
        // Print all appointments
        System.out.println("\n- - - - - APPOINTMENTS - - - - -");
        for (Appointment a : DBAppointments.getAllAppointments()){
            System.out.println(a.toString());
        }
    }

    
    private static void writeToDatabase() {
        System.out.println("\n- - - - - SAVE NEW APPOINTMENT - - - - -");
        Appointment apt = new Appointment(1234, "Test Appointment", "desc", "loc", 
                "type", LocalDateTime.now(), LocalDateTime.now(), 1, 1, 1);
        try {
            DBAppointments.saveAppointment(apt);
            DBAppointments.getAllAppointments();
            apt = DBAppointments.appointments.get(apt.id);
            System.out.println(apt.toString());
            System.out.println("Appointment saved successfully!");
        } catch (SQLException ex) {
            System.out.println("Could not save the appointment! Reason:\n\t" +
                    ex.getMessage());
        }
        
        System.out.println("\n- - - - - UPDATE APPOINTMENT - - - - -");
        apt.title = "NEW Title!";
        apt.description = "NEW Description!";
        apt.location = "NEW Location!";
        apt.type = "NEW Type!";
        apt.start = LocalDateTime.now();
        apt.end = LocalDateTime.now();
        apt.customerID = 1;
        apt.userID = 2;
        apt.contactID = 3;
        
        try {
            DBAppointments.updateAppointment(apt);
            DBAppointments.getAllAppointments();
            apt = DBAppointments.appointments.get(apt.id);
            System.out.println(apt.toString());
            System.out.println("Appointment updated successfully!");
        } catch (SQLException ex) {
            System.out.println("Could not update the appointment! Reason:\n\t" +
                    ex.getMessage());
        }
        
        System.out.println("\n- - - - - DELETE APPOINTMENT - - - - -");
        try{
            DBAppointments.deleteAppointment(apt);
            
            System.out.println("Deletion successful!");
        } catch (SQLException ex) {
            System.out.println("Could not delete the appointment! " + ex.getMessage());
        }
        
        
        System.out.println("\n- - - - - SAVE NEW CUSTOMER - - - - -");
        Customer c = new Customer(1234, "Susie the Grey", "1234 Ridge Lane", "88888", 
                "555-505-0505", 1);
        try {
            DBCustomers.save(c);
            DBCustomers.getAllCustomers();
            c = DBCustomers.customers.get(c.id);
            System.out.println(c.toString());
            System.out.println("Customer saved successfully!");
        } catch (SQLException ex) {
            System.out.println("Could not save the Customer! Reason:\n\t" +
                    ex.getMessage());
        }
        
        
        System.out.println("\n- - - - - UPDATE CUSTOMER - - - - -");
        c.name = "Susie the White";
        c.address = "4321 Ridge Ln";
        c.zip = "00008";
        c.phone = "555-555-5555";
        c.division = 3;
        
        try {
            DBCustomers.update(c);
            DBAppointments.getAllAppointments();
            c = DBCustomers.customers.get(c.id);
            System.out.println(c.toString());
            System.out.println("Customer updated successfully!");
        } catch (SQLException ex) {
            System.out.println("Could not update the Customer! Reason:\n\t" +
                    ex.getMessage());
        }
        
        
        System.out.println("\n- - - - - DELETE CUSTOMER - - - - -");
        try{
            DBCustomers.delete(c);
            System.out.println("Deleted Customer successfully!");
        } catch (SQLException ex) {
            System.out.println("Could not delete the Customer! " + ex.getMessage());
        }
    }
}