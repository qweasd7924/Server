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
        query.getResultList();
        if (query.getResultList().isEmpty()) {
            return null;
        }
        // TODO: 04.08.2016 get by login uncomment 
//
//        if (query.getSingleResult().getDriverE().equals(null)){
//            TypedQuery<ClientE> query1 = em.createNamedQuery("Client.GetClientById", ClientE.class);
//            query1.setParameter("id",query.getSingleResult().getClientE().getId());
//            return query1.getSingleResult();
//        }else if (query.getSingleResult().getClientE().equals(null)){
//            TypedQuery<DriverE> query1 = em.createNamedQuery("Driver.getDriverById", DriverE.class);
//            query1.setParameter("id",query.getSingleResult().getDriverE().getId());
//            return query1.getSingleResult();
//        }
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
        em.getTransaction().begin();
        if (state.equals(StateOfLogin.ClIENT)) {
            loginE.setClientE(addClient(new ClientE()));
        } else if (state.equals(StateOfLogin.DRIVER)) {
            loginE.setDriverE(addDriver(new DriverE()));
        }
        em.merge(loginE);
        em.getTransaction().commit();
    }

    public ClientE addClient(ClientE clientE) {
        ClientE client = em.merge(clientE);
        return client;
    }

    @Override
    public DriverE addDriver(DriverE driver) {
        DriverE driverE = em.merge(driver);
        return driverE;
    }
}
