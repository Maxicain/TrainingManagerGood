import React from 'react';
import logo from './logo.svg';
import './App.css';
import Ville from './Model/Ville'
import { useState, useEffect } from 'react';
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;

function App() {
  var [villes, SetVilles] = useState<any[]>([])

  useEffect(() => {(async () => {
    const response = await fetch("http://localhost:8080/villes");
    const json = await response.json();
    SetVilles(json)
  })()}, [])

  // @ts-ignore
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
      <div>
          <h2>Villes</h2>
        {villes.map((ville) =>
            <li key={ville.id}>{ville.nom}</li>)}
      </div>
      <footer>

      </footer>
    </div>
  );
}

export default App;
