import React, { Component } from 'React';
import axio from '../api/axios_api.jsx';
import StudentNode from './StudentNode.jsx'

class StudentList extends Component{
    constructor(props){
        super(props);
        this.state = {
            status:0,
            data: []};
    } 
    async  componentWillMount() {
        //获得所有学生信息
        let data = await axio._postStudentList();
        this.setState({
            status:1,
            data : data
        });
    }
    render(){
        if(this.state.status == 0){
            return 'component are loading。。。' ;
        }else if(this.state.status == 1){
            console.log(this.state.data);
            let stu_list = [];
            let data = this.state.data;
            for(let i=0;i<data.length;i++){
                stu_list[i] = <StudentNode id={this.state.data[i].id} number={this.state.data[i].number} name={this.state.data[i].name} sex={this.state.data[i].sex} grade={this.state.data[i].grade.name}/>
            }
            return stu_list;
        }
         
    }
}

module.exports = StudentList;
