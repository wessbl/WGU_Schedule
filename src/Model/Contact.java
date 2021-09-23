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
public class Contact {
    private final int id;
    private final String name;
    private final String email;
    
    public Contact (int id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    @Override
    public String toString(){
        String s = "Contact " + id + ":\t";
        s += name + "\t";
        s += email;
        return s;
    }
}