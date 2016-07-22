package server.bean;

import server.ejb.ServerEJB;
import server.entity.ServerE;
import server.service.ServerService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Gamzat on 03.12.2015.
 */
@Stateless
public class ServerManager implements Serializable {

    @Inject
    ServerEJB serverEJB;

    public ServerManager() {
    }

    public void startServer(ServerB serverB) {
        ServerService.startServer(new ServerE(serverB.getCount(), serverB.getPort()));
    }

    public void changeMessage(ServerB serverB){
        ServerService.changeServerMessage(serverB.getPort(),serverB.getMessage());
    }
}
