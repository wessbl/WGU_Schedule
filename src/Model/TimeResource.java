/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author wessl
 */
public class TimeResource {
    public ObservableList<String> hours = FXCollections.observableArrayList();
    public ArrayList<String> minutes = new ArrayList<>();
    
    public TimeResource()
    {
        //  Create strings for hours and minutes
        String numberString;
        for (int i = 0; i < 60; i++)
        {
            if (i < 10)
                numberString = "0" + Integer.toString(i);
            else{
                numberString = Integer.toString(i);
            }
            if (i != 0 && i <= 12)
                hours.add(numberString);
            minutes.add(numberString);
        }
    }
    
    public LocalTime convertTime(String hour, String minute, String meridian)
    {
        int intHour = Integer.parseInt(hour);
        int intMinute = Integer.parseInt(minute);
        if ("am".equals(meridian))
            return LocalTime.of(intHour, intMinute);
        return LocalTime.of(intHour + 12, intMinute);
    }
    
    public String[] convertTime(LocalTime time)
    {
        return new String[]{"", "1"};
    }
}
