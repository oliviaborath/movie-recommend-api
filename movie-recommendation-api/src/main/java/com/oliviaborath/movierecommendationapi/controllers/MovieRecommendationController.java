package com.oliviaborath.movierecommendationapi.controllers;

import java.util.List;

import com.oliviaborath.movierecommendationapi.services.MovieRecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRecommendationController {

    private final MovieRecommendationService movieRecommendationService;

    public MovieRecommendationController(MovieRecommendationService movieRecommendationService) {
        this.movieRecommendationService = movieRecommendationService;
    }

    @GetMapping("/api/recommendations")
    public List<String> getRecommendations(
            @RequestParam List<String> userPreferences,
            @RequestParam(required = false) Boolean includeMovies,
            @RequestParam(required = false) Boolean includeTVShows
    ) {
        if (includeMovies != null && includeTVShows != null) {
            if (includeMovies && includeTVShows) {
                // Return both movie and TV show recommendations
                return movieRecommendationService.getRecommendations(userPreferences);
            } else if (includeMovies) {
                // Return movie recommendations only
                return movieRecommendationService.getMovieRecommendations(userPreferences);
            } else if (includeTVShows) {
                // Return TV show recommendations only
                return movieRecommendationService.getTVShowRecommendations(userPreferences);
            }
        }

        // Default: Return empty list if no preference or invalid combination is provided
        return List.of();
    }
}
