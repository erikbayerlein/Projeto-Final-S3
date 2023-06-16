import { ReactNode } from 'react'
import '../styles/Button.css'

interface ButtonProps {
  children: ReactNode;
}

export const Button = ({children}: ButtonProps) =>{
  return (
    <>
      <div className="container-login100-form-btn">
        <div className="wrap-login100-form-btn">
          <div className="login100-form-bgbtn"></div>
          <button className="login100-form-btn">
            {children}
          </button>
        </div>
      </div>
    </>
  )
}