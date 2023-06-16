import '../styles/NavBar.css'
import { Link } from 'react-router-dom'

export default function NavBar() {
  return (
    <>
      <div className="container-navbar">
        <div className="left-side">
          <img src="Logo.svg" alt="Logo image" />

          <Link className="navbarCategories hover-underline-animation" to="/">Cardápio</Link>
          <Link className="navbarCategories hover-underline-animation" to="/">Promoções</Link>

        </div>
        <div className="right-side">
          <Link className="navbarCategories user" to="/login">
            <img src="User.svg" alt="User image" />
            <p className='text hover-underline-animation'>FAZER LOGIN<br/>ou CADASTRAR-SE</p>
          </Link>
          <Link to="/">
            <img src="Cart.svg" alt="Cart image" />
          </Link>
        </div>
      </div>
    </>
  )
}