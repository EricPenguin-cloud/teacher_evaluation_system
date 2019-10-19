//TODO UerIForm注销功能
//TODO 超时自动退出登录功能

import React from 'react'
import ReactDOM from 'react-dom'
import UserInform from '../components/UserInform.jsx'

ReactDOM.render(
    <UserInform name={JSON.parse(localStorage.getItem('stu_inform')).name} role={1} />,
    document.getElementById('user_inform')
)