package no.hiof.joakimjn.student;

import java.util.Date;

import java.util.ArrayList;


public abstract class Production {

    private String title;
    private int duration;
    private String description;
    private Date releaseDate;
    private Person director;
    private ArrayList<Role> roleList = new ArrayList<>();




    public Production() {
    }

    public Production(String title) {
        this.title = title;
    }

    public Production(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Production(String title, int duration, String description, Date releaseDate) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public ArrayList<Role> getRoleList() {
        return roleList;
    }
    //metodes
    public void addRole (Role role) {
        roleList.add(role);
    }

    public  void addManyRoles (ArrayList<Role> role) {
        roleList.addAll(role);
    }

    @Override
    public String toString() {
        return "Title: " + title + " Description: " + description + " Duration: " + duration
                + " Release date: " + releaseDate + " Director: " + director + " Role List: " + roleList;
    }
}
