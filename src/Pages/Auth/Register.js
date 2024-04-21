import axios from 'axios';
import React, { useState } from 'react';

import Form from 'react-bootstrap/Form';
import { baseURL ,registerurl} from '../../Api/api';

export  default function Register(){
    const [Signupinfo,SetSignupinfo]= useState({
        email:"",
        fullName:"",
        username :"",
        password:"",
        role:""
       });
    const [messageinfo, setmessage]=useState("")
     function handelformChange(e)
         {
        SetSignupinfo({
      ...Signupinfo ,[e.target.name]:e.target.value
         })
         }
        
        

        async function handleSubmit(e){
            e.preventDefault();
            try{
              const response = await axios.post(`${baseURL + registerurl}`,Signupinfo)
              console.log(response.data.message)
              setmessage(response.data.message)
            }
            catch(err)
            {
              
              setmessage("Server Error")
            }
         }
     
      return (
      <div  className="container">

      <div className='row h-100'>
        <form  className="form "onSubmit={handleSubmit}>
    <div className='coustomform'>

          <div className='form-control'> 
          <input
          type="text" 
          placeholder="EnterFullname"
          name='fullName'
          required
           value ={Signupinfo.fullName}
           onChange={handelformChange} />
           <label>Fullname</label>
          </div>

          <div  className='form-control'>
          <input type="email" 
          placeholder="Enter email"
          name='email'
          required
           value ={Signupinfo.email}
           onChange={handelformChange} />
           <label>Email</label>
         </div>

         <div className='form-control'>
          <input type="Text" 
          placeholder="Enter UserName "
          name='username'
          minLength={4}
          required
           value ={Signupinfo.username}
           onChange={handelformChange} />
             <label>Username</label>
          </div>
    
        <div className='form-control'>
          <input type="password" 
          placeholder="Password" 
          name='password'
          required
           value ={SetSignupinfo.password}
           onChange={handelformChange}/>
           <label>Password</label>
        </div>

        <div className='jobtittel'>
            <h3>Job Tittel</h3>
            <div>
                <Form.Check
                    inline
                    label="Admin"
                    type="radio"
                    value="ADMIN"
                   name='role'
                   required
                   checked={SetSignupinfo.role}
                    onChange={handelformChange}
                />
                <Form.Check
                    inline
                    label="Operrator"
                    type="radio"
                    value="OPERATOR"
                    name='role'
                    required
                    checked={SetSignupinfo.role }
                    onChange={handelformChange}
                />
                <Form.Check
                    inline
                    label="Seller"
                    type="radio"
                    name='role'
                    value="Seller"
                    required
                    checked={SetSignupinfo.role }
                    onChange={handelformChange}
                />
            </div>
            </div>
        
        <button className='submitbutton' type="submit">
          Signup
        </button>
        <div>
        {messageinfo !=="" && <span className="massege" >{messageinfo}</span>} 
        </div>
</div>
      </form>
      </div>
      </div>

      )
}