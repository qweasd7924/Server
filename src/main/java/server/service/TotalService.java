package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.OrderE;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
public class TotalService implements Queries {
//    @Inject
//    Service service;
//    EntityManager em;

//    public TotalService() {
//         em = service.getEm();
//    }

//    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();
    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();


    @Override
    public Object getByLogin(String login) {
        return null;
    }

    @Override
    public List<DriverE> getAllDrivers() {
        List<DriverE> list = new ArrayList<>();
        DriverE a = new DriverE();
        a.setFullName("Oleg Pirog");
        a.setId(1);
        list.add(a);
        DriverE b= new DriverE();
        b.setFullName("Oleg Dorog");
        b.setId(4);
        list.add(b);
        return list;
    }

    @Override
    public List<ClientE> getAllClients() {
        return null;
    }

    @Override
    public List<OrderE> getAllOrdersByLogin(String login) {
        return null;
    }

    @Override
    public void addDriver(server.bean.DriverB driverB ) {

        em.getTransaction().begin();
        DriverE result = em.merge(new DriverE(driverB));
        em.getTransaction().commit();
    }
}
