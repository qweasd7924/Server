package server.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "server")
@NamedQuery(name = "Server.getServerByPort",query = "select s from server s where s.port = :port")
//@NamedQuery(name = "Author.getAuthorById", query = "SELECT a FROM authors a WHERE a.id = :id")}

public class ServerE implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    Integer id;

    @Column
    Integer count;
    @Column
    Integer port;
    @Column
    String message;

    public ServerE() {
    }

    public ServerE(Integer count, Integer port) {
        this.count = count;
        this.port = port;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
