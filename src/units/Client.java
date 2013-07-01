package units;

import com.sun.jmx.snmp.SnmpStringFixed;
import com.sun.org.apache.xerces.internal.xni.XMLString;

import javax.sound.sampled.AudioFileFormat;
import java.util.Random;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 1:59 PM
 */
public class Client {

    private String name;
    private String idLibrary;
    private String passord;
    private boolean permission;


    public void setIdLibrary(String id) {
        this.idLibrary = id.substring(0,3)+"-"+id.substring(3,7);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdLibrary() {
        return idLibrary;
    }


    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPassword() {
        return passord;
    }
}
