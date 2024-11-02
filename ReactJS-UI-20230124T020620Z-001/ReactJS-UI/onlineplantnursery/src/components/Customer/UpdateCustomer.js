import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useNavigate } from "react-router-dom";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

function UpdateCustomer() {
  const { id } = useParams();
  const URL = `http://localhost:9092/customers/updateCustomer/id/${id}`;
  const navigate = useNavigate();

  useEffect(() => {
    getCustomerById();
  }, []);
  const [customer, setCustomer] = useState({
    customerId: "",
    customerName: "",
    customerEmail: "",
    username: "",
    password: "",
  });

  const { customerId, customerName, customerEmail, username, password } =
    customer;
  const onInputChange = (e) => {
    setCustomer({ ...customer, [e.target.name]: e.target.value });
  };

  const FormHandle = (e) => {
    e.preventDefault();
    updateDataToServer(customer);
  };
  const updateDataToServer = (data) => {
    axios.put(URL, data).then(
      (response) => {
        alert("Customer Updated Successfully");
        navigate("/CustomerComponent");
      },
      (error) => {
        alert("Operation failed");
      }
    );
  };

  const getCustomerById = async (e) => {
    const customerInfo = await axios.get(URL);
    setCustomer(customerInfo.data);
  };

  return (
    <div>
      <Navbar/>
      <div className="container">
        <div className="w-75 mx-auto shadow p-5 mt-2 bg-light">
          <div className="jumbotron">
            <h1 className="display-4 text-center">Update Customer</h1>
            <div>
              <form onSubmit={(e) => FormHandle(e)}>
                <div className="form-group">
                  <label>Customer Id</label>
                  <input
                    type="text"
                    className="form-control"
                    name="customerId"
                    placeholder="Enter Customer Id"
                    required
                    value={customerId}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label>Customer Name</label>
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
                  <label>Customer Email</label>
                  <input
                    type="email"
                    className="form-control"
                    name="customerEmail"
                    placeholder="Enter CustomerEmail"
                    required
                    value={customerEmail}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label>Customer Username</label>
                  <input
                    type="text"
                    className="form-control"
                    name="username"
                    placeholder="Enter Customer Usernmae"
                    required
                    value={username}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>
                <div className="form-group">
                  <label>Password </label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    placeholder="Enter Password"
                    required
                    value={password}
                    onChange={(e) => onInputChange(e)}
                  />
                </div>

                <div className="container text-center">
                  <button
                    id="addbtn"
                    type="submit"
                    className="btn my-2 text-center mr-2"
                  >
                    Update Customer
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
export default UpdateCustomer;
