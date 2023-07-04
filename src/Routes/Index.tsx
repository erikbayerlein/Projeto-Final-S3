import { Routes, Route, Navigate } from 'react-router-dom'
import Home from '../pages/Home.tsx'
import Login from '../pages/Login.tsx'
import Register from '../pages/Register.tsx'
import Cardapio from '../pages/Cardapio.tsx'
import Promotion from '../pages/Promotion.tsx'

export const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/home" element={<Home/>}/>
      <Route path="/login" element={<Login/>}/>
      <Route path="/register" element={<Register/>}/>
      <Route path="/cardapio" element={<Cardapio/>}/>
      <Route path="/promotion" element={<Promotion/>}/>

      <Route path='*' element={<Navigate to="/home"/>}/>
    </Routes>
  );
}