import * as React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { color, Container } from '@mui/system';
import { Paper, Button } from '@mui/material';

export default function Student() {

    const paperStyle={padding:'50px 20px',width:600,margin:'20px auto'}

    const[name, setName]= useState('');
    const[address, setAddress]=useState('');
    const[students, setStudents]= useState([]);

    const handleClick=(e)=>{
        e.preventDefault();
        const student = {name, address}
        console.log(student)

        fetch("http://localhost:8080/Student-Managment/addStudent",{
          method:"POST",
          headers:{"Content-type":"application/json"},
          body:JSON.stringify(student)
        }).then(()=>{
          console.log("New Student Added!")
        })
    }

    useEffect(()=>{
      fetch("http://localhost:8080/Student-Managment/showAllStudents")
      .then(rs=>rs.json())
      .then((result)=>{
        setStudents(result);
      })
    },[])


  return (
    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
      <Container>
        <Paper elevation={3} style={paperStyle}>
            <h1 style={{color:'blue'}}><u>Add Student</u></h1>

        <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
        value={name}
        onChange={(e)=>setName(e.target.value)}
        /><br/><br/>
        <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth
        value={address}
        onChange = {(e)=>setAddress(e.target.value)}
        />
        <br/>
        <Button onClick={handleClick}>Submit</Button>
        </Paper>

        <Paper>
        <h1>STUDENT</h1>

        {students.map(student=>(
          <Paper elevation={6} style={{margin:'10px' , padding:'15px', textAlign:"center"}} key={student.id}>
          ID : {student.id}<br/>
          Name : {student.name}<br/>
          Address : {student.address}<br/>
        </Paper>
        ))
        }
        </Paper>

      </Container>  

    </Box>
  );
}
