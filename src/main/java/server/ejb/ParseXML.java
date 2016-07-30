package server.ejb;

import server.entity.ClientE;
import server.entity.DriverE;

import java.io.File;

/**
 * Created by Павел on 30.07.2016.
 */
public interface ParseXML {
    public File parseDriverXML(DriverE driver);

    public File parseClientXML(ClientE client);
}
