package server.ejb;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import server.entity.CarE;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.OrderE;

import java.io.*;

/**
 * Created by Павел on 30.07.2016.
 */
public class ParseXMLImpl extends DBUnitConfigForXML {

    public ParseXMLImpl(String name) {
        super(name);
    }

    public File parseJson(Object object) throws Exception {
        File of = new File("C:\\client.xml");
        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(of))) {
            if (object instanceof ClientE) {
                writer.write(getClientJson((ClientE) object).getBytes());
            } else if (object instanceof OrderE) {
                writer.write(getOrderJson((OrderE) object).getBytes());
            } else if (object instanceof DriverE){
                writer.write(getDriverJson((DriverE) object).getBytes());
            }else if (object instanceof CarE){
                writer.write(getCarJson((CarE) object).getBytes());
            }
        }

        return of;
    }

    public String getClientJson(ClientE client) {
        JSONArray orders = new JSONArray();
        if (client.getOrders() != null) {
            for (OrderE o : client.getOrders()) {
                orders.add(o.getId());
            }
        }
        JSONObject clientJS = new JSONObject();
        clientJS.put("full name", client.getFullName());
        clientJS.put("phone", client.getPhone());
        clientJS.put("address", client.getAddress());
        clientJS.put("login", client.getLogin().getLogin());
        clientJS.put("orders", orders);
        return clientJS.toString();
    }

    public String getOrderJson(OrderE order) {
        JSONObject orderJS = new JSONObject();
        orderJS.put("id", order.getId());
        orderJS.put("driverName", order.getDriverE().getFullName());
        orderJS.put("driverId", order.getDriverE().getId());
        orderJS.put("clinetName", order.getClientE().getFullName());
        orderJS.put("clinetId", order.getClientE().getId());
        orderJS.put("state", order.getOrderInfo().getStateOfOrder());
        orderJS.put("loadingAddress", order.getOrderInfo().getLoadingAddress());
        orderJS.put("unloadingAddress", order.getOrderInfo().getUnloadingAddress());
        orderJS.put("cargoParameters", order.getOrderInfo().getCargoParams());
        orderJS.put("comments", order.getOrderInfo().getComments());
        orderJS.put("cargoLocation", order.getOrderInfo().getCargoLocation());
        orderJS.put("price", order.getOrderInfo().getPrice());
        orderJS.put("date", order.getDateOfAdd());
        orderJS.put("number", order.getNumberOfOrder());
        return orderJS.toString();
    }

    public String getDriverJson(DriverE driver) {
        JSONObject driverJS = new JSONObject();
        JSONArray ordersId = new JSONArray();
        if (driver.getOrders() != null) {
            for (OrderE o : driver.getOrders()) {
                ordersId.add(o.getId());
            }
        }

        driverJS.put("id", driver.getId());
        driverJS.put("fullName", driver.getFullName());
        driverJS.put("phone", driver.getPhone());
        driverJS.put("experience", driver.getExperience());
        driverJS.put("status", driver.getStatus());
        driverJS.put("location", driver.getLocation());
        driverJS.put("balance", driver.getBalance());
        driverJS.put("login", driver.getLogin().getLogin());
        driverJS.put("carId", driver.getCarE().getId());
        driverJS.put("ordersId", ordersId);

        return driverJS.toString();
    }

    public String getCarJson(CarE car){
        JSONObject carJS = new JSONObject();

        carJS.put("id",car.getId());
        carJS.put("model",car.getModel());
        carJS.put("age",car.getAge());
        carJS.put("number",car.getNumber());
        carJS.put("capacity",car.getCapacity());
        carJS.put("driverId",car.getDriver().getId());
        return car.toString();
    }
}
