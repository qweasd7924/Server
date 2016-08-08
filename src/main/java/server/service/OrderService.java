package server.service;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfOrder;
import server.entity.OrderE;
import server.entity.OrderInfoE;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by ����� on 05.08.2016.
 */
public class OrderService {

    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();

    public OrderE addNewOrder(ClientE client) {
        em.getTransaction().begin();
        // TODO: 08.08.2016  сгенерировать номер заказа
        OrderE ordToAdd = new OrderE();
        ordToAdd.setDateOfAdd(new Date());
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

    public OrderE addOrderInfo(OrderE order, OrderInfoE info) {
        em.getTransaction().begin();
        OrderInfoE resInfo = em.merge(info);
        em.getTransaction().commit();
        em.getTransaction().begin();
        order.setOrderInfo(resInfo);
        resInfo.setOrderE(order);
        em.merge(order);
        em.merge(resInfo);
        em.getTransaction().commit();
        return order;
    }

    public OrderE getOrderById(OrderE orderE) {
        TypedQuery<OrderE> query = em.createNamedQuery("Order.getById", OrderE.class);
        query.setParameter("id", orderE.getId());
        if (query.getResultList().isEmpty()) {
            return null;
        }
        return query.getSingleResult();
    }

    public void changeStateOfOrder(OrderE order, StateOfOrder stateOfOrder) {
        em.getTransaction().begin();
        OrderInfoE info = order.getOrderInfo();
        info.setStateOfOrder(stateOfOrder);
        em.merge(info);
        em.getTransaction().commit();
    }

//    public void
}
