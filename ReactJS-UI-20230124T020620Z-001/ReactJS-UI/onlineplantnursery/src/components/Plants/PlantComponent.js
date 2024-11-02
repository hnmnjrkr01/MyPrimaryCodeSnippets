import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import PlantServices from './PlantServices';
import axios from 'axios';
import "../CssStyle/Styles.css";
import Navbar from '../Navbar/navbar';


class PlantComponent extends Component {
    // Step 1:
    constructor(props) {
        super(props);
        this.state = {
            plant: []
        };
    }
    //Step 2:
    componentDidMount() {
        PlantServices.viewAllPlant().then((Response) => {
            this.setState({ plant: Response.data })
        });

    }
    deletePlant = (id) => {
        axios.delete(`http://localhost:9092/plantsModule/deletePlant/${id}`).then(
            (response) => {
                alert("Record Deleted Successfully");
                this.setState({
                    plant: this.state.plant.filter(plant => plant.plantId !== id)
                });
            }, (error) => {
                alert("Operation Failed Here");
            }
        );
    };
    render() {
        return (
            <div>
                 <Navbar/>
                <div className="container">
                    <div className='addbutton'>
                        <button id="addbtn" className="btn" type="button" ><Link id="addbtn" to={'/Plant'}>Create Plant</Link></button>
                    </div>
                    {this.state.plant.length === 0 ? "No Record " :
                        this.state.plant.map((plant, index) => (
                            <div className="card" style={{ margin: "2rem" }} key={plant.id}>
                                <div className='jumbotron'>
                                <div className="card-body" style={{color:"white"}} >
                                    <h5 className="card-title">{index + 1}</h5>
                                    <h5 className="card-title">Plant Name &nbsp; :&nbsp; {plant.name}</h5>
                                    <h5 className="card-text">Plant Description &nbsp; :&nbsp; {plant.plantDescription}</h5>
                                    <h5 className="card-text">Bloom Time &nbsp; :&nbsp; {plant.bloomTime}</h5>
                                    <h5 className="card-text">Plant Cost &nbsp; :&nbsp; {plant.plantCost}</h5>
                                    <div className="d-grid gap-2">
                                        <button id="addbtn" className='btn' type="button" ><Link id="addbtn" to={`/update-plant/${plant.plantId}`}>Update</Link> </button>
                                        <button id="addbtn" className="btn" onClick={() => { this.deletePlant(plant.plantId) }}>Delete</button>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        ))}
                </div>
             
            </div>
        )
    }
}

export default PlantComponent