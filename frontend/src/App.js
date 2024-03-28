import './App.css';
import './components/MovieSearch.js'
import MovieSearch from './components/MovieSearch.js';

function App() {
  
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Search For Movie in form below
        </p>
          <MovieSearch />
      </header>
    </div>
  );
}

export default App;
