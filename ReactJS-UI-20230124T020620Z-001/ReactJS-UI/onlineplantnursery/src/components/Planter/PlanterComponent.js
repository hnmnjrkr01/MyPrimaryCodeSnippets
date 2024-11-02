import React, { Component } from "react";
import { Link } from "react-router-dom";
import PlanterServices from "./PlanterServices";
import axios from "axios";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

class PlanterComponent extends Component {
  // Step 1:
  constructor(props) {
    super(props);
    this.state = {
      planter: [],
    };
  }
  //Step 2:
  componentDidMount() {
    PlanterServices.getAllPlanters().then((Response) => {
      this.setState({ planter: Response.data });
    });
  }
  deletePlanter = (id) => {
    axios.delete(`http://localhost:9092/planter/deletePlanter/id/${id}`).then(
      (response) => {
        alert("Record Deleted Successfully");
        this.setState({
          planter: this.state.planter.filter(
            (planter) => planter.planterId !== id
          ),
        });
      },
      (error) => {
        alert("Operation Failed Here");
      }
    );
  };
  render() {
    return (
      <div>
        <Navbar/>
        <div className="container">
          <div className="addbutton">
            <button id="addbtn" className="btn" type="button">
              <Link id="addbtn" to={"/Planter"}>
                Create Planter
              </Link>
            </button>
          </div>
          {this.state.planter.length === 0
            ? "No Record "
            : this.state.planter.map((planter, index) => (
                <div
                  className="card"
                  style={{ margin: "2rem" }}
                  key={planter.id}
                >
                  <div className="jumbotron">
                    <div className="card-body" style={{ color: "white" }}>
                      <h5 className="card-title">{index + 1}</h5>
                      <h5 className="card-title">
                        Planter Color &nbsp; :&nbsp;{planter.planterColor}
                      </h5>
                      <h5 className="card-text">
                        Planter Shape &nbsp; :&nbsp;{planter.planterShape}
                      </h5>
                      <h5 className="card-text">
                        Planter Stock &nbsp; :&nbsp;{planter.planterStock}
                      </h5>
                      <h5 className="card-text">
                        Plant Cost &nbsp; :&nbsp;{planter.planterCost}
                      </h5>
                      <div className="d-grid gap-2">
                        <button id="addbtn" className="btn" type="button">
                          <Link
                            id="addbtn"
                            to={`/update-planter/${planter.planterId}`}
                          >
                            Update
                          </Link>{" "}
                        </button>
                        <button
                          id="addbtn"
                          className="btn"
                          onClick={() => {
                            this.deletePlanter(planter.planterId);
                          }}
                        >
                          Delete
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              ))}
        </div>
      </div>
    );
  }
}

export default PlanterComponent;
