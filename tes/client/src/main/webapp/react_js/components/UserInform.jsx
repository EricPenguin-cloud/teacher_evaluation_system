import React from 'react'

class UserInform extends React.Component{
    constructor(props){
        super(props);
        this._logout = this._logout.bind(this);
    }
    componentWillMount(){
        //alert(1111);
    }
    _logout(){
        // alert(this.props.role)
        // alert(this.props.role==0)
        alert(1111);
        console.log(111);
        // if(this.props.role==0){      //管理员登录
            
        //     admin.login(param);

        // }else if(this.props.role==1){ //学生登录
            
        //     student.login(param);

        // }else if(this.props.role==2){ //教师登录
            
        //     teacher.login(param);
        // }
    }
    render(){
        return(<div class="header-icon" data-toggle="dropdown">
        <span class="user-avatar"  onClick={this._logout}>{this.props.name}
            <i class="ti-angle-down f-s-10"></i>
        </span>
        
        <div class="drop-down dropdown-profile dropdown-menu dropdown-menu-right">
            <div class="dropdown-content-body">
                <ul>
                    <li>
                        <span>
                            <i class="ti-power-off"></i>
                            <span>注销</span>
                        </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>)
    }
}

module.exports = UserInform;