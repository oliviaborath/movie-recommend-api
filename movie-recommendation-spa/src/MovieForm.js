// MovieForm.js
import React, { useState, useEffect, useRef } from 'react';
import { getRecommendations } from './api';
import './MovieForm.css';

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
    'Biography',
    'Mystery',
    'Western',
    'Music',
    'Family',
    'War',
    'Horror',
    'Sport',
    'Film-Noir',
  ];

  const [selectedGenre, setSelectedGenre] = useState('');
  const [recommendations, setRecommendations] = useState([]);
  const [includeMovies, setIncludeMovies] = useState(false);
  const [includeTVShows, setIncludeTVShows] = useState(false);
  const dropdownRef = useRef(null);

  const handleGetRecommendations = async () => {
    try {
      const response = await getRecommendations([selectedGenre], includeMovies, includeTVShows);
      setRecommendations(response);
    } catch (error) {
      // Handle the error here if needed
    }
  };

  const [isDropdownOpen, setIsDropdownOpen] = useState(false);

  const handleGenreSelect = (genre) => {
    setSelectedGenre(genre);
    setIsDropdownOpen(false);
  };

  const handleToggleDropdown = () => {
    setIsDropdownOpen((prevState) => !prevState);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setIsDropdownOpen(false);
      }
    };

    document.addEventListener('mousedown', handleOutsideClick);

    return () => {
      document.removeEventListener('mousedown', handleOutsideClick);
    };
  }, []);

  return (
    <div className="container">
      <div className="input-group">
        {/* Genre Dropdown */}
        <div className="dropdown">
          <button
            className="btn btn-primary dropdown-toggle"
            type="button"
            onClick={handleToggleDropdown}
          >
            {selectedGenre ? selectedGenre : 'Select Genre'}
          </button>
          <div className={`dropdown-menu ${isDropdownOpen ? 'show' : ''}`} ref={dropdownRef}>
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

        {/* Your Preference */}
        {selectedGenre && (
          <div className="your-preference">
            Your Preference: {selectedGenre}
          </div>
        )}

        {/* Input field */}
        <input
          type="text"
          className="form-control"
          value={selectedGenre}
          onChange={(e) => setSelectedGenre(e.target.value)}
          placeholder="Enter your preferences (or use the dropdown)"
        />

        <div className="form-check form-check-inline mt-3">
          <input
            type="checkbox"
            className="form-check-input"
            id="includeMovies"
            checked={includeMovies}
            onChange={() => setIncludeMovies(!includeMovies)}
          />
          <label className="form-check-label" htmlFor="includeMovies">
            Include Movies
          </label>
        </div>

        <div className="form-check form-check-inline mt-3">
          <input
            type="checkbox"
            className="form-check-input"
            id="includeTVShows"
            checked={includeTVShows}
            onChange={() => setIncludeTVShows(!includeTVShows)}
          />
          <label className="form-check-label" htmlFor="includeTVShows">
            Include TV Shows
          </label>
        </div>

        <button className="btn btn-primary mt-3" onClick={handleGetRecommendations} type="button">
          Get Recommendations
        </button>
      </div>

      <ul className="list-group mt-3">
        {recommendations.map((movie, index) => (
          <li key={index} className="list-group-item">
            {movie}
          </li>
        ))}
      </ul>

      <p className="mt-4 text-muted">Powered by Olivia Munineath Borath</p>
    </div>
  );
};

export default MovieForm;
