import React, { Component } from 'React';
import  StudentEvaluateListNode from './StudentEvaluateListNode.jsx'
import axios from '../api/axios_api.jsx'

class StudentEvaluateList extends Component{
    constructor(props){
        super(props);
        // this.evaluate_submit = this.evaluate_submit.bind(this);
        this.state = {
            evaluate_item: [],
            data:[]
        };
    }
    
    async  componentWillMount() {       
        let data = await axios._getTeacherList(parseInt(localStorage.getItem('stu_gid')));
        let data_state = await axios._getStuState({sid:localStorage.getItem('stu_id')});
        //alert(localStorage.getItem('stu_id'));
        let page_data = [];
        for(let i=0;i<data.result.length;i++){
            if(data_state.length==0){
                page_data[i] = <StudentEvaluateListNode state={0} id={data.result[i].teacher.id} name={data.result[i].teacher.name} course={data.result[i].course.name}  />;
            }
            for(let j=0;j<data_state.length;j++){
                //alert(data_state[j].tid+"?"+data.result[i].teacher.id)
                console.log(typeof data.result[i].teacher.id);
                if(data_state[j].tid==data.result[i].teacher.id){
                    
                    page_data[i] = <StudentEvaluateListNode total={data_state[j].total} state={1} id={data.result[i].teacher.id} name={data.result[i].teacher.name} course={data.result[i].course.name}  />;
                    break;
                }else if(data_state[j].tid!=data.result[i].teacher.id&&j==data_state.length-1){
                    page_data[i] = <StudentEvaluateListNode state={0} id={data.result[i].teacher.id} name={data.result[i].teacher.name} course={data.result[i].course.name}  />;
                }
 
            }
        }
        this.setState({
            status:1,
            page_data : page_data
        });
    }
    
    render(){
        return(
            <table id="" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>教师姓名</th>
                        <th>所教课程</th>
                        <th>评价状态</th>
                        <th>结果</th>
                    </tr>
                </thead>
                <tbody >
                    {this.state.page_data}
                </tbody>
            </table>
        )
    }
}

module.exports = StudentEvaluateList;