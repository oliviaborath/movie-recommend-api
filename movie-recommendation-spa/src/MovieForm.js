import React, { useState, useEffect, useRef } from 'react';
import { getRecommendations } from './api';

const MovieForm = () => {
  const genres = [
    'Drama',
    'Crime',
    'Action',
    'Adventure',
    'Romance',
    'Sci-Fi',
    'Thriller',
    'Comedy',
  ];

  const [selectedGenre, setSelectedGenre] = useState('');
  const [recommendations, setRecommendations] = useState([]);
  const dropdownRef = useRef(null);

  const handleGetRecommendations = async () => {
    try {
      const response = await getRecommendations([selectedGenre]);
      setRecommendations(response);
    } catch (error) {
      // Handle the error here if needed
    }
  };

  const handleGenreSelect = (genre) => {
    setSelectedGenre(genre);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        document.getElementById('genreDropdown').classList.remove('show');
      }
    };

    document.addEventListener('mousedown', handleOutsideClick);

    return () => {
      document.removeEventListener('mousedown', handleOutsideClick);
    };
  }, []);

  return (
    <div className="container mt-5">
      <h1 className="mb-4">Movie Recommendations</h1>
      <div className="input-group mb-3">
        <div className="input-group-prepend">
          {!selectedGenre && (
            <button
              className="btn btn-primary dropdown-toggle"
              type="button"
              onClick={() => document.getElementById('genreDropdown').classList.toggle('show')}
            >
              Select Genre
            </button>
          )}
          {selectedGenre && (
            <button
              className="btn btn-primary dropdown-toggle"
              type="button"
              onClick={() => document.getElementById('genreDropdown').classList.toggle('show')}
            >
              {selectedGenre}
            </button>
          )}
          <div className={`dropdown-menu ${selectedGenre ? 'show' : ''}`} id="genreDropdown" ref={dropdownRef}>
            {genres.map((genre) => (
              <button
                key={genre}
                className="dropdown-item"
                type="button"
                onClick={() => handleGenreSelect(genre)}
              >
                {genre}
              </button>
            ))}
          </div>
        </div>
        <input
          type="text"
          className="form-control"
          value={selectedGenre}
          onChange={(e) => setSelectedGenre(e.target.value)}
          placeholder="Enter your preferences (or use the dropdown)"
        />
        <button className="btn btn-primary" onClick={handleGetRecommendations} type="button">
          Get Recommendations
        </button>
      </div>

      {/* Display the movie recommendations */}
      <ul className="list-group">
        {recommendations.map((movie, index) => (
          <li key={index} className="list-group-item">
            {movie}
          </li>
        ))}
      </ul>

      <p className="mt-4 text-muted">Powered by Movie Recommendation API</p>
    </div>
  );
};

export default MovieForm;
