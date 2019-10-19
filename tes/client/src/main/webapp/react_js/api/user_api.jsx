import axios from './axios_api.jsx';
module.exports={
    admin:{
        login:async (param)=>{
            //发送请求
           let result =await axios._loginSubmitAdmin(param);
               
           localStorage.setItem("admin_inform",JSON.stringify(result.result));
           
           if(result.flag == 1){
               document.location = './admin-index.html'
           }else{
               alert("密码输入错误");
               console.log(JSON.stringify(result));
           }
       },
       loginConfirm:()=>{
            if(localStorage.getItem('stu_inform')!=null||localStorage.getItem('admin_inform')!=''){
                if(confirm('您的管理员用户正处于登录状态，是否注销登录')==true){
                    localStorage.setItem("admin_inform",'');
                }else{
                    document.location = './admin-index.html';
                }
            }
        },
        loginState:()=>{
            if(localStorage.getItem('admin_inform')==null||localStorage.getItem('admin_inform')==''){
                alert('您还未登录，请登录');
                document.location = './admin-login.html';
            }
        },
        logout:()=>{
            localStorage.setItem('admin_inform',null);
            alert('用户已注销，请重新登录');
            document.location = './admin-login.html';
        }
    },
    student:{
        login:async (param)=>{
             //发送请求
             let result =await axios._loginSubmitStu(param);
             if(result.flag==1){
                localStorage.setItem("stu_inform",JSON.stringify(result.result));
                localStorage.setItem("stu_id",result.result.id);
                localStorage.setItem("stu_gid",result.result.grade.id);
                console.log(JSON.stringify(result.result))
                document.location = './stu-index.html'
             }else{
                 alert("用户名或密码输入错误");
             }
        },
        loginConfirm:()=>{
            if(localStorage.getItem('stu_inform')!=null||localStorage.getItem('stu_inform')!=''){
                if(confirm('您的学生用户正处于登录状态，是否注销登录')==true){
                    localStorage.setItem("stu_inform",'');
                    localStorage.setItem("stu_id",'');
                    localStorage.setItem("stu_gid",'');
                }else{
                    document.location = './stu-index.html';
                }
            }
        },
        loginState:()=>{
            if(localStorage.getItem('stu_inform')==null||localStorage.getItem('stu_inform')==''){
                document.location = './stu-login.html';
                alert('您还未登录，请登录');
            }
        }
    },
    teacher:{
        login:async (param)=>{
            //发送请求
            let result =await axios._loginSubmitTea(param);
            if(result.flag==1){
                //console.log(result.result)
                localStorage.setItem("tea_inform",JSON.stringify(result.result));
                localStorage.setItem("tea_id",result.result.id);
               document.location = './t-index.html'
             }else{
                 alert("用户名或密码输入错误");
             }
        },
        loginConfirm:()=>{
            if(localStorage.getItem('tea_inform')!=null || localStorage.getItem('tea_inform')!=''){
                if(confirm('您的教师用户正处于登录状态，是否注销登录')==true){
                    localStorage.setItem("tea_inform",'');
                    localStorage.setItem("tea_id",'');
                }else{
                    document.location = './tea-index.html';
                }
            }
        },
        loginState:()=>{
            if(localStorage.getItem('tea_inform')==null||localStorage.getItem('tea_inform')==''){
                alert('您还未登录，请登录');
                document.location = './t-login.html';
            }
        }
    }

}