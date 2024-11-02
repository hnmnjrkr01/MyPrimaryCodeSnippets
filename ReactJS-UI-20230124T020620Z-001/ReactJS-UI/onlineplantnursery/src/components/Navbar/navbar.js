import React from "react";
import { useNavigate } from "react-router-dom";
import "./navbar.css"


const Navbar = ({ setShow, size }) => {
  const navigate=useNavigate();
  return (

    <nav>
      <div className="nav_box">
        <span className="my_shop" onClick={() => navigate("/Home")}>
          Plant Nursery
        </span>      
        <a className="anchor" href="./PlantComponent">Plant</a>
        <a className="anchor" href="./PlanterComponent">Planter</a>
        <a className="anchor" href="./SeedComponent">Seed</a>
        <a className="anchor" href="./CustomerComponent">Customer</a>
        <a className="anchor" href="./OrderComponent">Order</a>
        
      </div>
    </nav>
  );
};

export default Navbar;
