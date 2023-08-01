package com.oliviaborath.movierecommendationapi.services;

import com.oliviaborath.movierecommendationapi.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieRecommendationServiceImpl implements MovieRecommendationService {

    private final List<Movie> movies;

    // Constructor to inject the list of movies
    public MovieRecommendationServiceImpl(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public List<String> getRecommendations(List<String> userPreferences) {
        Map<String, Integer> genreFrequency = new HashMap<>();
        for (String genre : userPreferences) {
            genreFrequency.put(genre, genreFrequency.getOrDefault(genre, 0) + 1);
        }

        List<String> recommendedMovies = new ArrayList<>();
        boolean recommendationsFound = false;

        for (Movie movie : movies) {
            List<String> genres = movie.getGenres();
            for (String genre : genres) {
                if (genreFrequency.containsKey(genre)) {
                    recommendedMovies.add(movie.getTitle());
                    recommendationsFound = true;
                    break;
                }
            }
        }

        if (!recommendationsFound) {
            recommendedMovies.add("No recommendations found for the given preferences.");
        }

        return recommendedMovies;
    }
}
