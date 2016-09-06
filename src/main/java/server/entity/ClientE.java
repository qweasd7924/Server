package server.entity;

import server.bean.ClientB;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
@XmlRootElement
@Entity(name = "client")
@Table
@NamedQueries({
        @NamedQuery(name = "Client.GetAllClients", query = "select c from client c"),
        @NamedQuery(name = "Client.GetClientById", query = "select c from client c where id =:id")
})
public class ClientE {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String fullName;
    @Column
    private int phone;
    @Column
    private String address;


    @OneToOne(mappedBy = "clientE")
    private LoginE login;

    @OneToMany()
//    @JoinColumn(name = "orders_fk") didn't create client - order table
    private List<OrderE> orders;

    public ClientE() {
    }

    public ClientE(ClientB client) {
        this.id = client.getId();
        this.fullName = client.getFullName();
        this.phone = client.getPhone();
        this.address = client.getAddress();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public LoginE getLogin() {
        return login;
    }

    public void setLogin(LoginE login) {
        this.login = login;
    }

    public List<OrderE> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderE> orders) {
        this.orders = orders;
    }

    public void addOrder(OrderE order){
        if (orders == null){
            orders = new ArrayList<OrderE>();
        }
        orders.add(order);
    }
}
