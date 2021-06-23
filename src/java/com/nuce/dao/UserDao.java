/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.dao;

import java.util.ArrayList;
import java.util.List;
import com.nuce.entity.User;
/**
 *
 * @author Phan
 */
public class UserDao {
    private static List<User> users = new ArrayList<>();
    
    static {
        users.add(new User(1,"John Stones",2000,true));
        users.add(new User(2,"Marry Marry",1995,false));
        users.add(new User(3,"Mou Cole",1855,true));
        users.add(new User(4,"Lang Anh",1994,false));
        users.add(new User(5,"Harry Kane",2000,true));
    }
    
    public List<User> getAllUser(){  
        return this.users;
    }
    public User getUser(int id){
        for(User us: users){
            if(us.getId() == id){
                return us;
            }
        }
        return null;
    }
    public void addUser(User user){
        this.users.add(user);
    }
    public void updateUser(User user){
        for(User us:users){
            if(us.getId()==user.getId()){
                us.setFullname(user.getFullname());
                us.setYear(user.getYear());
                us.setSex(user.isSex());
            }
        }
    }
    public void deleteUser(int id){
        int idArr = -1;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId() == id){
                idArr = i;
            }
        }
        this.users.remove(idArr);
    }
}
