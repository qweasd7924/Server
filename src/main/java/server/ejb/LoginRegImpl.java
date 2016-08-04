package server.ejb;

import server.bean.ClientB;
import server.bean.DriverB;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfLogin;
import server.entity.LoginE;
import server.service.TotalService;

import javax.inject.Inject;

/**
 * Created by ����� on 30.07.2016.
 */
public class LoginRegImpl implements LoginReg {
    TotalService totalService = new TotalService();

    @Override
    public void addNewObj(StateOfLogin clOrDriver, String login, String password, String repassword) {
        Object o = totalService.getByLogin(login);
        // TODO: 02.08.2016 same login check
        if (o == null) {
            if (repassword.equals(password)) {
                LoginE loginE = new LoginE();
                loginE.setLogin(login);
                loginE.setPassword(password);
                loginE.setState(clOrDriver);
                totalService.addLogin(loginE, clOrDriver);
            }
        }else {
            // TODO: 03.08.2016 throw same user exists
        }
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
