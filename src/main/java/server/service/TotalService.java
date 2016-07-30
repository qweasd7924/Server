package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.OrderE;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
public class TotalService extends  Service implements Queries {
//    @Inject
//    Service service;
//    EntityManager em;

//    public TotalService() {
//         em = service.getEm();
//    }

    @Override
    public Object getByLogin(String login) {
        return null;
    }

    @Override
    public List<DriverE> getAllDrivers() {
        List<DriverE> list = new ArrayList<>();
        DriverE a = new DriverE();
        a.setFullName("Oleg Pirog");
        list.add(a);
        DriverE b= new DriverE();
        b.setFullName("Oleg Dorog");
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
}
