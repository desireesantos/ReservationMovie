package menu;

import exception.WrongOptionException;
import menuoptions.OptionsAdmin;
import menuoptions.OptionsUser;
import units.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o menu principal do sistema
 * Linha nova
 * Outra linha nova
 */
public class MenuUser {

    private static OptionsUser manage = new OptionsUser();

    public void setUser(Client user) {
        this.user = user;
    }

    private Client user;


    public List<String> printMenu() {
        List<String> stringListToPrint = new ArrayList<String>();

        stringListToPrint.add(" ");
        stringListToPrint.add("1 - List all Books ");
        stringListToPrint.add("2 - Available Books ");
        stringListToPrint.add("3 - Reserved Books ");
        stringListToPrint.add("4 - Your profile ");
        stringListToPrint.add("5 - Reserve Books ");
        stringListToPrint.add("6 - List of Movie ");
        stringListToPrint.add("7 - Change User ");
        stringListToPrint.add("8 - Exit ");
        stringListToPrint.add(" ");

        return stringListToPrint;
    }

    public List<String> commandUser(int userType) {
        switch (userType) {

            case 1:
                return(manage.showListBooks());
            case 2:
                return(manage.availableBooks());
            case 3:
                return(manage.reservedBooks());
            case 4:
                return(manage.userProfile(user));
            case 5:
                return(manage.reserveBook());
            case 6:
                 return(manage.listMovies());
            case 7:
                manage.logout();
            case 8:
                manage.exit();
            default:
                new WrongOptionException();
        }
        return null;
    }



}
