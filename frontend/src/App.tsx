import './App.css';
import Footer from './Components/Footer';
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";
import AppRouter from "./Components/Router";

export const BASE_URL = "http://localhost:8080/"

function App() {
  return (
      <div className="App">
          <AppRouter/>
          <Footer/>
      </div>
  );
}

export default App;
