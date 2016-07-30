package server.service;

import server.entity.ServerE;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Stateless
public class ServerService extends Service{

    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();

    public ServerE startServer(ServerE serverE){
        em.getTransaction().begin();
        ServerE result = em.merge(serverE);
        em.getTransaction().commit();
        return result;
    }

    public  ServerE changeServerMessage(int port, String message){
        em.getTransaction().begin();
        TypedQuery<ServerE> query = em.createNamedQuery("Server.getServerByPort",ServerE.class);
        query.setParameter("port",port);
        ServerE serverBuPort = query.getSingleResult();
        serverBuPort.setMessage(message);
        ServerE result = em.merge(serverBuPort);
        result.setMessage(message);
        em.merge(result);
        em.getTransaction().commit();
        return result;
    }
}
