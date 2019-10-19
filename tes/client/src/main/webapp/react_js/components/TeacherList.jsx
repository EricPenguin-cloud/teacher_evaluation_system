import React, { Component } from 'React';
import axios from '../api/axios_api.jsx';
import  TeacherListNode from './TeacherListNode.jsx'

class TeacherList extends Component{
    constructor(props){
        super(props);
        this.state = {
            data_list : []
        }
    }
    async componentWillMount(){
        let result = await axios._getTeaRelState();
        console.log(result.length);
        let data = await axios._postTeacherList();
        let data_list = [];
        data.forEach(element => {
            if(result.length==0){
                data_list.push(<TeacherListNode state={0} id={element.id} number={element.number} name={element.name} sex={element.sex} phone={element.phone} />);
            }
            for(let i=0;i<result.length;i++){
                console.log(element.id+'=='+result[i]);
                if(element.id==result[i]){
                    data_list.push(<TeacherListNode state={1} id={element.id} number={element.number} name={element.name} sex={element.sex} phone={element.phone} />);
                    break;
                }else if(i==result.length-1){
                    data_list.push(<TeacherListNode state={0} id={element.id} number={element.number} name={element.name} sex={element.sex} phone={element.phone} />);
                }
            }
        });
        console.log(data);
        this.setState({
            data_list : data_list
        })
    }
    render(){
        return(
            <table id="" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>工号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>手机号</th>
                        <th style={{textAlign:'left'}}>修改</th>
                    </tr>
                    </thead>
                    <tbody >
                        {this.state.data_list}
                    </tbody>
                </table>

        ) 
    }
}
module.exports = TeacherList;