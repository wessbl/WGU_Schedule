package Model;

import java.time.LocalDateTime;

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
    }
    
    @Override
    public String toString(){
        String s = "Customer " + id + ": \t";
        s+= name + " \t";
        s += address + " \t";
        s += zip + " \t";
        s += phone + " \t";
        s += division + " \t";
        return s;
    }
}
