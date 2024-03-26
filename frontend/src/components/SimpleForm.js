import React from 'react';

function MyForm() {
  state = {
    movies: []
  };

  
  const handleSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const query = formData.get('query');
    // alert(`You searched for '${query}'`);
    const response = await fetch("/search/" + query);
    const body = await response.json();
    this.setState({movies: body});
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="query" placeholder="Enter your search query" />
      <button type="submit">Search</button>
    </form>
  );
}

export default MyForm;
