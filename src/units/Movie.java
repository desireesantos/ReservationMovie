package units;

import java.util.Random;

/**
 * User: dsantos
 * Date: 6/29/13  - Time: 10:12 PM
 */
public class Movie {

    private String name;
    private int year;
    private String directorName;
    private String rating;

    public Movie(String name, int year, String directorName) {
        this.name = name;
        this.year = year;
        this.directorName = directorName;
        this.rating = createRating();
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String createRating() {
        Random sortedNumber = new Random();
        rating = String.valueOf(sortedNumber.nextInt(10));

        return rating.equals("0") ?  "N/A" : rating;
    }


}
