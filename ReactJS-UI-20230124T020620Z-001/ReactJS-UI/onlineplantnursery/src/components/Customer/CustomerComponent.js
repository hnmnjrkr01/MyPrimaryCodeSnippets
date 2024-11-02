import React, { Component } from "react";
import { Link } from "react-router-dom";
import CustomerServices from "./CustomerServices";
import axios from "axios";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

class CustomerComponent extends Component {
  // Step 1:
  constructor(props) {
    super(props);
    this.state = {
      customer: [],
    };
  }
  //Step 2:
  componentDidMount() {
    CustomerServices.viewAllCustomers().then((Response) => {
      this.setState({ customer: Response.data });
    });
  }
  deleteCustomer = (id) => {
    axios
      .delete(`http://localhost:9092/customers/deleteCustomer/id/${id}`)
      .then(
        (response) => {
          alert("Record Deleted Successfully");
          this.setState({
            customer: this.state.customer.filter(
              (customer) => customer.customerId !== id
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
              <Link id="addbtn" to={"/Customer"}>
                Create Customer
              </Link>
            </button>
          </div>
          {this.state.customer.length === 0
            ? "No Record "
            : this.state.customer.map((customer, index) => (
                <div className="card " key={customer.id}>
                  <div class="jumbotron">
                    <div className="card-body" style={{ color: "white" }}>
                      <h5 className="card-title">{index + 1}</h5>
                      <h5 className="card-title">
                        Name &nbsp; :&nbsp; {customer.customerName}
                      </h5>
                      <h5 className="card-text">
                        Email &nbsp; : &nbsp; {customer.customerEmail}
                      </h5>
                      <h5 className="card-text">
                        Username &nbsp; : &nbsp;{customer.username}
                      </h5>
                      <div className="d-grid gap-2">
                        <button id="addbtn" className="btn" type="button">
                          <Link
                            id="addbtn"
                            to={`/update-customer/${customer.customerId}`}
                          >
                            Update
                          </Link>{" "}
                        </button>
                        <button
                          id="addbtn"
                          className="btn"
                          onClick={() => {
                            this.deleteCustomer(customer.customerId);
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

export default CustomerComponent;
