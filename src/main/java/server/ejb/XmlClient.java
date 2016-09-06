package server.ejb;

import server.entity.ClientE;
import server.entity.LoginE;
import server.entity.OrderE;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Павел on 04.09.2016.
 */
@XmlRootElement
public class XmlClient {
    private int id;
    private String fullName;
    private int phone;
    private String adress;
    private LoginE login;
    private List<OrderE> orders;

    public XmlClient() {
    }

    XmlClient(ClientE client ){
        this.id= client.getId();
        this.fullName = client.getFullName();
        this.phone = client.getPhone();
        this.adress = client.getAdress();
        this.login = client.getLogin();
//        for (OrderE o :client.getOrders()){
//            orders.add(o);
//        }
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
