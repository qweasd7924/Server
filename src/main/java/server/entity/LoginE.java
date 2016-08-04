package server.entity;

import server.entity.Enum.StateOfLogin;

import javax.persistence.*;

/**
 * Created by Павел on 01.08.2016.
 */
@Entity(name = "login")
@NamedQueries(
        @NamedQuery(name = "Login.GetByLogin", query = "select l from login l where l.login = :login ")
)

public class LoginE {
    @Id
    @GeneratedValue
    int id;
    @Column
    String login;
    @Column
    String password;

    @Enumerated
    StateOfLogin state;

    @OneToOne
    @JoinColumn(name = "driver_fk")
    DriverE driverE;
    @OneToOne
    @JoinColumn(name = "client_fk")
    private ClientE clientE;

    public LoginE() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DriverE getDriverE() {
        return driverE;
    }

    public void setDriverE(DriverE driverE) {
        this.driverE = driverE;
    }

    public ClientE getClientE() {
        return clientE;
    }

    public void setClientE(ClientE clientE) {
        this.clientE = clientE;
    }

    public StateOfLogin getState() {
        return state;
    }

    public void setState(StateOfLogin state) {
        this.state = state;
    }
}
