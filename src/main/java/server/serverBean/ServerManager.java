package server.serverBean;

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
    @Inject
    ServerService serverService;

    public ServerManager() {
    }

    public void startServer(ServerB serverB) {
        serverService.startServer(new ServerE(serverB.getCount(), serverB.getPort()));
    }

    public void changeMessage(ServerB serverB){
        serverService.changeServerMessage(serverB.getPort(),serverB.getMessage());
    }
}
