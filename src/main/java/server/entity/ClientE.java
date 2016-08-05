package server.entity;

import server.bean.ClientB;
import server.entity.Enum.StateOfLogin;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
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
    private String adress;

    @OneToOne(mappedBy = "clientE")
    private LoginE login;

    @OneToMany()
//    @JoinColumn(name = "orders_fk")
//    @JoinTable(name = "jnd_cl_ord",
//            joinColumns = @JoinColumn(name = "client_for_ord_fk"),
//    inverseJoinColumns = @JoinColumn(name = "orderCl_fk"))
    private List<OrderE> orders;
    // TODO: 05.08.2016 двунаправления связь м то о с ордер

    public ClientE() {
    }

    public ClientE(ClientB client) {
        this.id = client.getId();
        this.fullName = client.getFullName();
        this.phone = client.getPhone();
        this.adress = client.getAdress();
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
}
