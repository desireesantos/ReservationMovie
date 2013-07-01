package menuoptions;

import exception.WrongOptionException;
import flow.FlowBookUser;
import main.InitFlowBook;
import units.Book;
import units.Client;
import units.Message;
import units.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dsantos
 * Date: 5/27/13  - Time: 2:08 PM
 */
public class OptionsUser {

    public static final int ONE = 1;
    private List<Book> listBooks = new ArrayList<Book>();

    public OptionsUser() {
        this.listBooks = listBooks();

    }

    public List<String> userProfile(Client currentClient) {
        List<String> user = new ArrayList<String>();
        Client client = currentClient;

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
        } else {
            new WrongOptionException();
        }
        return reservedBook;
    }


    public void logout() {

        InitFlowBook.main(null);
    }

    public void exit() {
        System.exit(1);
    }


    private List<String> chooseBook(List<String> listBook) {
        FlowBookUser flow = new FlowBookUser();
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

    public List<String> listMovies(){
        List<String> listMovie = new ArrayList<String>();
          listMovie.add("Movie         Year      Director   Rating");

        for(Movie movie: createListMovies()){
            listMovie.add(createString(movie));
        }

        listMovie.add(" ");
        return listMovie ;
    }

    private String createString(Movie movie) {
      return   movie.getName() +"  "+movie.getYear()+"  "+movie.getDirectorName()+"     "+movie.createRating();
    }

    private List<Movie> createListMovies(){
        final int YEAR = 2000;
        final String MOVIE = "LAGOA_AZUL";
        final String DIRECTOR_NAME = "Ramesh Sippy";

        List<Movie> listMovie = new ArrayList<Movie>();
        for(int x=0; x < 15; x++){
            Movie movie = new Movie(MOVIE +x,YEAR +x, DIRECTOR_NAME);
            listMovie.add(movie);
        }
          return listMovie;
    }
}
