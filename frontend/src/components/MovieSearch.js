import React, { useState } from 'react';

const MovieSearch = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [searchResults, setSearchResults] = useState([]);

  useEffect(() => {
    axios.get('/api-key')
      .then(response => {
        const apiKey = response.data;
        console.log(apiKey);
      })
      .catch(error => {
        console.error('Error fetching API key:', error);
      });
  }, []);

  const handleSearch = async () => {
    try {
      const response = await fetch(`https://www.omdbapi.com/?apikey=${apiKey}&s=${encodeURIComponent(searchTerm)}`);
      const data = await response.json();
      setSearchResults(data.Search || []);
    } catch (error) {
      console.error('Error fetching search results:', error);
    }
  };

  const handleChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    handleSearch();
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input type="text" value={searchTerm} onChange={handleChange} placeholder="Search movies..." />
        <button type="submit">Search</button>
      </form>
      <div>
        {searchResults.map((movie) => (
          <div key={movie.imdbID}>
            <h3>{movie.Title}</h3>
            <p>Year: {movie.Year}</p>
            <img src={movie.Poster} alt={movie.Title} style={{ width: '100px', height: '150px' }} />
          </div>
        ))}
      </div>
    </div>
  );
};

export default MovieSearch;
