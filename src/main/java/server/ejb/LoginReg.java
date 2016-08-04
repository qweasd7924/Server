package server.ejb;

import server.bean.ClientB;
import server.bean.DriverB;
import server.entity.Enum.StateOfLogin;

/**
 * Created by Павел on 30.07.2016.
 */
public interface LoginReg {
//    public ClientB addNewClient(String login, String password, String repassword, String email);

    public void addNewObj(StateOfLogin clOrDriver, String login, String password, String repassword);//new Client or Driver

//    public DriverB addNewDriver(String login, String password, String repassword, String email);

    public boolean login(String login, String password);

}
