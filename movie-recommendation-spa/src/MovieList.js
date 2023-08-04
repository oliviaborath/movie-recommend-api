import React from 'react';

const MovieList = ({ recommendedMovies }) => {
  return (
    <div className="mt-4">
      <ul className="list-group">
        {recommendedMovies.map((movie, index) => (
          <li key={index} className="list-group-item">{movie}</li>
        ))}
      </ul>
    </div>
  );
};

export default MovieList;
