import React from 'react';

function MyForm() {
  const handleSubmit = (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const query = formData.get('query');
    alert(`You searched for '${query}'`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="query" placeholder="Enter your search query" />
      <button type="submit">Search</button>
    </form>
  );
}

export default MyForm;
