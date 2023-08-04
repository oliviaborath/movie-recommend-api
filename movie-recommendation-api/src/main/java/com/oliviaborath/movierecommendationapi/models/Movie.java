package com.oliviaborath.movierecommendationapi.models;

import java.util.List;

public class Movie {

    private String title;
    private List<String> genres;
    private String type;
  

    public Movie(String title, List<String> genres, String type) {
        this.title = title;
        this.genres = genres;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
