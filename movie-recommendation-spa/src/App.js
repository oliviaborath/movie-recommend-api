// App.js

import React, { useState } from 'react';
import MovieList from './MovieList';
import MovieForm from './MovieForm';
import { getRecommendations } from './api'; // Import the getRecommendations function

const BASE_URL = 'http://localhost:8080/api/recommendations'; // Replace with your actual API URL

const App = () => {
  const [recommendedMovies, setRecommendedMovies] = useState([]);

  const handleGetMovieRecommendations = async (userPreferences, includeMovies, includeTVShows) => {
    try {
      const recommendations = await getRecommendations(userPreferences, includeMovies, includeTVShows);
      setRecommendedMovies(recommendations);
    } catch (error) {
      // Handle errors here
    }
  };

  return (
    <div>
      <MovieForm onSubmit={handleGetMovieRecommendations} />
      <MovieList recommendedMovies={recommendedMovies} />
    </div>
  );
};

export default App;
