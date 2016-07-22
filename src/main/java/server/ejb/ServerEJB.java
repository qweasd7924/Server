package server.ejb;

import server.bean.ServerB;
import server.bean.ServerManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Pavel on 29.02.2016.
 */
@Stateless
public class ServerEJB {
    @Inject
    ServerManager serverManager;

    public String startServer(ServerB serverB) {

        serverManager.startServer(serverB);

        try (ServerSocket ss = new ServerSocket(serverB.getPort())) {
            communicate(ss,serverB);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    public void changeMessage(ServerB serverB){
        serverManager.changeMessage(serverB);
    }


    public void communicate(ServerSocket ss,ServerB serverB) {
        while (true) {
            try (Socket socket = ss.accept();
                 DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                String answer;

                try {
                    answer = process(in.readUTF());

                    serverB.setMessage(answer);
                    changeMessage(serverB);


                } catch (Exception e) {
                    answer = "false";
                }

                out.writeUTF(answer);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String process(String query) {
        String[] arr = query.split(" ");
//        String answer;

//        switch (arr[0]) {
//            case "register":  answer = register(arr[1], arr[2], arr[3]);
//                break;
//            case "login":  answer = login(arr[1], arr[2]);
//                break;
//            default:
//                answer = "wrong command";
//        }

        return query + " 8====Ý";
    }

//    public String register(String login, String password, String age) {
//        CarService.addClient(new entity.Client(login, password, Integer.parseInt(age)));
//        return "true";
//    }
//
//    public String login(String login, String password) {
//        entity.Client client = CarService.getClientByLogin(login);
//        if ((client != null) && (client.getPassword().equals(password))) {
//            return "true";
//        }
//        else {
//            return "false";
//        }
//    }
}
