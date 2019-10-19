import React from 'react'
class UpdatePassword extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(<div class="login-content">
        <div class="login-logo">
            <a href="../student/stu-index.html"><span></span></a>
        </div>
        <div class="login-form">
            <h4>修改密码</h4>
            
                <div class="form-group">
                    <label>新密码</label>
                    <input type="password" class="form-control" placeholder="输入密码" />
                </div>
                <button type="submit" class="btn btn-primary btn-flat m-b-15">提交</button>
                <div class="register-link text-center">
                    <p>回到<a href="stu-index.html"> 首页</a></p>
                </div>
          
        </div>
    </div>)
    }
}

module.exports = UpdatePassword