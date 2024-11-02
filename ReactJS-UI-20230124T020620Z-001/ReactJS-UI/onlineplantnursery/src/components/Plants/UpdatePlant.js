import React, { useState, useEffect } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

function UpdatePlant() {
  const { id } = useParams(); // getting url id
  const URL = `http://localhost:9092/plantsModule/UpdatePlant/${id}`;
  const navigate=useNavigate();

  useEffect(() => {
    getPlantById();
  }, []);
  const [plant, setPlant] = useState({
    plantId:"",
    plantHeight: "",
    plantSpread: "",
    name: "",
    bloomTime: "",
    medicinalOrCulinaryUse: "",
    difficultyLevel: "",
    temparature: "",
    typeOfPlant: "",
    plantDescription: "",
    plantsStock: "",
    plantCost: "",
  });

  const {
    plantId,
    plantHeight,
    plantSpread,
    name,
    bloomTime,
    medicinalOrCulinaryUse,
    difficultyLevel,
    temparature,
    typeOfPlant,
    plantDescription,
    plantsStock,
    plantCost, } = plant;
  const onInputChange = (e) => {
    setPlant({ ...plant, [e.target.name]: e.target.value });
  };

  const FormHandle = (e) => {
    e.preventDefault();
    updateDataToServer(plant);

  };
  const updateDataToServer = (data) => {
    axios.put(URL, data).then(
      (response) => {
        alert("Plant Updated Successfully");
        navigate("/PlantComponent");
      },
      (error) => {
        alert("Operation failed");
      }
    );
  };

  const getPlantById = async (e) => {
    const plantInfo = await axios.get(URL);
    setPlant(plantInfo.data);
  };

  return (
    <div>
       <Navbar/>
      <div className="container">
        <div className="w-75 mx-auto shadow p-5 mt-2 bg-light">
          <div className="jumbotron">
            <h1 className="display-4 text-center">Update Plants!</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
              <div className="form-group">
                  <label for="exampleInputEmail1">Plant Id</label>
                  <input
                    type="text"
                    className="form-control"
                    name="plantId"
                    placeholder="Enter Plant Id"
                    required
                    value={plantId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
              <div className="form-group">
                  <label for="exampleInputEmail1">Plant Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="name"
                    placeholder="Enter Plant Name"
                    required
                    value={name}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Plant Height</label>
                  <input
                    type="text"
                    className="form-control"
                    name="plantHeight"
                    placeholder="Enter Plant Height"
                    required
                    value={plantHeight}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Plant Spread</label>
                  <input
                    type="text"
                    className="form-control"
                    name="plantSpread"
                    placeholder="Enter Plant Spread"
                    required
                    value={plantSpread}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Plant Bloom Time</label>
                  <input
                    type="text"
                    className="form-control"
                    name="bloomTime"
                    placeholder="Enter Bloom Time"
                    required
                    value={bloomTime}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Medicinal or Culinary Use </label>
                  <input
                    type="text"
                    className="form-control"
                    name="medicinalOrCulinaryUse"
                    placeholder="Enter Medicinal Use"
                    required
                    value={medicinalOrCulinaryUse}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Difficulty Level </label>
                  <input
                    type="text"
                    className="form-control"
                    name="difficultyLevel"
                    placeholder="Enter Difficulty Level"
                    required
                    value={difficultyLevel}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Temperature</label>
                  <input
                    type="text"
                    className="form-control"
                    name="temparature"
                    placeholder="Enter Temperature"
                    required
                    value={temparature}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Type of Plant</label>
                  <input
                    type="text"
                    className="form-control"
                    name="typeOfPlant"
                    placeholder="Enter Type Of Plant"
                    required
                    value={typeOfPlant}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Plant Description</label>
                  <input
                    type="text"
                    className="form-control"
                    name="plantDescription"
                    placeholder="Enter Plant Description"
                    required
                    value={plantDescription}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Plants Stock </label>
                  <input
                    type="text"
                    className="form-control"
                    name="plantsStock"
                    placeholder="Enter Plant Stock"
                    required
                    value={plantsStock}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Plant Cost</label>
                  <input
                    type="text"
                    className="form-control"
                    name="plantCost"
                    placeholder="Enter Plant Cost"
                    required
                    value={plantCost}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="container text-center">
                  <button id="addbtn"
                    type="submit"
                    className="btn my-2 text-center mr-2"
                  >
                    Update Plant
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
export default UpdatePlant;
