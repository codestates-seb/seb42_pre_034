import Menu from "../components/Menu";
import { Routes, Route } from "react-router-dom";
import Questions from './Questions';
import Tags from './Tags';
import Users from './Users';
import Companies from './Companies';

function Home() {
  return (
    <div>
      <Menu />
      <Routes>
        <Route path="*" element={<Questions />} />
        <Route path="/tags" element={<Tags />} />
        <Route path="/users" element={<Users />} />
        <Route path="/companies" element={<Companies />} />
      </Routes>
    </div>
  );
}

export default Home;
