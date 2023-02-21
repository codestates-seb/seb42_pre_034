import './App.css';
import Header from './components/Header';
import Login from './Pages/Login';
import Home from './Pages/Home';
import { Routes, Route } from 'react-router-dom';

function App() {
  return (
    <>
      <Header />
      <div className="flex flex-wrap flex-row justify-center items-center w-[100%]] h-[100vh]">
        <Routes>
          <Route path="*" element={<Home />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
    </>
  );
}

export default App;
