import '../styles/Forms.css'
import '../styles/Forms2.css'
import {Inputs} from '../components/Inputs'
import {Button} from '../components/Button'
import {Link} from 'react-router-dom'
import BackHome from '../components/BackHome'

export default function Login() {
  return (
    <>
      <BackHome />

      <div className="container">
        <div className="limiter">
          <div className="container-login100">
            <div className="wrap-login100">
              <form className="login100-form validate-form">
                <span className="login100-form-title p-b-26">
                  Faça seu login
                </span>
                
                <Inputs name="CPF" isPassword={false}/>

                <Inputs name="Senha" isPassword={true}/>

                <Button>Acessar</Button>
                

                <div className="text-center p-t-50">
                  <span className="txt1">
                    Ainda não tem conta? &nbsp;
                  </span>

                  <Link className="txt2" to="/register">
                    Crie a sua
                  </Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}