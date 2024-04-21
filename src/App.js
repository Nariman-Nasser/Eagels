

import React, { useState } from 'react';

import Homepage from './Pages/website/Homepage';
import { Route, Router, Routes } from 'react-router-dom';
import Login from './Pages/Auth/Login';
import Register from './Pages/Auth/Register';
import './CSS/base/componets/form.css'
import './CSS/base/media.css'
function App() {
    return(
 <div>
    <Routes>
    <Route path='/Homepage' element ={<Homepage/>}></Route>
    <Route path='/Login' element={<Login/>}></Route>
    <Route path='/Register' element={<Register/>}></Route>
    </Routes>
 
 </div>
    )
}

export default App;