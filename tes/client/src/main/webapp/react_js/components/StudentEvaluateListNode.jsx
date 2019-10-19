import React, { Component } from 'React';

class StudentEvaluateListNode extends Component{
    constructor(props){
        super(props);
        this.stu_evaluate = this.stu_evaluate.bind(this);
        this.getResult = this.getResult.bind(this);
        this.state = {
            evaluate_state: <a onClick={this.stu_evaluate} > 去评价</a>,
            result:<a>无</a>
        };
    }
    getResult(){ 
        localStorage.setItem("stu_eval_res_id",this.props.id);
        localStorage.setItem('eva_total',this.props.total);
        document.location = 'stu-viewResult.html';
    }
    componentWillMount(){
        if(this.props.state==1){
            //alert(111);
            localStorage.setItem('eva_total',this.props.total)
            this.setState({
                evaluate_state: <a> 已评价</a>,
                result:<a onClick={this.getResult} style={{cursor:'pointer'}}>查看结果</a>
            });
            
        }else{
            //alert(0);
            this.setState({
                evaluate_state: <a onClick={this.stu_evaluate} style={{cursor:'pointer'}}> 去评价</a>,
            result:<a>无</a>
            });
        }
    }
    stu_evaluate(){
        //alert(this.props.id);
        localStorage.setItem("eval_id",this.props.id);
        document.location = 'stu-evaluate.html';
    }
    render(){
        return(
            <tr>
                <td>{this.props.name}</td>
                <td>{this.props.course}</td>
                <td>{this.state.evaluate_state}</td>
                <td>{this.state.result}</td>
            </tr>
        )
    }
}

module.exports = StudentEvaluateListNode