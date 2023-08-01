package com.oliviaborath.movierecommendationapi.services;

import java.util.List;

public interface MovieRecommendationService {

    /**
     * Gets movie recommendations based on user preferences.
     *
     * @param userPreferences A list of user preferences (e.g., movie genres).
     * @return A list of recommended movie titles.
     */
    List<String> getRecommendations(List<String> userPreferences);
}
