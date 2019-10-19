import React from 'React';
import TeaEvaListNode from './TeaEvaListNode.jsx';
import axios from '../api/axios_api.jsx';

class TeaEvaList extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            evaluate_item: [],
            data:[]
        };
    }
    async  componentWillMount() {   
        let data = await axios._getTeaEvaList(localStorage.getItem('tea_id'));    
        let data_state = await axios._getTeaState({t_id1:localStorage.getItem('tea_id')});
        let page_data = [];

        console.log(data_state);
        // for(let i=0;i<data.length;i++){
        //     page_data[i] = <TeaEvaListNode total={0} state={0} id={data[i].teacher.id} name={data[i].teacher.name} course={data[i].course.name}  />; 
        // }
        for(let i=0;i<data.length;i++){
            if(data_state.length==0){
                page_data[i] = <TeaEvaListNode state={0} id={data[i].teacher.id} name={data[i].teacher.name} course={data[i].course.name}  />;
            }
            for(let j=0;j<data_state.length;j++){
                //alert(data_state[j].tid+"?"+data.result[i].teacher.id)
                if(data_state[j].t_id2==data[i].teacher.id){
                    page_data[i] = <TeaEvaListNode total={data_state[j].total} state={1} id={data[i].teacher.id} name={data[i].teacher.name} course={data[i].course.name}  />;
                    break;
                }else if(data_state[j].t_id2!=data[i].teacher.id&&j==data_state.length-1){
                    page_data[i] = <TeaEvaListNode state={0} id={data[i].teacher.id} name={data[i].teacher.name} course={data[i].course.name}  />;
                }
 
            }
        }
        this.setState({
            status:1,
            page_data : page_data
        });
    }
    render(){
        return (
            <table id="" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>教师姓名</th>
                                <th>所教课程</th>
                                <th>评价</th>
                                <th>查看结果</th>
                            </tr>
                        </thead>
                        <tbody id="">
                            {this.state.page_data}
                        </tbody>
            </table>
        )
       
    }
}

module.exports = TeaEvaList