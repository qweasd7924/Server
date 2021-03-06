package server.entity;

import server.bean.DriverB;
import server.entity.Enum.StateOfDriverEnum;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 30.07.2016.
 */
@Entity(name = "driver")
@Table
@NamedQueries({
        @NamedQuery(name = "Driver.getAllDrivers", query = "select d from driver d"),
        @NamedQuery(name = "Driver.getDriverById", query = "select d from driver d where id =:id")
})
public class DriverE {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String fullName;
    @Column
    private int phone;
    @Column
    private int experience;
    @Column
    @Enumerated(EnumType.STRING)
    private StateOfDriverEnum status;
    @Column
    private String location;
    @Column
    private int balance;

    @OneToOne(mappedBy = "driverE")
    private LoginE login;

    @OneToOne
    @JoinColumn(name = "car_fk")
    private CarE carE;

    @OneToMany//if uncomment mapped by - don't work
    private List<OrderE> orders;

    public DriverE() {
    }

    public DriverE(server.bean.DriverB driverB) {
        this.fullName = driverB.getFullName();
        this.id = driverB.getId();
        this.phone = driverB.getPhone();
        this.experience = driverB.getExperience();
        this.location = driverB.getLocation();
        this.status = driverB.getStatus();
        this.balance = driverB.getBalance();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(StateOfDriverEnum status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LoginE getLogin() {
        return login;
    }

    public void setLogin(LoginE login) {
        this.login = login;
    }

    public CarE getCarE() {
        return carE;
    }

    public void setCarE(CarE carE) {
        this.carE = carE;
    }

    public List<OrderE> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderE> orders) {
        this.orders = orders;
    }

    public void addOrder(OrderE order) {
        if (orders == null){
            orders = new ArrayList<OrderE>();
        }
        orders.add(order);
    }
}
