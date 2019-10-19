import React from 'react'
import ReactDOM from 'react-dom'

//登录表单组件
import LoginForm from './components/LoginForm.jsx'

//登录表单创建
ReactDOM.render(
    <LoginForm title='学生 登录' role='STUDENT' role_id='1' />,
    document.getElementById('header_top')
);