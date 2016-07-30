package server.ejb;

import server.entity.ClientE;
import server.entity.DriverE;

/**
 * Created by Павел on 30.07.2016.
 */
public interface LoginReg {
    public ClientE addNewClient(String login, String Password, String repassword, String email);

    public DriverE addNewDriver(String login, String Password, String repassword, String email);

    public boolean login(String login, String password);

    public boolean addInfo(String login, String fullName, Integer phone, String address);

    public boolean addCarInfo(String login, String carModel, Integer carAge, Integer carCapacity);
}
