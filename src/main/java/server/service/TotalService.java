package server.service;

import server.bean.ClientB;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfLogin;
import server.entity.LoginE;
import server.entity.OrderE;

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
//        DriverE dr = query.getSingleResult().getDriverE();
//        ClientE cl = query.getSingleResult().getClientE();
//        if (query.getSingleResult().getDriverE() == null){
//            return 3;
//        }else if (query.getSingleResult().getClientE() == null){
//            return 4;
//        }

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


    @Override
    public void addDriverInfo(server.bean.DriverB driverB) {
        em.getTransaction().begin();
        DriverE result = em.merge(new DriverE(driverB));
        em.getTransaction().commit();
    }


    public void addClientInfo(ClientB clientB) {
        em.getTransaction().begin();
        ClientE result = em.merge(new ClientE(clientB));
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
            DriverE driver = addDriver(new DriverE());
            em.getTransaction().begin();
            loginE.setDriverE(driver);
            LoginE comLogin = em.merge(loginE);
            em.getTransaction().commit();
            em.getTransaction().begin();
            driver.setLogin(comLogin);
            em.merge(driver);
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
}
