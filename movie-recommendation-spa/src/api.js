// api.js
import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/recommendations';

export async function getRecommendations(userPreferences, includeMovies, includeTVShows) {
  try {
    const response = await axios.get(BASE_URL, {
      params: {
        userPreferences: userPreferences.join(','),
        includeMovies: includeMovies,
        includeTVShows: includeTVShows,
      },
    });
    return response.data;
  } catch (error) {
    console.error('Error fetching movie recommendations:', error);
    throw new Error('Failed to fetch movie recommendations.');
  }
}
