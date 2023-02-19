import './App.css';
import Header from './components/Header';
import Login from './pages/Login';
import Home from './pages/Home';
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div className="flex flex-wrap flex-row justify-center items-start w-[100%]] h-[100vh]">
      <Header />
      <Routes>
        <Route exact path="/seb42_pre_034/" element={<Home />} />
        <Route path="/seb42_pre_034/login" element={<Login />} />
      </Routes>
    </div>
  );
}

export default App;
