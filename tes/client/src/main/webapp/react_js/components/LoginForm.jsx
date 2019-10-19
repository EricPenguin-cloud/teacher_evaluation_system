import React from 'react';

import {admin}from '../api/user_api.jsx';
import {student}from '../api/user_api.jsx';
import {teacher}from '../api/user_api.jsx';

//登录表单组件

class LoginForm extends React.Component{
    constructor(props){
        super(props);
        // 绑定
        this.login_submit = this.login_submit.bind(this);
    }
    componentWillMount(){
        if(this.props.role_id==0){      //管理员登录
            
            admin.loginConfirm();

        }else if(this.props.role_id==1){ //学生登录
            
            student.loginConfirm();

        }else if(this.props.role_id==2){ //教师登录
            
            teacher.loginConfirm();
        }
    }
    //登录提交方法
    async login_submit(){
        let param = {
            username : document.getElementById("username").value,
            password : document.getElementById("password").value
        }

        if(this.props.role_id==0){      //管理员登录
            
            admin.login(param);

        }else if(this.props.role_id==1){ //学生登录
            
            student.login(param);

        }else if(this.props.role_id==2){ //教师登录
            
            teacher.login(param);
        }
        
        
        
    }
    render(){
        return(
            <div class="login-content">
                <div class="login-form">
                    <h4>{this.props.title}</h4>
                        <div class="form-group">
                            <label>用户名</label>
                            <input type="text" class="form-control" placeholder="Username" id = "username" />
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input type="password" class="form-control" placeholder="Password" id = "password"/>
                        </div>
                        <div class="checkbox">
                            <label>
								<input type="checkbox" /> 记住我
							</label>
                            <label class="pull-right">
								<a href="#">忘记密码?</a>
							</label>
                        </div>
                        <button  class="btn btn-primary btn-flat m-b-30 m-t-30" onClick = {this.login_submit}>登  录</button>

                        <div class="register-link m-t-15 text-center">
                            <p>你有账号吗 ? <a href="#"> 点击这里注册</a></p>
                        </div>
                </div>
            </div>
        );
    }
}

module.exports = LoginForm;
