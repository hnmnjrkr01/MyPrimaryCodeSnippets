import React, { Component } from 'react'
import { Link, Outlet } from 'react-router-dom';
import SeedServices from './SeedServices';
import axios from 'axios';
import "../CssStyle/Styles.css";
import Navbar from '../Navbar/navbar';

class SeedComponent extends Component {
    // Step 1:
    constructor(props) {
        super(props);
        this.state = {
            seed: []
        };
    }
    //Step 2:
    componentDidMount() {
        SeedServices.getAllSeeds().then((Response) => {
            this.setState({ seed: Response.data })
        });

    }
    deleteSeed = (id) => {
        axios.delete(`http://localhost:9092/seeds/deleteseeds/${id}`).then(
            (response) => {
                alert("Record Deleted Successfully");
                this.setState({
                    seed: this.state.seed.filter(seed => seed.seedId !== id)
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
                        <button id="addbtn" className="btn" type="button" ><Link id="addbtn" to={'/Seed'}>Create Seed</Link></button>
                    </div>
                    {this.state.seed.length === 0 ? "No Record " :
                    this.state.seed.map((seed,index) =>(
                    <div className="card" style={{ margin: "2rem" }} key={seed.id}>
                        <div className='jumbotron'>
                        <div className="card-body" style={{color:"white"}}>
                        <h5 className="card-title">{index+1}</h5>
                            <h5 className="card-title">Seed Name &nbsp; :&nbsp;{seed.commanName}</h5>
                            <h5 className="card-text">Description &nbsp; :&nbsp;{seed.seedsDescription}</h5>
                            <h5 className="card-text">Bloom Time &nbsp; :&nbsp;{seed.bloomTime}</h5>
                            <h5 className="card-text">Seed Cost &nbsp; :&nbsp;{seed.seedsCost}</h5>
                            <div className="d-grid gap-2">
                                <button id="addbtn" className="btn" type="button" ><Link id="addbtn" to={`/update-seed/${seed.seedId}`}>Update</Link> </button>
                                <button id="addbtn" className="btn" onClick={()=>{this.deleteSeed(seed.seedId)}}>Delete</button>
                            </div>
                            </div>
                        </div>
                    </div>
                    ))}
                </div>
                <Outlet/>
            </div>
        )
    }
}

export default SeedComponent