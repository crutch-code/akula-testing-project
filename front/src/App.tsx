import React from 'react';
import './styles/bootstrap.css';
import Main from './pages/Main'
import {NavBar} from './components/NavBar'

function App() {
    return (
        <div className="App">
            <NavBar/>
            <Main/>
            <footer>

            </footer>
        </div>
    );
}

export default App;
