package server.ejb;

import server.entity.ClientE;
import server.entity.DriverE;

/**
 * Created by Павел on 30.07.2016.
 */
public class LoginRegImpl implements LoginReg {
    @Override
    public ClientE addNewClient(String login, String Password, String repassword, String email) {
        return null;
    }

    @Override
    public DriverE addNewDriver(String login, String Password, String repassword, String email) {
        return null;
    }

    @Override
    public boolean login(String login, String password) {
        return false;
    }

    @Override
    public boolean addInfo(String login, String fullName, Integer phone, String address) {
        return false;
    }

    @Override
    public boolean addCarInfo(String login, String carModel, Integer carAge, Integer carCapacity) {
        return false;
    }
}
