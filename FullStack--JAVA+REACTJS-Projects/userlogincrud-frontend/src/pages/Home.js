import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';



export default function Home() {

    const[users, setUsers]=useState([]);

    const{userId} = useParams();

    useEffect(()=>{
        console.log("User Login Project");
        loadUsers();
    },[]);

    const loadUsers=async()=>{
        const result = await axios.get("http://localhost:8080/UserCRUDLogin/showAllUsers");
        console.log(result.data);
        setUsers(result.data);
    }

    const deleteUser = async(userId)=>{
      await axios.delete(`http://localhost:8080/UserCRUDLogin/removerUser/${userId}`);
      loadUsers();
    }



  return (
    <div className='container'>
        <div className='py-4'>

        <table className="table border shadow">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">UserName</th>
      <th scope="col">E-mail</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    {
        users.map((user, index)=>(
            <tr>
                <th scope="row" key={index}>{index+1}</th>
                <td>{user.name}</td>
                <td>{user.username}</td>
                <td>{user.email}</td>
                <td>
                <Link className='btn btn-primary mx-2' to={`/showUser/${user.userId}`}>View</Link>
                <Link className='btn btn-outline-primary mx-2' to={`/updateUser/${user.userId}`}>Edit</Link>
                <button className='btn btn-danger mx-2'  onClick={()=>deleteUser(user.userId)}>Delete</button>
                </td>
        </tr>
        ))

    }

  </tbody>
</table>
        </div>

    </div>
  )
}
