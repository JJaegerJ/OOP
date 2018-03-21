package no.hiof.joakimjn.student.model;

import java.time.LocalDate;                    // Series er ferdig refactorert
import java.util.ArrayList;


public class Series implements Comparable<Series>{

    private static ArrayList<Series> seriesList = new ArrayList<>();
    private String title;
    private String description;
    private LocalDate releaseDate;
    private ArrayList<Episode> episodeList = new ArrayList<>();
    private float avgDuration;
    private int numberOfSeasons;


    //Constuctor
    public Series(String title, String description, LocalDate releaseDate) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        seriesList.add(this);
    }

    //Getter and Setters
    public static ArrayList<Series> getSeriesList() {
        return seriesList;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(ArrayList<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public float getAvgDuration() {
        return avgDuration;
    }

    //Metodes
    public void addEpisode(Episode episode) {
        if (episode.getSeason() > numberOfSeasons + 1) {
            System.out.println("Kan ikke legge til en episode som er 2 eller fler sesonger høyere enn den gjeldene sesongen");
        }
        else{
            this.episodeList.add(episode);
            if (episode.getSeason() > numberOfSeasons) {
                numberOfSeasons = episode.getSeason();
            }
        }
        updateAvgDuration();
    }
    public void printSeason( int seasonNr) {
        for (Episode y: episodeList){
            if ( y.getSeason() == seasonNr){
                System.out.println(y);
            }
        }
    }
    private void updateAvgDuration() {

        float totalDuration = 0;

        for (Episode i: episodeList) {
            totalDuration += i.getDuration();
        }
        avgDuration = totalDuration/episodeList.size();
    }
    public ArrayList<Role> getCast() {
        ArrayList<Role> castList = new ArrayList<>();
        for (Episode i: episodeList) {
            for (Role e: i.getRoleList()) {
                castList.add(e);
            }
        }
        return castList;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescrition: " + description + "\nRelease date: " + releaseDate.getYear() + "\nEpisode Liste: \n" + episodeList;
    }



    @Override
    public int compareTo(Series o) {

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