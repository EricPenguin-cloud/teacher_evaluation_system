import React from 'react'
import ReactDOM from 'react-dom'

//登录表单组件
import LoginForm from './components/LoginForm.jsx'

//登录表单创建
ReactDOM.render(
    <div class="unix-login">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <LoginForm title='管理员  登录' role='Work' role_id='0' />
                </div>
            </div>
        </div>
    </div>,
    document.getElementById('page_body')
);