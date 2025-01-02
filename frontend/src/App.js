import logo from './logo.svg';
import './App.css';
import Navbar from './component/navbar/Navbar';
import { CssBaseline, ThemeProvider } from '@mui/material';
import { darkTheme } from './Theme/DarkTheme';
import Home from './component/Home/Home';

function App() {
  return (
    <div>
      <ThemeProvider theme={darkTheme}/>
      <CssBaseline/>
      <Navbar />
      <Home />
    </div>
  );
}

export default App;
