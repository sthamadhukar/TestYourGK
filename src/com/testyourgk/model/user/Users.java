package com.testyourgk.model.user;


import javax.persistence.*;

/**
 * Created by Madhukar on 5/21/2016.
 */
@Entity
@Table(name ="Users")
public class Users {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;
    private String email;
    @Column(nullable = true)
    private int timesPlayed;
    @Column(nullable = true)
    private int lastHighscore;

//getter and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public int getLastHighscore() {
        return lastHighscore;
    }

    public void setLastHighscore(int lastHighscore) {
        this.lastHighscore = lastHighscore;
    }
}
