import React, { Component } from 'react'
import axios from 'axios'

class SeedServices {
    
    getAllSeeds(){
        return axios.get('http://localhost:9092/seeds/getSeeds');
    }
    
}
export default new SeedServices