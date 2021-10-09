package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wessl
 */
public class Customer {
    public final int id;
    public String name;
    public String address;
    public String zip;
    public String phone;
//    private final LocalDateTime createDate;
//    private final String createdBy;
//    private final LocalDateTime lastUpdate;
//    private final String updatedBy;
    public int division;
    private List<Integer> appointments;
    
    public Customer (int id, String name, String address, String zip, String phone, 
            int division){
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
//        this.createDate = createDate;
//        this.createdBy = createdBy;
//        this.lastUpdate = lastUpdate;
//        this.updatedBy = updatedBy;
        this.division = division;
        appointments = new ArrayList<Integer>();
    }
    
    public List<Integer> getAppointments()
    {
        return appointments;
    }
    
    public void addAppointment(Integer id)
    {
        appointments.add(id);
    }
    
    public void removeAppointment(Integer id)
    {
        appointments.remove(id);
    }
    
    @Override
    public String toString(){
        String s = "Customer " + id + ": \t";
        s+= name + " \t";
        s += address + " \t";
        s += zip + " \t";
        s += phone + " \t";
        s += division + " \t";
        s += "Apts:"+ appointments;
        return s;
    }
}
