package server.entity;

import server.entity.Enum.StateOfOrder;

import javax.persistence.*;

/**
 * Created by Павел on 05.08.2016.
 */
@Entity(name = "order_info")
@Table
public class OrderInfoE {
    @Id
    @GeneratedValue
    private int idOrdInfo;

    @OneToOne(mappedBy = "orderInfo")
    private OrderE order;

    @Enumerated(EnumType.STRING)
    private StateOfOrder stateOfOrder;
    @Column
    private String loadingAddress;
    @Column
    private String unloadingAddress;
    @Column
    private String cargoParams;
    @Column
    private String comments;
    @Column
    private String cargoLocation;
    @Column
    private int price;

    public OrderInfoE() {
    }

    public OrderInfoE(StateOfOrder stateOfOrder, String loadingAddress,
                      String unloadingAddress, String cargoParams,
                      String comments, String cargoLocation, int price) {
        this.stateOfOrder = stateOfOrder;
        this.loadingAddress = loadingAddress;
        this.unloadingAddress = unloadingAddress;
        this.cargoParams = cargoParams;
        this.comments = comments;
        this.cargoLocation = cargoLocation;
        this.price = price;
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

    public String getLoadingAddress() {
        return loadingAddress;
    }

    public void setLoadingAddress(String loaningAddress) {
        this.loadingAddress = loaningAddress;
    }

    public String getUnloadingAddress() {
        return unloadingAddress;
    }

    public void setUnloadingAddress(String ulloaningAddress) {
        this.unloadingAddress = ulloaningAddress;
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
