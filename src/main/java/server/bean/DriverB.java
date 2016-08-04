package server.bean;

import server.entity.Enum.StateOfDriverEnum;

/**
 * Created by Павел on 30.07.2016.
 */
public class DriverB {
//    public enum Status{free,byse};
    public String fullName;
    public int id;
    public int phone;
    public int balance;
    public int experience;
    public String location;
//    public Status status;
    StateOfDriverEnum status;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public StateOfDriverEnum getStatus() {
        return status;
    }

    public void setStatus(StateOfDriverEnum status) {
        this.status = status;
    }
}
