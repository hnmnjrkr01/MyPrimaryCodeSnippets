import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

function UpdatePlanter() {
  const { id } = useParams(); // getting url id
  const URL = "http://localhost:9092/planter/updatePlanter";
  const navigate = useNavigate();

  useEffect(() => {
    getPlanterById();
  }, []);
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
  const onInputChange = (e) => {
    setPlanter({ ...planter, [e.target.name]: e.target.value });
  };

  const FormHandle = (e) => {
    e.preventDefault();
    updateDataToServer(planter);
  };
  const updateDataToServer = (data) => {
    axios.put(URL, data).then(
      (response) => {
        alert("Planter Updated Successfully");
        navigate("/PlanterComponent");
      },
      (error) => {
        alert("Operation failed");
      }
    );
  };

  const getPlanterById = async (e) => {
    const planterInfo = await axios.get(URL);
    setPlanter(planterInfo.data);
  };

  return (
    <div>
      <Navbar/>
      <div className="container">
        <div className="w-75 mx-auto shadow p-5 mt-2 bg-light">
          <div className="jumbotron">
            <h1 className="display-4 text-center">Update Planters!</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
                <div className="form-group">
                  <label for="exampleInputEmail1">Planter ID</label>
                  <input
                    type="number"
                    className="form-control"
                    name="planterId"
                    placeholder="Enter Planter Id"
                    required
                    value={planterId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputEmail1">Planter Height</label>
                  <input
                    type="number"
                    className="form-control"
                    name="planterheight"
                    placeholder="Enter Planter Height"
                    required
                    value={planterheight}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Planter Capacity</label>
                  <input
                    type="number"
                    className="form-control"
                    name="planterCapacity"
                    placeholder="Enter Planter Capacity"
                    required
                    value={planterCapacity}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Drainage Holes</label>
                  <input
                    type="text"
                    className="form-control"
                    name="drainageHoles"
                    placeholder="Enter Drainage Holes"
                    required
                    value={drainageHoles}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Planter Color</label>
                  <input
                    type="text"
                    className="form-control"
                    name="planterColor"
                    placeholder="Enter Planter Color"
                    required
                    value={planterColor}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Planter Shape</label>
                  <input
                    type="text"
                    className="form-control"
                    name="planterShape"
                    placeholder="Enter Planter Shape"
                    required
                    value={planterShape}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="form-group">
                  <label for="exampleInputPassword1">Planter Stock </label>
                  <input
                    type="text"
                    className="form-control"
                    name="planterStock"
                    placeholder="Enter Planter Stock"
                    required
                    value={planterStock}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Planter Cost</label>
                  <input
                    type="text"
                    className="form-control"
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
                    className="btn my-2 text-center mr-2"
                  >
                    Update Planter
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default UpdatePlanter;
