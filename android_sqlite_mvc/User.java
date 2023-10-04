/**
 * This program is a data structure used to pass data back and forth between
 * the model and controller.
 * @author  Essa Imhmed
 * Oct 2, 2023
 */
package com.example.helloworldsqllite;

public class User {
    int id;
    String name;
    String title;
    String phone;
    String office;
    String station;
    public User(){ }
    public User(int id, String name, String title, String phone
    , String office, String station){
        this.id = id;
        this.name = name;
        this.title = title;
        this.phone = phone;
        this.office = office;
        this.station = station;
    }

    public  User(String name, String title, String phone
            , String office, String station){
        this.name = name;
        this.title = title;
        this.phone = phone;
        this.office = office;
        this.station = station;
    }
    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getOffice(){
        return this.office;
    }

    public void setOffice(String office){
        this.office = office;
    }

    public String getStation(){
        return this.station;
    }

    public void setStation(String station){
        this.station = station;
    }
}
