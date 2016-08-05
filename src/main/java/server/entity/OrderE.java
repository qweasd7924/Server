package server.entity;

import javax.persistence.*;

/**
 * Created by Павел on 30.07.2016.
 */
@Entity(name = "orders")
@Table
public class OrderE {
    @Id
    @GeneratedValue
    private int idOrder;

//    @ManyToOne
//    private DriverE driverE;
//
//    @ManyToOne
//    private ClientE clientE;

    @OneToOne
    @JoinColumn(name = "order_info_fk")
    private OrderInfoE orderInfoE;

    @Column
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public OrderE() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

//    public DriverE getDriverE() {
//        return driverE;
//    }
//
//    public void setDriverE(DriverE driverE) {
//        this.driverE = driverE;
//    }
//
//    public ClientE getClientE() {
//        return clientE;
//    }
//
//    public void setClientE(ClientE clientE) {
//        this.clientE = clientE;
//    }
//-------------------
    public OrderInfoE getOrderInfoE() {
        return orderInfoE;
    }

    public void setOrderInfoE(OrderInfoE orderInfoE) {
        this.orderInfoE = orderInfoE;
    }
}
