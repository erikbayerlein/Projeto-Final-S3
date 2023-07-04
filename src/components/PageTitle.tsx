import { ReactNode } from 'react';
import '../styles/PageTitle.css'

interface PageTitleProps {
  children: ReactNode;
}

export const PageTitle = ({children}: PageTitleProps) =>{
  return (
    <>
      <div className="texto">{children}</div>
    </>
  )
}