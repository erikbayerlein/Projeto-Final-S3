import '../styles/BackHome.css'
import { Link } from 'react-router-dom'

export default function BackHome() {
  return (
    <Link to="/home">
      <img className='HomeImage' src="Home.svg" alt="Home image" />
    </Link>
  )
}