package no.hiof.joakimjn.student.model;


import java.time.LocalDate;


public class Episode extends Production implements Comparable<Episode> {

    private int episodeNr;
    private int season;



    //Constructor WO duration
    public Episode(int episodeNr, int season, String title) {
        super(title);
        this.episodeNr = episodeNr;
        this.season = season;

    }

    //Constructor W duration
    public Episode(int episodeNr, int season, String title, int duration) {
        super(title, duration);
        this.episodeNr = episodeNr;
        this.season = season;
    }

    // Constructor all
    public Episode(String title, int duration, String description, LocalDate releaseDate, int episodeNr, int season) {
        super(title, duration, description, releaseDate);
        this.episodeNr = episodeNr;
        this.season = season;
    }
    //Getters and Setters

    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }


    @Override
    public int compareTo(Episode o) {

        if (this.season < o.season) {
            return -1;
        }
        else if (this.season > o.season) {
            return 1;
        }
        else if (this.getEpisodeNr() < o.episodeNr) {
            return -1;
        }
        else if (this.episodeNr > o.episodeNr) {
            return 1;
        }
        return 0;
    }

    @Override                                                                                                   // Venter på production
    public String toString() {
        return "Season: "+season+ " Episode: "+ episodeNr + " Title: "+ super.getTitle() + " Duration: "+ super.getDuration()+"min" + "\n";
    }
}
