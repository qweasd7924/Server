package server.ejb;

import server.entity.*;
import server.entity.Enum.StateOfDriverEnum;
import server.entity.Enum.StateOfLogin;
import server.entity.ClientE;
import server.service.TotalService;

/**
 * Created by ����� on 30.07.2016.
 */
public class LoginRegImpl implements LoginReg {
    TotalService totalService = new TotalService();
    java.lang.Object o;//driver or client

    public LoginRegImpl() {
    }

    @Override
    public void addNewObj(StateOfLogin clOrDriver, String login, String password, String repassword) {
        java.lang.Object o = totalService.getByLogin(login);
        // TODO: 02.08.2016 same login check
        if (o == null) {
            if (repassword.equals(password)) {
                LoginE loginE = new LoginE();
                loginE.setLogin(login);
                loginE.setPassword(password);
                loginE.setState(clOrDriver);
                totalService.addLogin(loginE, clOrDriver);
            }
        } else {
            // TODO: 03.08.2016 throw same user exists
        }
    }


    @Override
    public boolean login(String login, String password) {
        // TODO: 08.08.2016 start to do login ejb 
        // TODO: 04.08.2016  returm xml
        return false;
    }


    public DriverE getDriverByLogin(String login) {
        o = totalService.getByLogin(login);
        if (o == null) {
            return null;
        }
        return (DriverE) o;
    }

    public ClientE getClientByLogin(String login) {
        o = totalService.getByLogin(login);
        if (o == null) {
            return null;
        }
        return (ClientE) o;
    }

    public ClientE addClientInfo(String login, String fullName, Integer phone, String address) {
        ClientE client = getClientByLogin(login);
        if (client != null) {
            client.setFullName(fullName);
            client.setPhone(phone);
            client.setAddress(address);
            totalService.addClientInfo(client);
        } else {
            return null;
        }
        return client;
    }


    public DriverE addDriverInfo(String login, int balance, int experience,
                                 String fullName, String location, int phone, StateOfDriverEnum stateOfDriver) {
        DriverE driver = getDriverByLogin(login);
        if (driver != null) {
            driver.setBalance(balance);
            driver.setExperience(experience);
            driver.setFullName(fullName);
            driver.setLocation(location);
            driver.setPhone(phone);
            driver.setStatus(stateOfDriver);
            totalService.addDriverInfo(driver);
        } else {
            return null;
        }
        return driver;
    }

    public CarE addCarInfo(String loginOfDriver, String carNumber, String carModel, Integer carAge, Integer carCapacity) {
        CarE car = getCarByDrLogin(loginOfDriver);
        CarE resultCar = null;
        if (car != null) {
            car.setModel(carModel);
            car.setAge(carAge);
            car.setCapacity(carCapacity);
            car.setNumber(carNumber);
            resultCar = totalService.addCar(car);
        }
        return resultCar;
    }

    private CarE getCarByDrLogin(String loginOfDriver) {
        DriverE driver = getDriverByLogin(loginOfDriver);
        CarE car = null;
        if (driver != null) {
            car = totalService.getCarOfDriver(driver.getCarE().getId());
        }
        return car;
    }


}
