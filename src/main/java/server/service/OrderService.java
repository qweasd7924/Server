package server.service;

import server.entity.ClientE;
import server.entity.OrderE;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Павел on 05.08.2016.
 */
public class OrderService {

    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();

    public OrderE addNewOrder(ClientE client){
//        em.getTransaction().begin();
//        OrderE ordRoAdd = new OrderE();
//        ordRoAdd.setClientE(client);
//        OrderE res = em.merge(ordRoAdd);
//        em.getTransaction().commit();
//        em.getTransaction().begin();
//        client.getOrders().add(res);
//        em.merge(client);
//        em.getTransaction().commit();
//        return res;
        return null;
    }
}
