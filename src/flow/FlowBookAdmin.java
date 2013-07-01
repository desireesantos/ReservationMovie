package flow;

import in.Input;
import output.Writer;
import units.Client;
import menu.MenuAdmin;
import units.Message;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 9:22 PM
 */
public class FlowBookAdmin {

    private Input input = new Input();
    private MenuAdmin menu = new MenuAdmin();
    public static final int USERWANT_RESERVEBOOK = 5;
    static private List<Client> clients = new ArrayList<Client>();

    public List<Client> getClients() {
        return clients;
    }

    public  FlowBookAdmin(){
        createClients();
    }


    public void flow(){
        printMenu();
        int number = informationFromScanner();
        if(isToReserveBook(number)){
            listAllBooksToReserv();
        }else {
            List<String> stringListToPrint = menu.commandAdmin(number);
            printStringListsOnFlow(stringListToPrint);
        }
    }

    public int flowToReservBook(List<String> listBook) {
        printOnlyOneUnit(listBook);
        return input.getInformationsFromScanner();
    }

    public boolean flowToCreateClient() {
        List<String> result = new ArrayList<String>();
        clients.add(input.createClientFromConsole());
        result.add(Message.CREATED_USER);
        printOnlyOneUnit(result);
        return true;
    }


    private void listAllBooksToReserv() {
        List<String> stringReservList = menu.commandAdmin(USERWANT_RESERVEBOOK);
        printStringListsOnFlow(stringReservList);
    }

    private boolean isToReserveBook(int number) {
        return number == USERWANT_RESERVEBOOK ? true : false;
    }

    private static void printStringListsOnFlow(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printONFlow(stringListToPrint);
    }

    private static void printOnlyOneUnit(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printMenu(stringListToPrint);
    }

    private static int informationFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void printMenu() {
        MenuAdmin menu = new MenuAdmin() ;
        printOnlyOneUnit(menu.printMenu());
    }

    private void createClients() {
        Client client = new Client();
        client.setName("admin");
        client.setPassord("admin");
        client.setPermission(true);
        clients.add(client);

        Client client1 = new Client();
        client1.setName("user");
        client1.setPassord("user");
        client1.setPermission(false);
        clients.add(client1);
    }


}
