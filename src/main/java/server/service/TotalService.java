package server.service;

import server.bean.ClientB;
import server.entity.*;
import server.entity.Enum.StateOfLogin;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ����� on 30.07.2016.
 */
public class TotalService implements Queries {

    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();

    @Override
    public Object getByLogin(String login) {
        TypedQuery<LoginE> query = em.createNamedQuery("Login.GetByLogin", LoginE.class);
        query.setParameter("login", login);
        if (query.getResultList().isEmpty()) {
            return null;
        }

        Object result = query.getSingleResult();

        if (query.getSingleResult().getDriverE() == null) {
            TypedQuery<ClientE> query1 = em.createNamedQuery("Client.GetClientById", ClientE.class);
            query1.setParameter("id", query.getSingleResult().getClientE().getId());
            return query1.getSingleResult();
        } else if (query.getSingleResult().getClientE() == null) {
            TypedQuery<DriverE> query1 = em.createNamedQuery("Driver.getDriverById", DriverE.class);
            query1.setParameter("id", query.getSingleResult().getDriverE().getId());
            return query1.getSingleResult();
        }
        return query.getSingleResult();
    }

    @Override
    public List<DriverE> getAllDrivers() {
        TypedQuery<DriverE> query = em.createNamedQuery("Driver.getAllDrivers", DriverE.class);
        return query.getResultList();
    }

    @Override
    public List<ClientE> getAllClients() {
        TypedQuery<ClientE> query = em.createNamedQuery("Client.GetAllClients", ClientE.class);
        return query.getResultList();
    }

    @Override
    public List<OrderE> getAllOrdersByLogin(String login) {
        return null;
    }


    public void addDriverInfo(DriverE driverE) {
        em.getTransaction().begin();
        DriverE result = em.merge(driverE);
        em.getTransaction().commit();
    }


    public void addClientInfo(ClientE clientE) {
        em.getTransaction().begin();
        ClientE result = em.merge(clientE);
        em.getTransaction().commit();
    }

    public void addLogin(LoginE loginE, StateOfLogin state) {
        if (state.equals(StateOfLogin.ClIENT)) {
            ClientE client = addClient(new ClientE());
            em.getTransaction().begin();
            loginE.setClientE(client);
            LoginE comLogin = em.merge(loginE);
            em.getTransaction().commit();
            em.getTransaction().begin();
            client.setLogin(comLogin);
            em.merge(client);
        } else if (state.equals(StateOfLogin.DRIVER)) {
            CarE car = addCar(new CarE());
            DriverE driver = addDriver(new DriverE());
            em.getTransaction().begin();
            loginE.setDriverE(driver);
            LoginE comLogin = em.merge(loginE);
            em.getTransaction().commit();
            em.getTransaction().begin();
            driver.setLogin(comLogin);
            driver.setCarE(car);
            car.setDriver(driver);
            em.merge(driver);
            em.merge(car);
        }
        em.getTransaction().commit();
    }

    public ClientE addClient(ClientE clientE) {
        em.getTransaction().begin();
        ClientE client = em.merge(clientE);
        em.getTransaction().commit();
        return client;
    }

    @Override
    public DriverE addDriver(DriverE driver) {
        em.getTransaction().begin();
        DriverE driverE = em.merge(driver);
        em.getTransaction().commit();
        return driverE;
    }

    public CarE addCar(CarE car){
        em.getTransaction().begin();
        CarE res = em.merge(car);
        em.getTransaction().commit();
        return res;
    }

    public CarE getCarOfDriver(int idOfCar){
        TypedQuery<CarE> query = em.createNamedQuery("Car.GetCarById",CarE.class);
        query.setParameter("id",idOfCar);
        if (query.getResultList().isEmpty()){return null;}
        return query.getSingleResult();
    }
}
