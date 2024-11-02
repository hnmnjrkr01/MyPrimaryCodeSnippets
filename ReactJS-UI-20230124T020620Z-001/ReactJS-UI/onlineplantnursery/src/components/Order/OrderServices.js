import React, { Component } from 'react'
import axios from 'axios'

class OrderServices {
    
    viewAllOrders(){
        return axios.get(`http://localhost:9092/Orders/getAllOrders`);
    }
}
export default new OrderServices