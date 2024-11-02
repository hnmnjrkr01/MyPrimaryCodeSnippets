import React, { Component } from "react";
import axios from "axios";

class PlanterServices {
  getAllPlanters() {
    return axios.get(`http://localhost:9092/planter/getAllPlanters`);
  }

  getPlanterById = (id) => {
    return axios.get(`http://localhost:9092/planter/getPlanter/id/${id}`);
  };
}
export default new PlanterServices();
