package server.entity;

import server.entity.Enum.StateOfOrder;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Павел on 05.08.2016.
 */
@Entity
@Table
public class OrderInfoE {
    @Id
    @GeneratedValue
    private int idOrdInfo;

    @OneToOne(mappedBy = "orderInfoE")
    private OrderE order;

    @Column
    private StateOfOrder stateOfOrder;
    @Column
    private String loaningAddress;
    @Column
    private String ulloaningAddress;
    @Column
    private String cargoParams;
    @Column
    private String comments;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfAdd;
    @Column
    private String cargoLocation;
    @Column
    private int price;

    public OrderInfoE() {
    }

    public int getIdOrdInfo() {
        return idOrdInfo;
    }

    public void setIdOrdInfo(int idOrdInfo) {
        this.idOrdInfo = idOrdInfo;
    }

    public OrderE getOrderE() {
        return order;
    }

    public void setOrderE(OrderE orderE) {
        this.order = orderE;
    }

    public StateOfOrder getStateOfOrder() {
        return stateOfOrder;
    }

    public void setStateOfOrder(StateOfOrder stateOfOrder) {
        this.stateOfOrder = stateOfOrder;
    }

    public String getLoaningAddress() {
        return loaningAddress;
    }

    public void setLoaningAddress(String loaningAddress) {
        this.loaningAddress = loaningAddress;
    }

    public String getUlloaningAddress() {
        return ulloaningAddress;
    }

    public void setUlloaningAddress(String ulloaningAddress) {
        this.ulloaningAddress = ulloaningAddress;
    }

    public String getCargoParams() {
        return cargoParams;
    }

    public void setCargoParams(String cargoParams) {
        this.cargoParams = cargoParams;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public String getCargoLocation() {
        return cargoLocation;
    }

    public void setCargoLocation(String cargoLocation) {
        this.cargoLocation = cargoLocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
