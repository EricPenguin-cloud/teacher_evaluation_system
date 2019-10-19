import React from 'react'
import ReactDOM from 'react-dom'
import UserInform from '../components/UserInform.jsx'

ReactDOM.render(
    <UserInform name={JSON.parse(localStorage.getItem('tea_inform')).name} role={2}/>,
    document.getElementById('user_inform')
)