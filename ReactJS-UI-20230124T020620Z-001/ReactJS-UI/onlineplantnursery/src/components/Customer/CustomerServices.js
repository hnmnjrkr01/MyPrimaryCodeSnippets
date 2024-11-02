import React, { Component } from 'react'
import axios from 'axios'
import "../CssStyle/Styles.css";

class CustomerServices {
    
    viewAllCustomers(){
        return axios.get(`http://localhost:9092/customers/viewAllCustomers`);
    }
    
    viewCustomer = (id)=>{
        return axios.get(`http://localhost:9092/customers/viewCustomer/${id}`)
    }
}
export default new CustomerServices