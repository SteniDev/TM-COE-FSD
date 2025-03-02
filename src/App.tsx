import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import GameCard from './Component/GameCard'
import GameList from './Component/GameList'

function App() {
  const [count, setCount] = useState(0)

  return (
     <>
    
      <GameList />
     
     
     </>
  )
}

export default App
