package server.ejb;

import server.entity.ClientE;
import server.entity.OrderE;
import server.service.OrderService;
import server.service.TotalService;

/**
 * Created by Павел on 05.08.2016.
 */
public class OrderEJB {

    OrderService orderService = new OrderService();

    public OrderE addOrder(ClientE clientE){
        orderService.addNewOrder(clientE);

        return null;
    }

    public void setDriverForOrder(){
//        return null;
    }
    public void changeStateOfOrder(){
//        return null;
    }

}
