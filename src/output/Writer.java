package output;

import flow.FlowBookAdmin;
import flow.FlowBookUser;

import java.io.*;
import java.util.List;

/**
 * User: dsantos
 * Date: 6/3/13  - Time: 11:07 PM
 */
public class Writer {

    private PrintStream out;
    private BufferedReader in;


    public Writer(OutputStream outputStream, BufferedReader in){
        this.in = in;
        this.out = new PrintStream(outputStream);
    }

    public void printONFlow(List<String> writer) {
        FlowBookAdmin flowBook = new FlowBookAdmin();
        printMenu(writer);
        flowBook.flow();
    }

    public void printONFlowUser(List<String> writer) {
        FlowBookUser flowBook = new FlowBookUser();
        printMenu(writer);
        flowBook.flow();
    }

    public void printMenu(List<String> writer) {
        for (int x=0; x <= writer.size() -1 ;x++ ){
            System.out.println(writer.get(x).toString() + "\033[95m");
        }
        System.out.println(" ");

    }
}
