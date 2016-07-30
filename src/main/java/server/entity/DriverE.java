package server.entity;

import server.bean.DriverB;

import javax.persistence.*;

/**
 * Created by Павел on 30.07.2016.
 */
@Entity(name = "driver")
@Table
@NamedQuery(name = "Driver.getAllDrivers", query = "select d from driver d")
public class DriverE {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String fullName;

    public DriverE() {
    }

    public DriverE(server.bean.DriverB driverB) {
        this.fullName = driverB.getFullName();
        this.id = driverB.getId();
    }

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
}
