package no.hiof.joakimjn.student;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Production implements Comparable<Movie> {

    private static ArrayList<Movie> movieList = new ArrayList<>();


    public Movie(String title, int duration, String description, Date releaseDate) {
        super(title, duration, description, releaseDate);
        movieList.add(this);

    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public String toString() {
        return "Title: " + super.getTitle() + ". Description: " + super.getDescription() + ". Duration: " + super.getDuration()
                + ". Release date: " + super.getReleaseDate() + ". Director: " + super.getDirector();

    }

    @Override
    public int compareTo(Movie o) {

        int compare = this.getTitle().compareTo(o.getTitle());

        if ( compare < 0) {
            return -1;
        }
        else if (compare > 0) {
            return 1;
        }
        return 0;

    }
}
