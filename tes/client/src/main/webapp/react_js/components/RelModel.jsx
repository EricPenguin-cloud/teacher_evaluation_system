import React from 'react'
import axios from '../api/axios_api.jsx'

class RelModel extends React.Component{
    constructor(props){
        super(props);
        this.add_relationship = this.add_relationship.bind(this);
        this.state = {
            grade_page:[],
            course_page:[]
        }
    }
    async componentWillMount(){
        let grade_data = await axios._getGradeList();
        let grade_page = []
        grade_data.forEach(element => {
            console.log(element);
            grade_page.push(<option value={element.id}>{element.name}</option>);
        });

        let course_data = await axios._getCourseList();
        let course_page = [];
        course_data.forEach(element=>{
            console.log(element);
            course_page.push(<option value={element.id}>{element.name}</option>)
        });
        this.setState({
            grade_page:grade_page,
            course_page:course_page
        })
    }
    async add_relationship(){
        let tid = localStorage.getItem("rel_id");
        let gid = document.getElementById('gid').value;
        let cid = document.getElementById('cid').value;
        let param = {
            tid:tid,
            gid:gid,
            cid:cid
        }
        let result = await axios._addTeaRel(param);
        if(result == 'success'){
            alert('绑定成功');
            document.location = './inform-tea.html'
        }else{
            alert('绑定失败');
        }
    }
    render(){
        return(
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        请为教师分配对应班级和相应课程
                    </h4>
                </div>
                <div class="modal-body">
                    <h6>请选择班级&nbsp;&nbsp;&nbsp;&nbsp;
                        <select id='gid' style={{border: 'none',height: '35px',outline:'none'}}>
                            {this.state.grade_page}
                        </select>
                    </h6>
                    <h6>请选择课程&nbsp;&nbsp;&nbsp;&nbsp;
                        <select id='cid' style={{border: 'none',height: '35px',outline:'none'}}>
                            {this.state.course_page}
                        </select>
                    </h6>
    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" onClick={this.add_relationship} class="btn btn-primary">
                        确定
                    </button>
                </div>
            </div>
        </div>
        )
    }
}

module.exports =  RelModel;