package com.example.mvvmexample.model;

public class MovieModel {
    String movieName;
    String movieYear;
    int movieImageUrl;


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public int getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(int movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }
}
