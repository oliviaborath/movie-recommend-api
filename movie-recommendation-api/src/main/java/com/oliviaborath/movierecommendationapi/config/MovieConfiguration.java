package com.oliviaborath.movierecommendationapi.config;

import com.oliviaborath.movierecommendationapi.models.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MovieConfiguration {

    @Bean
    public List<Movie> movies() {
        return Arrays.asList(
                new Movie("The Shawshank Redemption", Arrays.asList("Drama")),
                new Movie("The Godfather", Arrays.asList("Crime", "Drama")),
                new Movie("The Dark Knight", Arrays.asList("Action", "Crime", "Drama")),
                new Movie("The Lord of the Rings: The Return of the King", Arrays.asList("Action", "Adventure", "Drama")),
                new Movie("Pulp Fiction", Arrays.asList("Crime", "Drama")),
                new Movie("Forrest Gump", Arrays.asList("Drama", "Romance")),
                new Movie("Inception", Arrays.asList("Action", "Adventure", "Sci-Fi")),
                new Movie("The Matrix", Arrays.asList("Action", "Sci-Fi")),
                new Movie("Interstellar", Arrays.asList("Adventure", "Drama", "Sci-Fi")),
                new Movie("The Silence of the Lambs", Arrays.asList("Crime", "Drama", "Thriller")),
                new Movie("Gladiator", Arrays.asList("Action", "Adventure", "Drama")),
                new Movie("Braveheart", Arrays.asList("Biography", "Drama", "History")),
                new Movie("The Revenant", Arrays.asList("Action", "Adventure", "Drama")),
                new Movie("Fight Club", Arrays.asList("Drama")),
                new Movie("The Prestige", Arrays.asList("Drama", "Mystery", "Sci-Fi")),
                new Movie("The Departed", Arrays.asList("Crime", "Drama", "Thriller")),
                new Movie("The Green Mile", Arrays.asList("Crime", "Drama", "Fantasy")),
                new Movie("The Pianist", Arrays.asList("Biography", "Drama", "Music")),
                new Movie("The Lion King", Arrays.asList("Animation", "Adventure", "Drama")),
                new Movie("Inglourious Basterds", Arrays.asList("Adventure", "Drama", "War")),
                new Movie("Toy Story", Arrays.asList("Comedy")),
                new Movie("Schindler's List", Arrays.asList("Biography", "Drama", "History"))
        );
    }

    
}
