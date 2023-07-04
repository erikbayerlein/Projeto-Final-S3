import { BrowserRouter } from "react-router-dom"
import {AppRoutes} from '../src/Routes/Index.tsx'

function App() {

  return (
    <BrowserRouter>
      <AppRoutes />
    </BrowserRouter>
  )
}

export default App
