package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.OrderE;

import java.util.List;

/**
 * Created by ����� on 30.07.2016.
 */
public interface Queries {
    public java.lang.Object getByLogin(String login);


    List<DriverE> getAllDrivers();

    List<ClientE> getAllClients();

    public List<OrderE> getAllOrdersByLogin(String login);

    public DriverE addDriver(DriverE driver);

}
