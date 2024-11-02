import React, { useState } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

function CreatePlanterComponent() {
  //Step 1:
  const navigate = useNavigate();
  const [planter, setPlanter] = useState({
    planterId: "",
    planterheight: "",
    planterCapacity: "",
    drainageHoles: "",
    planterColor: "",
    planterShape: "",
    planterStock: "",
    planterCost: "",
  });
  //Step 3:
  const onInputChange = (e) => {
    setPlanter({ ...planter, [e.target.name]: e.target.value });
  };
  const {
    planterId,
    planterheight,
    planterCapacity,
    planterColor,
    drainageHoles,
    planterShape,
    planterStock,
    planterCost,
  } = planter;

  const FormHandle = (e) => {
    e.preventDefault();
    addDataToServer(planter);
  };
  const addDataToServer = (data) => {
    axios.post("http://localhost:9092/planter/addPlanter", data).then(
      (response) => {
        console.log(response);
        alert("Planter Added Successfully");
        navigate("/PlanterComponent");
      },
      (error) => {
        console.log(error.response.data);
        alert("Operation failed");
      }
    );
  };
  return (
    <div>
      <Navbar/>
      <div className="container">
        <div className="w-75 mx-auto shadow p-5 mt-2 bg-light">
          <div class="jumbotron">
            <h1 class="display-4 text-center">Add Planters!</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
                <div class="form-group">
                  <label for="exampleInputEmail1">Planter Id</label>
                  <input
                    type="number"
                    class="form-control"
                    name="planterId"
                    placeholder="Enter Planter Id"
                    required
                    value={planterId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputEmail1">Planter Height</label>
                  <input
                    type="number"
                    class="form-control"
                    name="planterheight"
                    placeholder="Enter Planter Height"
                    required
                    value={planterheight}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Planter Capacity</label>
                  <input
                    type="number"
                    class="form-control"
                    name="planterCapacity"
                    placeholder="Enter Planter Capacity"
                    required
                    value={planterCapacity}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Drainage Holes</label>
                  <input
                    type="number"
                    class="form-control"
                    name="drainageHoles"
                    placeholder="Enter Drainage holes"
                    required
                    value={drainageHoles}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Planter Color</label>
                  <input
                    type="text"
                    class="form-control"
                    name="planterColor"
                    placeholder="Enter Planter Color"
                    required
                    value={planterColor}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Planter Shape</label>
                  <input
                    type="text"
                    class="form-control"
                    name="planterShape"
                    placeholder="Enter Planter Shape"
                    required
                    value={planterShape}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div class="form-group">
                  <label for="exampleInputPassword1">Planter Stock </label>
                  <input
                    type="text"
                    class="form-control"
                    name="planterStock"
                    placeholder="Enter Stock"
                    required
                    value={planterStock}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Planter Cost</label>
                  <input
                    type="number"
                    class="form-control"
                    name="planterCost"
                    placeholder="Enter Planter Cost"
                    required
                    value={planterCost}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="container text-center">
                  <button
                    id="addbtn"
                    type="submit"
                    class="btn my-2 text-center mr-2"
                  >
                    Add Planter
                  </button>
                  <br />
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default CreatePlanterComponent;
