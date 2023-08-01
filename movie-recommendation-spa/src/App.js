// App.js

import React, { useState } from 'react';
import MovieList from './MovieList';
import MovieForm from './MovieForm';

import axios from 'axios';

// Keep the getRecommendations function here
const getRecommendations = async (userPreferences) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/recommendations`, {
      params: {
        userPreferences: userPreferences.join(','),
      },
    });
    return response.data;
  } catch (error) {
    console.error('Error fetching movie recommendations:', error);
    throw new Error('Failed to fetch movie recommendations.');
  }
};

const App = () => {
  const [recommendedMovies, setRecommendedMovies] = useState([]);

  const handleGetMovieRecommendations = async (userPreferences) => {
    try {
      const recommendations = await getRecommendations(userPreferences);
      setRecommendedMovies(recommendations);
    } catch (error) {
      // Handle errors here
    }
  };

  return (
    <div>
      <h1>Movie Recommendation SPA</h1>
      <MovieForm onSubmit={handleGetMovieRecommendations} />
      <MovieList recommendedMovies={recommendedMovies} />
    </div>
  );
}; 

export default App;
