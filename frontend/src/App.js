import './App.css';
import './components/MovieDetails.js'
import MovieDetails from './components/MovieDetails.js';

function App() {
  
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Search For Movie in form below
        </p>
          <MovieDetails />
      </header>
    </div>
  );
}

export default App;
