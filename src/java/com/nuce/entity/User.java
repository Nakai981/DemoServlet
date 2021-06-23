/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuce.entity;

/**
 *
 * @author Phan
 */
public class User {
    
    private int id;
    private String fullname;
    private long year;
    private boolean sex;

    public User(int id, String fullname, long year, boolean sex) {
        this.id = id;
        this.fullname = fullname;
        this.year = year;
        this.sex = sex;
    }

    public User() {
    }

    public User(String fullname, long year, boolean sex) {
        this.fullname = fullname;
        this.year = year;
        this.sex = sex;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    
    
}
