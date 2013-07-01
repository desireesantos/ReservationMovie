package in;


import units.Client;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 7:40 PM
 */
public class Input {

    public static final String ADMIN = "A";
    public static final int EXIST_PASSORD = 3;
    public static final int HAS_PASSWORD = EXIST_PASSORD;

    public List<String> getInformationsFromConsole(){

        List<String> personalInformationFromConsole = new ArrayList<String>();
        Console console = System.console();
        personalInformationFromConsole.add(console.readLine("Type your Username: "));
        personalInformationFromConsole.add(String.valueOf(console.readPassword("Type your password: ")));

        return personalInformationFromConsole ;
    }

    public Client createClientFromConsole(){
        Client client = new Client();
        boolean permission;

        Console console = System.console();
        client.setName(console.readLine("Type your Username: "));
        client.setPassord(new String(console.readPassword ("Type your password: ")));
        permission = isPermitted(console.readLine("Type what are you [A]Admin - [U]User: "));
        client.setPermission(permission);
        return client;
    }

    public int getInformationsFromScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public Client createUser(List<String> informationClient, int idUserNumber){
       Client client = new Client();

        client.setName(String.valueOf(idUserNumber));
        client.setPassord(informationClient.get(1));
        client.setIdLibrary(String.valueOf(idUserNumber));
        if (informationClient.size() == HAS_PASSWORD)

            client.setPermission(Boolean.parseBoolean(informationClient.get(2)));

       return client;
    }

    private boolean isPermitted(String permission){
      return   permission.equalsIgnoreCase(ADMIN) ? true : false;
    }
}
