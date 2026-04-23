package org.spring.streamexamples;

public class Movies {

    private String name;
    private String genre;
    private double rating;
    private int year;
    private int duration; // in minutes

    public Movies(String name, String genre, double rating, int year, int duration) {
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
        this.duration = duration;
    }

    public String getName() { return name; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getYear() { return year; }
    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return name + " (" + genre + ", " + rating + ")";
    }
}

