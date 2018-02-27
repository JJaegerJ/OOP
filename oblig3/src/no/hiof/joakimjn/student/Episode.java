package no.hiof.joakimjn.student;

import java.util.Date;

public class Episode extends Production {

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
    public Episode(String title, int duration, String description, Date releaseDate, int episodeNr, int season) {
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
    public String toString() {
        return "Season: "+season+ " Episode: "+ episodeNr + " Title: "+ super.getTitle() + " Duration: "+ super.getDuration()+"min" + "\n";
    }
}
