import '../styles/Input.css'
import { ReactNode, useState } from 'react'

interface InputProps {
  name: string;
  children?: ReactNode;
  isPassword: boolean;
}

export const Inputs = ({name, isPassword}: InputProps) => {

  const [showPass, setShowPass] = useState(false)

  const showPassword = () => {
    setShowPass(!showPass)
  }

  const [isEmpty, setIsEmpty] = useState(true)

  const hasVal = (e: React.FormEvent<HTMLInputElement>) => {
    const el = e.currentTarget.value;

    if (el == null || el == "") {
      setIsEmpty(true)
    } else {
      setIsEmpty(false)
    }    
  }

  return (
    <>
      <div 
        className="wrap-input100 validate-input" 
        data-validate="Enter password"
      >
      {
        isPassword
        ?
        <span>
          <span 
            className="btn-show-pass"
            onClick={showPassword}
          >
            <i className = {showPass ? 'zmdi zmdi-eye-off' : 'zmdi zmdi-eye'}></i>
          </span>
          <input 
            id={name}
            onChange={hasVal}
            className={isEmpty ? 'input100' : 'input100 has-val'} 
            type={showPass ? 'text' : 'password'} 
            name={name} 
          />
          <span 
            className="focus-input100" 
            data-placeholder={name}>
          </span>
        </span>
        :
        <span>
          <input 
            id={name}
            onChange={hasVal}
            className={isEmpty ? 'input100' : 'input100 has-val'} 
            type='text' 
            name={name} 
          />
          <span 
            className="focus-input100" 
            data-placeholder={name}>
          </span>
        </span>
      }
    </div>
    </>
  )
}