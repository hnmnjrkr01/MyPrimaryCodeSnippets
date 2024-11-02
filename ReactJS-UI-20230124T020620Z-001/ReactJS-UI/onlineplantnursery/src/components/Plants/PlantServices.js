import React, { Component } from 'react'
import axios from 'axios'

class PlantServices {
    
    viewAllPlant(){
        return axios.get(`http://localhost:9092/plantsModule/getAllPlants`);
    }
}
export default new PlantServices