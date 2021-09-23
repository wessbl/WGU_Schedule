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
public class User {
    private int id;
    private String username;
//    private String password;
//    private LocalDateTime createDate;
//    private String createdBy;
//    private LocalDateTime lastUpdate;
//    private String updatedBy;
    
    public User (int id, String username){
        this.id = id;
        this.username = username;
//        this.password = password;
//        this.createDate = createDate;
//        this.createdBy = createdBy;
//        this.lastUpdate = lastUpdate;
//        this.updatedBy = updatedBy;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
//    public String getPassword() {
//        return password;
//    }
//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }
//    public String getCreatedBy() {
//        return createdBy;
//    }
//    public LocalDateTime getLastUpdate() {
//        return lastUpdate;
//    }
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
}
