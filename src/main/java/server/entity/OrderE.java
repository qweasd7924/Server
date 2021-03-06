package server.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ����� on 30.07.2016.
 */
@Entity(name = "orders")
@NamedQuery(name = "Order.getById",query = "select o from orders o where id =:id")
@Table
public class OrderE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_fk")
    private DriverE driverE;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_fk")
    private ClientE clientE;

    @OneToOne
    @JoinColumn(name = "info_fk")
    private OrderInfoE orderInfo;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfAdd;

    @Column(name = "order_number")
    private int numberOfOrder;

    public OrderE() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DriverE getDriverE() {
        return driverE;
    }

    public void setDriverE(DriverE driverE) {
        this.driverE = driverE;
    }

    public ClientE getClientE() {
        return clientE;
    }

    public void setClientE(ClientE clientE) {
        this.clientE = clientE;
    }

    public OrderInfoE getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfoE orderInfoE) {
        this.orderInfo = orderInfoE;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }
}
