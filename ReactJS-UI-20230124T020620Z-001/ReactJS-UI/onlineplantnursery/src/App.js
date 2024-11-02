import React from "react";
import "./App.css";
import CreatePlantComponent from "./components/Plants/CreatePlantComponent";
import PlantComponent from "./components/Plants/PlantComponent";
import UpdatePlant from "./components/Plants/UpdatePlant";
import SeedComponent from "./components/Seeds/SeedComponent";
import CreateSeedComponent from "./components/Seeds/CreateSeedComponent";
import UpdateSeed from "./components/Seeds/UpdateSeed";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CreatePlanterComponent from "./components/Planter/CreatePlanterComponent";
import PlanterComponent from "./components/Planter/PlanterComponent";
import UpdatePlanter from "./components/Planter/UpdatePlanter";
import Login from "./components/Login/Login";
import App1 from "./components/Screens/App1";
import Footer from "./components/Footer/Footer";
import CreateCustomerComponent from "./components/Customer/CreateCustomerComponent";
import CustomerComponent from "./components/Customer/CustomerComponent";
import UpdateCustomer from "./components/Customer/UpdateCustomer";
import OrderComponent from "./components/Order/OrderComponent";
import Navbar from "./components/Navbar/navbar";

function App() {
  
  return (
    <div className="App">
      <BrowserRouter>
     
        <Routes>
          <Route path="/" exact element={<Login />}></Route>
          <Route path="/home" exact element={<App1 />}></Route>
          <Route path="/Footer" exact element={<Footer />}></Route>
          <Route path="/Footer" exact element={<Footer />}></Route>
          <Route path="/Planter" exact element={<CreatePlanterComponent />}></Route>
          <Route path="/PlanterComponent" exact element={<PlanterComponent />}></Route>
          <Route path="/update-planter/:id" exact element={<UpdatePlanter />}></Route>
          <Route path="/Plant" exact element={<CreatePlantComponent />}></Route>
          <Route path="/PlantComponent" exact element={<PlantComponent />}></Route>
          <Route path="/update-plant/:id" exact element={<UpdatePlant />}></Route>
          <Route path="/Seed" exact element={<CreateSeedComponent />}></Route>
          <Route path="/SeedComponent" exact element={<SeedComponent />}></Route>
          <Route path="/update-seed/:id" exact element={<UpdateSeed />}></Route>
          <Route path="/Customer" exact element={<CreateCustomerComponent />}></Route>
          <Route path="/CustomerComponent" exact element={<CustomerComponent />}></Route>
          <Route path="/update-customer/:id" exact element={<UpdateCustomer />}></Route>
          <Route path="/OrderComponent" exact element={<OrderComponent />}></Route>
          </Routes>
       
      </BrowserRouter>
      <Footer/>

    </div>

  );
}

export default App;
