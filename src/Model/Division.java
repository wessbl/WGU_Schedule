/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wessl
 */
public class Division {
    private final int id;
    private final String name;
    private final int country_id;
    
    public Division (int id, String name, int country_id){
        this.id = id;
        this.name = name;
        this.country_id = country_id;
    }
    
    // Getters
    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getCountry(){
        return country_id;
    }
    
    @Override
    public String toString(){
        String s = "Division " + id + ":\t";
        s += name + "\t";
        s += country_id + "\t";
        return s;
    }
}
