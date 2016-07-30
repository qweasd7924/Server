package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.OrderE;

import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
public interface Queries {
    public Object getByLogin(String login);

    public List<DriverE> getAllDrivers();

    public List<ClientE> getAllClients();

    public List<OrderE> getAllOrdersByLogin(String login);

    public void addDriver(server.bean.DriverB driverB);
}
