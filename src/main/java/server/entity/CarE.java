package server.entity;

import javax.persistence.*;

/**
 * Created by Павел on 30.07.2016.
 */
@Entity(name = "car")
@NamedQuery(name = "Car.GetCarById",query = "select c from car c where id =:id")
public class CarE {
    @Id
    @GeneratedValue
    int id;
    @Column
    String model;
    @Column
    int age;
    @Column
    String number;
    @Column
    int capacity;
    @OneToOne(mappedBy = "carE")
    private DriverE driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public DriverE getDriver() {
        return driver;
    }

    public void setDriver(DriverE driver) {
        this.driver = driver;
    }
}
