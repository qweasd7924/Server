package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfLogin;
import server.entity.OrderE;

import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
public interface Queries {
    public Object getByLogin(String login);


    List<DriverE> getAllDrivers();

    List<ClientE> getAllClients();

    public List<OrderE> getAllOrdersByLogin(String login);

    public DriverE addDriver(DriverE driver);

    void addDriverInfo(server.bean.DriverB driverB);
}
