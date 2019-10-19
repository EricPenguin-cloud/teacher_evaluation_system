import axios from 'axios';
import qs from 'qs';

const URL="http://localhost:8090";

//post 无参数提交
const postData = async (url)=>{
    let data = await axios({
        url:url,
        method: 'post'
    }) .then(function (response) {
        return response.data;
    })

    return data;
}

//post 带参数提交
const postDataByParam = async (url,param)=>{
    let result = await axios.post(url,param)
                  .then(function (response) {
                    return response.data; 
                  });
    return result;
}

const postRequestBodyByParam = async (url,data)=>{
    let result =await axios({
        url:url,
        method: 'post',
        data:data
    }) .then(function (response) {
        return response.data;
    })
    return result;
}

const postParamAndData=async (url,params,data)=>{
    let result = axios({
        url:url,
        params:params,
        paramsSerializer: function(params) {
            return qs.stringify(params, {arrayFormat: 'brackets'})
        },
        data:data,
        method: 'post'
    }) .then(function (response) {
        return response.data;
    })

    return result;
}

export default {

    //请求获得所有学生信息
    _postStudentList: async ()=>{
        let data = await postData(URL+'/StudentList');
        return data;
    },
    //请求获得所有学生信息
    _postTeacherList: async ()=>{
        let data = await postData(URL+'/Teacherlist');
        return data;
    },
    
    //管理员登录提交
    _loginSubmitAdmin:async (param)=>{

        let param_submit = new URLSearchParams();
        param_submit.append('username', param.username);
        param_submit.append('password', param.password);

        let result = await postDataByParam(URL+'/AdminLogin',qs.stringify(param));

        return result;
    },
    //学生登录提交
    _loginSubmitStu:async (param)=>{
        let param_submit = new URLSearchParams();
        param_submit.append('username', param.username);
        param_submit.append('password', param.password);

        let result = await postDataByParam(URL+'/StudentLogin',qs.stringify(param));

        return result;
    },
    //教师登录提交
    _loginSubmitTea:async (param)=>{
        
        let param_submit = new URLSearchParams();
        param_submit.append('username', param.username);
        param_submit.append('password', param.password);

        let result = await postDataByParam(URL+'/TeacherLogin',qs.stringify(param));

        return result;
    },
    _getTeacherList:async(param)=>{       
        let param_submit = new URLSearchParams();
        param_submit.append('gid', param);
    
        let data = await postDataByParam(URL+'/ShowStudentEvaluateData',param_submit);
        return data;
    },
    //学生评价老师题目获取
    _getStuEvaluateTable:async ()=>{
        let data = await postData("http://localhost:8090/hello");
        return data
    },
    _getTeaEvaluateTbale: async ()=>{
        let data = await postData("http://localhost:8090/tea_item");
        return data
    },

    //修改学生信息
    _alterStuInform:async (param)=>{
        let result = await postDataByParam("",param);
        return result
    },
    _submitStuAval:async (param,data)=>{
        console.log(JSON.stringify(param));
        console.log(JSON.stringify(data));
        let result = await axios({
                url:URL+"/CommitStudentEvaluation",
                params:{
                    "result_scnd": JSON.stringify(param)
                },
                paramsSerializer: function(params) {
                    return qs.stringify(params, {arrayFormat: 'brackets'})
                },
                data:data,
                method: 'post'
            }) .then(function (response) {
                return response.data;
        });

        return result;
    },
    _submitTeaAval:async (param,data)=>{
        console.log(JSON.stringify(param));
        console.log(JSON.stringify(data));
        let result = await axios({
                url:URL+"/CommitTeacherEvaluation",
                params:{
                    "result_scnd":  JSON.stringify(param)
                },
                paramsSerializer: function(params) {
                    console.log(qs.stringify(params, {arrayFormat: 'brackets'}))
                    return qs.stringify(params, {arrayFormat: 'brackets'})
                },
                data:data,
                method: 'post'
            }) .then(function (response) {
                return response.data;
        });

        return result;
    },
    _getStuState:async (param)=>{
        let data = await postDataByParam(URL+"/selectStudentStaete",qs.stringify(param));
        return data;
    },
    _getTeaState:async (param)=>{
        let data = await postDataByParam(URL+"/selectTeacherSate",qs.stringify(param));
        return data;
    },
    _getTestData:async (params,data)=>{
        //console.log(typeof qs.stringify(param));
        let result = await postParamAndData(URL+"/test",params,data)
        return result;
    },
    _getTeaEvaList: async(param) =>{
        let param_submit = new URLSearchParams();
        param_submit.append('tid', param);
    
        let data = await postDataByParam(URL+'/ShowTeacherEvaluateData',param_submit);
        return data;
    },
    _getGradeList:async ()=>{
        let data = await postData(URL+"/gradeList");
        return data;
    },
    _getCourseList:async ()=>{
        let data = await postData(URL+"/courseList");
        return data;
    },
    _submitTeaInform: async(data)=>{
        let result = await axios({
            url:URL+'/ImportFileTeacher',
            data:data,
            method: 'post'
        }) .then(function (response) {
            return response.data;
        });
        return result;
    },
    _submitStuInform: async(data)=>{
        let result = await axios({
            url:URL+'/ImportFileStudent',
            data:data,
            method: 'post'
        }) .then(function (response) {
            return response.data;
        });
        return result;
    },
    _getStuEvaResult: async (param)=>{
        let param_submit = new URLSearchParams();
        param_submit.append('sid', param.sid);
        param_submit.append('tid', param.tid);

        let result = await postDataByParam(URL+'/showResult',qs.stringify(param));

        return result;
    },
    _getTeaEvaResult:async (param)=>{
        let param_submit = new URLSearchParams();
        param_submit.append('t_id1', param.t_id1);
        param_submit.append('t_id2', param.t_id2);

        let result = await postDataByParam(URL+'/showEvaluateResult',qs.stringify(param));

        return result;
    },
    _addTeaRel:async (param)=>{
        let param_submit = new URLSearchParams();
        
        param_submit.append('tid', param.tid);
        param_submit.append('gid', param.gid);
        param_submit.append('tid', param.tid);

        let result = await postDataByParam(URL+'/StudentTeacherRelationship',qs.stringify(param));

        return result;
    },
    _getTeaRelState:async()=>{
        let data = await postData(URL+"/get_tcg_id");
        return data;
    },
    _selectCountT:async ()=>{
        let data = await postData(URL+'/selectCountT');
        return data;
    },
    _selectAnswerT:async ()=>{
        let data = await postData(URL+'/selectAnswerT');
        return data;
    },
    _selectCountS:async ()=>{
        let data = await postData(URL+'/selectCountS');
        return data;
    },
    _selectAnswerS:async ()=>{
        let data = await postData(URL+'/selectAnswerS');
        return data;
    } 
}