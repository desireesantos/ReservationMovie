package main;

import flow.FlowBookAdmin;
import flow.FlowBookUser;
import in.Input;
import output.Writer;
import units.Client;
import units.Message;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dsantos
 * Date: 6/11/13  - Time: 9:12 AM
 */
public class FlowBook {

    public static final int ONE = 1;
    static List<Client> clients = new ArrayList<Client>();
    static int idUserNumber;
    FlowBookAdmin admin = new FlowBookAdmin();
    FlowBookUser user = new FlowBookUser();




    public void init()  {
        Input input = new Input();

        printInicialMessage();
        updateListOfUser();
        Client client = input.createUser(input.getInformationsFromConsole(),idUserNumber);


        if(IsAdmin(client, clients))
            admin.flow();
        else
            user.setClient(client);
        user.flow();
    }



    private void updateIdUserNumber() {
        if(idUserNumber == 0 ){
            this.idUserNumber = 1111111;
        } else{
            this.idUserNumber += ONE;
        }

    }

    private void updateListOfUser() {
        updateIdUserNumber();
        for(Client client: admin.getClients()){

            if(!clients.contains(client)){
                clients.add(client);
            }
        }
    }

    private boolean IsAdmin(Client client, List<Client> clients) {
        for(Client user: clients) {
            if (client.getName().equalsIgnoreCase(user.getName()) && client.getPassword().equalsIgnoreCase(user.getPassword()))
                return user.isPermission();
        }
        return false;
    }

    private static void printInicialMessage() {
        List<String> stringList = new ArrayList<String>();
        stringList.add(Message.WELCOME);
        stringList.add(" ");
        printOnlyOneUnit(stringList);
    }


    private static void printOnlyOneUnit(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printMenu(stringListToPrint);
    }





}
