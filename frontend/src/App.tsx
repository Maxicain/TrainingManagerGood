import React from 'react';
import logo from './logo.svg';
import './App.css';
import { useState, useEffect } from 'react';

function App() {
  var [villes, SetVilles] = useState([])

  useEffect(() => {
    fetch("http://localhost:8080/villes")
        .then((response) => response.json())
        .then((json) => SetVilles(
            {
              villes: json.map((ville) => {

              })
            }
        ))
  })

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
