import { Link } from "react-router-dom";
import './index.css'

const Navbar = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-light justify-content-center py-0 navstyle">
            <Link to="/" className="fw-bold fs-6 navbar-brand textstyle">Home</Link>
            <Link to="/new_topic" className="fw-bold fs-6 navbar-brand textstyle">New topic</Link>
            <Link to="/about" className="fw-bold fs-6 navbar-brand textstyle">About</Link>
        </nav>
    );
};

export default Navbar;
