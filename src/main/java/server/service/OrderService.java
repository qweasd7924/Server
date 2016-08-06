package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.OrderE;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by ����� on 05.08.2016.
 */
public class OrderService {

    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();

    public OrderE addNewOrder(ClientE client){
        em.getTransaction().begin();
        OrderE ordToAdd = new OrderE();
        ordToAdd.setClientE(client);
        OrderE res = em.merge(ordToAdd);
        em.getTransaction().commit();
        em.getTransaction().begin();
        client.addOrder(res);
        em.merge(client);
        em.getTransaction().commit();
        return res;
    }

    public OrderE setDriverForOrder(DriverE driver, OrderE order) {
        em.getTransaction().begin();
//        OrderE ordToAdd = new OrderE();
//        ordToAdd.setClientE(client);
        order.setDriverE(driver);
        OrderE res = em.merge(order);
        em.getTransaction().commit();
        em.getTransaction().begin();
        driver.addOrder(order);
        em.merge(driver);
        em.getTransaction().commit();
        return res;
    }
}
