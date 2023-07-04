import '../styles/Forms.css'
import '../styles/Forms2.css'

import {Inputs} from '../components/Inputs'
import {Button} from '../components/Button'
import BackHome from '../components/BackHome'

export default function Register () {
  return (
    <>
      <BackHome />

      <div className="container">
        <div className="limiter">
          <div className="container-login100">
            <div className="wrap-login100">
              <form className="login100-form validate-form">
                <span className="login100-form-title p-b-26">
                  Cadastre-se
                </span>
                
                <Inputs name="Nome" isPassword={false}/>

                <Inputs name="CPF" isPassword={false}/>

                <Inputs name="E-mail" isPassword={false}/>

                <Inputs name="Senha" isPassword={true}/>

                <Inputs name="Confirme sua senha" isPassword={true}/>

                <Button>Cadastrar</Button>
                
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}