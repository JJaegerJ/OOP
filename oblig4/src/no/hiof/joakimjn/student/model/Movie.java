package no.hiof.joakimjn.student.model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Movie extends Production implements Comparable<Movie> {

    private static ArrayList<Movie> movieList = new ArrayList<>();
    private String posterURL;


    public Movie(String title, int duration, String description, LocalDate releaseDate) {
        super(title, duration, description, releaseDate);
        movieList.add(this);
    }
    public Movie(String title, int duration, String description, LocalDate releaseDate, String imgURL) {
        super(title, duration, description, releaseDate);
        this.posterURL = posterURL;
        movieList.add(this);
    }

    public String getPosterURL() {
        return posterURL;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public String toString() {
        return super.getTitle();

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
