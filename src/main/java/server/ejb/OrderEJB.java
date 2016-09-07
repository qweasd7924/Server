package server.ejb;

import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfOrder;
import server.entity.OrderE;
import server.entity.OrderInfoE;
import server.service.OrderService;

import javax.ejb.Stateless;

/**
 * Created by Павел on 05.08.2016.
 */
@Stateless
public class OrderEJB {

    OrderService orderService = new OrderService();

    public OrderE addOrder(ClientE clientE) {
        return orderService.addNewOrder(clientE);
    }

    public void setDriverForOrder(DriverE driver, OrderE order) {
        //todo make some proverka
        orderService.setDriverForOrder(driver, order);
    }

    public void changeStateOfOrder(OrderE orderE, StateOfOrder stateOfOrder) {
        OrderE order = orderService.getOrderById(orderE.getId());
        orderService.changeStateOfOrder(order, stateOfOrder);
    }

    public void addOrderInfo(OrderE order, OrderInfoE info) {
        // TODO: 06.08.2016 some validation of order info
        orderService.addOrderInfo(order, info);
    }

}
