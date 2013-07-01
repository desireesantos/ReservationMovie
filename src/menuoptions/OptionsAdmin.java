package menuoptions;

import exception.WrongOptionException;
import flow.FlowBookAdmin;
import main.InitFlowBook;
import units.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 2:08 PM
 */
public class OptionsAdmin {

    public static final int ONE = 1;
    private List<Book> listBooks = new ArrayList<Book>();

    public OptionsAdmin() {
        this.listBooks = listBooks();

    }

    public List<String> userProfile() {
        List<String> user = new ArrayList<String>();
        Client client = new Client();
        client.setName("Paulo Cesar Santos");

        user.add("Dados Cadastrais: ");
        user.add(" ");
        user.add("Nome Completo: " + client.getName());
        user.add("Id: " + client.getIdLibrary());
        user.add(" ");

        return user;
    }

    public List<String> availableBooks() {

        List<String> bookList = new ArrayList<String>();

        bookList.add("Available Book(s) ");
        bookList.add(" ");
        for(Book book: this.listBooks){
            if(!book.isReserved()){
                bookList.add(book.getName());
            }
        }
        bookList.add(" ");

        return bookList;
    }

    public List<String> reservedBooks() {
        List<String> bookList = new ArrayList<String>();

        bookList.add("Reserved Book(s): ");
        bookList.add(" ");
        for(Book book: this.listBooks){
            if(book.isReserved()){
                bookList.add(book.getName());
            }

        }
        bookList.add(" ");

        if(bookList.size() == 3){
            bookList.add(Message.NO_BOOK);
        }

        return bookList;
    }

    public List<String> showListBooks() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("Reserved Books: ");
        stringList.add(" ");
        for(Book book: this.listBooks){
            stringList.add(book.getName() + " - Reserved: " + book.isReserved());
        }
        stringList.add(" ");

        return  stringList;
    }


    public List<Book> listBooks(){


        Book book = new Book();
        book.setName("Thinking Java");
        book.setReserved(false);
        listBooks.add(book);

        Book book2 = new Book();
        book2.setName("Padrões de Software");
        book2.setReserved(false);
        listBooks.add(book2);

        Book book3 = new Book();
        book3.setName("Agile Samurai");
        book3.setReserved(true);
        listBooks.add(book3);


        return listBooks;
    }

    public List<String> reserveBook() {

        List<String> listBook = listBooksToReserv();
        return  chooseBook(listBook);
    }


    private List<String> chooseBook(List<String> listBook) {
        FlowBookAdmin flow = new FlowBookAdmin();
        int indexBook = flow.flowToReservBook(listBook);
        return reservBook(indexBook);

    }

    private List<String> listBooksToReserv() {
        List<String> listBook = new ArrayList<String>();
        for (int x=0; x <= this.listBooks.size() - ONE; x++){
            listBook.add((x+ ONE) +" - "+this.listBooks.get(x).getName());
        }
        listBook.add(" ");
        return listBook;
    }



    public List<String> reservBook(int bookIndex) {
        List<String> reservedBook = new ArrayList<String>();
        if(bookIndex <= this.listBooks.size()){

            if(this.listBooks.get(bookIndex - ONE).isReserved()){
                reservedBook.add(Message.SORRY_MESSAGE);
                return reservedBook;
            } else {
                this.listBooks.get(bookIndex-ONE).setReserved(true);
                System.out.println(this.listBooks.get(bookIndex - ONE).isReserved());
                reservedBook.add(Message.THANK_MESSAGE);
                return reservedBook;
            }

        } else
            new WrongOptionException();

        return reservedBook;

    }

    public List<String> unreserveBook() {
        List<String> booksReserved = new ArrayList<String>();
        booksReserved.add("Reserved Books: ");
        booksReserved.add(" ");

        List<Book> books = new ArrayList<Book>();
        for(Book book: listBooks){
            if(book.isReserved())
                books.add(book);
        }

        if (books.size() == 0){
            booksReserved.add(Message.NO_BOOK);
            return booksReserved;
        }

        for (int x=2; x <= reservedBooks().size() -2; x++){
            booksReserved.add((x - ONE) +" - "+this.reservedBooks().get(x));
        }
        booksReserved.add(" ");

        return unReserveChoose(booksReserved);
    }


    private List<String> unReserveChoose(List<String> bookReserved) {
        FlowBookAdmin flow = new FlowBookAdmin();
        int indexBook = flow.flowToReservBook(bookReserved);

        return rollbackReservBook(indexBook);

    }


    public List<String> rollbackReservBook(int bookIndex)  {
        List<String> unReservedBook = new ArrayList<String>();
        List<Book> books = new ArrayList<Book>();
        for(Book book: listBooks){
            if(book.isReserved())
                books.add(book);
        }

        if(bookIndex - ONE <= books.size() ){
            books.get(bookIndex-ONE).setReserved(false);
            unReservedBook.add(Message.THANK_MESSAGE_UNRESERVED_BOOK);
            return unReservedBook;
        } else {
            unReservedBook.add(Message.NO_BOOK);
            return unReservedBook;
        }


    }

    public void createUser() {
        FlowBookAdmin flow = new FlowBookAdmin();
        flow.flowToCreateClient();
    }

    public void logout() {
        InitFlowBook.main(null);
    }

    public void exit() {
        System.exit(1);
    }
}
