import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/navbar";
import Listing from "./pages/listing";
import NewTopic from "./pages/newTopic";
import './styles.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import TopicPage from "./pages/topic";

const App = () => {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path='/' element={<Listing />} />
        <Route path='/new_topic' element={<NewTopic />} />
        <Route path='/topic'>
          <Route path=':id' element={<TopicPage/>}/>
        </Route>
      </Routes>
      <ToastContainer />
    </Router>
  );
}

export default App;
