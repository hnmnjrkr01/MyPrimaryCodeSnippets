import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams,useNavigate } from "react-router-dom";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

function UpdateSeed() {
  const { id } = useParams(); // getting url id
  const URL = `http://localhost:9092/seeds/updateseeds/${id}`;
  const navigate=useNavigate();

  useEffect(() => {
    getSeedById();
  }, []);
  const [seed, setSeed] = useState({
    seedId:"",
    commanName: "",
    bloomTime: "",
    watering:"",
    difficultyLevel: "",
    temprature: "",
    typeOfSeed: "",
    seedsDescription: "",
    seedsStock: "",
    seedsCost: "",
    seedsPerPacket:"",
  });

  const {  
    seedId,
    commanName,
    bloomTime,
    watering,
    difficultyLevel,
    temprature,
    typeOfSeed,
    seedsDescription,
    seedsStock,
    seedsCost,
    seedsPerPacket,} = seed;
  const onInputChange = (e) => {
    setSeed({ ...seed, [e.target.name]: e.target.value });
  };

  const FormHandle = (e) => {
    e.preventDefault();
    updateDataToServer(seed);
  };
  const updateDataToServer = (data) => {
    axios.put(URL, data).then(
      (response) => {
        alert("Seed Updated Successfully");
        navigate("/SeedComponent");
      },
      (error) => {
        alert("Operation failed");
      }
    );
  };

  const getSeedById = async (e) => {
    const seedInfo = await axios.get(URL);
    setSeed(seedInfo.data);
  };

  return (
    <div>
      <Navbar/>
      <div className="container">
        <div className="w-75 mx-auto shadow p-5 mt-2 bg-light">
          <div className="jumbotron">
            <h1 className="display-4 text-center">Update Seeds!</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
              <div className="form-group">
                  <label for="exampleInputEmail1">Seed Id</label>
                  <input
                    type="number"
                    className="form-control"
                    name="seedId"
                    placeholder="Enter Seed Id"
                    required
                    value={seedId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
              <div className="form-group">
                  <label for="exampleInputEmail1">Seed Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="commanName"
                    placeholder="Enter Seed Name"
                    required
                    value={commanName}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                
                <div className="form-group">
                  <label for="exampleInputPassword1">Bloom Time</label>
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
                  <label for="exampleInputPassword1">Watering</label>
                  <input
                    type="text"
                    className="form-control"
                    name="watering"
                    placeholder="Enter Watering Need"
                    required
                    value={watering}
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
                    name="temprature"
                    placeholder="Enter Temperature"
                    required
                    value={temprature}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Type of Seed</label>
                  <input
                    type="text"
                    className="form-control"
                    name="typeOfSeed"
                    placeholder="Enter Type of Seed"
                    required
                    value={typeOfSeed}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Seed Description</label>
                  <input
                    type="text"
                    className="form-control"
                    name="seedsDescription"
                    placeholder="Enter Description"
                    required
                    value={seedsDescription}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Seeds Stock </label>
                  <input
                    type="text"
                    className="form-control"
                    name="seedsStock"
                    placeholder="Enter Seed Stock"
                    required
                    value={seedsStock}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Seed Cost</label>
                  <input
                    type="text"
                    className="form-control"
                    name="seedsCost"
                    placeholder="Enter Seed Cost"
                    required
                    value={seedsCost}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Seeds Per Packet</label>
                  <input
                    type="text"
                    className="form-control"
                    name="seedsPerPacket"
                    placeholder="Enter Seeds Per Packet"
                    required
                    value={seedsPerPacket}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="container text-center">
                  <button id="addbtn"
                    type="submit"
                    className="btn  text-center mr-2"
                  >
                    Update Seed
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
export default UpdateSeed;
