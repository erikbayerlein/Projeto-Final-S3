import { Routes, Route, Navigate } from 'react-router-dom'
import Home from '../pages/Home.tsx'
import Login from '../pages/Login.tsx'
import Register from '../pages/Register.tsx'

export const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/home" element={<Home/>}/>
      <Route path="/login" element={<Login/>}/>
      <Route path="/register" element={<Register/>}/>

      <Route path='*' element={<Navigate to="/home"/>}/>
    </Routes>
  );
}