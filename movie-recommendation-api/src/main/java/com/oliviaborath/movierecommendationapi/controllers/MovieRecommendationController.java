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
    public List<String> getRecommendations(@RequestParam List<String> userPreferences) {
        return movieRecommendationService.getRecommendations(userPreferences);
    }
}
