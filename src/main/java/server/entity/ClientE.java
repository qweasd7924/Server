package server.entity;

import server.bean.ClientB;
import server.entity.Enum.StateOfLogin;

import javax.persistence.*;

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
}
