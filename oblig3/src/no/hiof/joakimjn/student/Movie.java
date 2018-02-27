package no.hiof.joakimjn.student;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Production implements Comparable {

    private static ArrayList<Movie> movieList = new ArrayList<>();


    public Movie(String title, int duration, String description, Date releaseDate) {
        super(title, duration, description, releaseDate);

    }


    @Override
    public String toString() {
        return "Title: " + super.getTitle() + ". Description: " + super.getDescription() + ". Duration: " + super.getDuration()
                + ". Release date: " + super.getReleaseDate() + ". Director: " + super.getDirector();

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
