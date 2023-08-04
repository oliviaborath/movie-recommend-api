package com.oliviaborath.movierecommendationapi.services;

import com.oliviaborath.movierecommendationapi.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
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

    @Override
    public List<String> getMovieRecommendations(List<String> userPreferences) {
        List<String> movieRecommendations = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getType().equals("movie") && matchesPreferences(movie.getGenres(), userPreferences)) {
                movieRecommendations.add(movie.getTitle());
            }
        }
        return movieRecommendations;
    }

    @Override
    public List<String> getTVShowRecommendations(List<String> userPreferences) {
        List<String> tvShowRecommendations = new ArrayList<>();
        for (Movie tvShow : movies) {
            if (tvShow.getType().equals("tv show") && matchesPreferences(tvShow.getGenres(), userPreferences)) {
                tvShowRecommendations.add(tvShow.getTitle());
            }
        }
        return tvShowRecommendations;
    }

    private boolean matchesPreferences(List<String> genres, List<String> userPreferences) {
        // Convert both lists to lowercase to perform a case-insensitive comparison
        List<String> lowercaseGenres = genres.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    
        List<String> lowercaseUserPreferences = userPreferences.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    
        // Check if there is any intersection between the genres and user preferences
        return lowercaseGenres.stream().anyMatch(lowercaseUserPreferences::contains);
    }

}
