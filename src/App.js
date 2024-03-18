import './App.css';
import './components/SimpleForm.js'
import MyForm from './components/SimpleForm.js';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>
          Search For Movie in form below
        </p>
          <MyForm />
      </header>
    </div>
  );
}

export default App;
