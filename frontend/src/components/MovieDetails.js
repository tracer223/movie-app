import React, { useState } from 'react';

const MovieDetails = () => {
  const [movie, setMovie] = useState(null);
  const [title, setTitle] = useState('');

  const fetchMovie = async () => {
    try {
      const response = await fetch(`http://localhost:8080/api/movies/fetch-movie?title=${encodeURIComponent(title)}`);
      const data = await response.json();
      setMovie(data);
    } catch (error) {
      console.error('Error fetching movie:', error);
    }
  };

  const handleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    fetchMovie();
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input type="text" value={title} onChange={handleChange} placeholder="Enter movie title" />
        <button type="submit">Fetch Movie</button>
      </form>
      {movie && (
        <div>
          <h2>{movie.Title}</h2>
          <p>Year: {movie.Year}</p>
          <p>Director: {movie.Director}</p>
          <p>Plot: {movie.Plot}</p>
          {/* Render other movie details as needed */}
        </div>
      )}
    </div>
  );
};

export default MovieDetails;
