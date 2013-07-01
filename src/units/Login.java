package units;

import output.Writer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * User: dsantos
 * Date: 6/5/13  - Time: 11:14 AM
 */
public class Login {

    public boolean execute(Client client){
        welcomeToSystem(client);
        return client.isPermission() ? true : false;
    }

    private void welcomeToSystem(Client client) {
        List<String> stringList = new ArrayList<String>();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        stringList.add(" ");
        stringList.add("Welcome " + client.getName());
        writer.printMenu(stringList);
    }




}

