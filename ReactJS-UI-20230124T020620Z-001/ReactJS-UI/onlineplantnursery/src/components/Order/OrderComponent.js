import React, { Component } from "react";
import { Link } from "react-router-dom";
import OrderServices from "./OrderServices";
import axios from "axios";
import "../CssStyle/Styles.css";
import Navbar from "../Navbar/navbar";

class OrderComponent extends Component {
  // Step 1:
  constructor(props) {
    super(props);
    this.state = {
      ordertable: [],
    };
  }
  //Step 2:
  componentDidMount() {
    OrderServices.viewAllOrders().then((Response) => {
      this.setState({ ordertable: Response.data });
    });
  }
  deleteOrder = (bookingId) => {
    axios
      .delete(`http://localhost:9092/Orders/deleteOrder/id/${bookingId}`)
      .then(
        (response) => {
          alert("Record Deleted Successfully");
          this.setState({
            ordertable: this.state.ordertable.filter(
              (ordertable) => ordertable.bookingOrderId !== bookingId
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
          {this.state.ordertable.length === 0
            ? "No Record "
            : this.state.ordertable.map((ordertable, index) => (
                <div
                  className="card"
                  style={{ margin: "2rem" }}
                  key={ordertable.id}
                >
                  <div className="jumbotron">
                    <div className="card-body" style={{ color: "white" }}>
                      <h5 className="card-title">{index + 1}</h5>
                      <h5 className="card-title">
                        Booking Id:&nbsp;{ordertable.bookingOrderId}
                      </h5>
                      <h5 className="card-text">
                        Order Date:&nbsp;{ordertable.orderDate}
                      </h5>
                      <h5 className="card-text">
                        Transaction Mode:&nbsp;{ordertable.transactionMode}
                      </h5>
                      <h5 className="card-text">
                        Quantity:&nbsp;{ordertable.quantity}
                      </h5>
                      <h5 className="card-text">
                        Price:&nbsp;{ordertable.price}
                      </h5>
                      <div className="d-grid gap-2">
                        <button
                          id="addbtn"
                          className="btn"
                          onClick={() => {
                            this.deleteOrder(ordertable.bookingOrderId);
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

export default OrderComponent;
