import React, { useState } from "react";
import axios from "axios";
import {useNavigate } from "react-router-dom";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

function CreateCustomerComponent() {
  const navigate = useNavigate();
  const [customer, setCustomer] = useState({
    customerId: "",
    customerName: "",
    customerEmail: "",
    username: "",
    password: "",
  });
  const onInputChange = (e) => {
    setCustomer({ ...customer, [e.target.name]: e.target.value });
  };
  const { customerId, customerName, customerEmail, username, password } =
    customer;

  const FormHandle = (e) => {
    e.preventDefault();
    addDataToServer(customer);
  };
  const addDataToServer = (data) => {
    axios.post("http://localhost:9092/customers/addCustomer", data).then(
      (response) => {
        console.log(response);
        alert("Customer Added Successfully");
        navigate("/CustomerComponent");
      },
      (error) => {
        console.log(error);
        alert("Operation failed");
      }
    );
  };
  return (
    <div data-testid="create-1">
       <Navbar/>
      <div className="container" >
        <div className="w-75 mx-auto shadow p-5 mt-2 bg-light">
          <div className="jumbotron">
            <h1 className="display-4 text-center">Add Customer!</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
                <div className="form-group">
                  <label for="exampleInputEmail1">Customer Id</label>
                  <input
                    type="number"
                    className="form-control"
                    name="customerId"
                    placeholder="Enter Customer Id"
                    required
                    value={customerId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputEmail1">Customer Name</label>
                  <input
                    type="text"
                    className="form-control"
                    name="customerName"
                    placeholder="Enter Customer Name"
                    required
                    value={customerName}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Customer Email</label>
                  <input
                    type="email"
                    className="form-control"
                    name="customerEmail"
                    placeholder="Enter Customer Email"
                    required
                    value={customerEmail}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Customer Username</label>
                  <input
                    type="text"
                    className="form-control"
                    name="username"
                    placeholder="Enter Customer Username"
                    required
                    value={username}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label for="exampleInputPassword1">Customer Password</label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    placeholder="Enter Customer Password"
                    required
                    value={password}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="container text-center">
                  <button
                    id="addbtn"
                    type="submit"
                    className="btn text-center mr-2"
                  >
                    Add Customer
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
export default CreateCustomerComponent;
