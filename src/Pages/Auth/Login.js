import React, { useState } from 'react';
import axios from 'axios';
import {baseURL ,loginurl} from '../../Api/api';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

export  default function Login ()
{
    const [loginfo,Setloginfo]= useState({
        username : "",
        password:""
       });
    
     function handelformChange(e)
         {
    Setloginfo ({
      ...loginfo ,[e.target.name]:e.target.value
         })
         }
         console.log(loginfo)

         async function handleSubmit(e){
          e.preventDefault();
          try{
              await axios.post(`${baseURL + loginurl}`,loginfo)
              console.log("login done")
              console.log(loginfo)

              }  
          catch(err)
          {
              console.log("err")
              console.log(loginfo)
          }
       }
     
      return (
        <Form  onSubmit={handleSubmit}
         className='container-sm'>
        <Form.Group className="mb-3" >
          <Form.Label>User Name </Form.Label>
          <Form.Control type="text" 

          placeholder="Enter email"
          name='username'
           value ={loginfo.username}
           onChange={handelformChange} />
        </Form.Group>
    
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" 
          placeholder="Password" 
          name='password'
           value ={loginfo.password}
           onChange={handelformChange}/>
        </Form.Group>
        
        <Button variant="primary" type="submit">
         Login
        </Button>
      </Form>
      )
}