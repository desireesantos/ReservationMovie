package flow;

import in.Input;
import output.Writer;
import menu.MenuUser;
import units.Client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * User: dsantos
 * Date: 6/5/13  - Time: 9:22 PM
 */
public class FlowBookUser {

    private Input input = new Input();
    private MenuUser menu = new MenuUser();
    public static final int USERWANT_RESERVEBOOK = 5;

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    private Client client;

    public void flow(){
        printMenu();
        int number = informationFromScanner();
        if(isToReserveBook(number)){
            listAllBooksToReserv();
        }else {
            updateUserInMenu();
            List<String> stringListToPrint = menu.commandUser(number);
            printStringListsOnFlow(stringListToPrint);
        }
    }

    private void updateUserInMenu() {
        menu.setUser(client);
    }

    public int flowToReservBook(List<String> listBook) {
        printOnlyOneUnit(listBook);
        return input.getInformationsFromScanner();
    }



    private void listAllBooksToReserv() {
        List<String> stringReservList = menu.commandUser(USERWANT_RESERVEBOOK);
        printStringListsOnFlow(stringReservList);
    }

    private boolean isToReserveBook(int number) {

        return number == USERWANT_RESERVEBOOK ? true : false;
    }

    private static void printStringListsOnFlow(List<String> stringListToPrint) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new Writer(outputStream, new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[0]))));

        writer.printONFlowUser(stringListToPrint);
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
        MenuUser menu = new MenuUser() ;
        printOnlyOneUnit(menu.printMenu());
    }




}
