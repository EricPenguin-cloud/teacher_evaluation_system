import React from 'React';

class TeaEvaListNode extends React.Component{
    constructor(props){
        super(props);
        this.tea_evaluate = this.tea_evaluate.bind(this);
        this.getResult = this.getResult.bind(this);
        this.state = {
            evaluate_state: <a onClick={this.tea_evaluate} style={{cursor:'pointer'}}> 去评价</a>,
            result:<a>无</a>
        };
    }
    getResult(){ 
        localStorage.setItem("tea_eval_res_id",this.props.id);
        localStorage.setItem('eva_total',this.props.total);

        document.location = 't-viewResult.html';
    }

    componentWillMount(){
        if(this.props.state==1){
            this.setState({
                evaluate_state: <a> 已评价</a>,
                result:<a onClick={this.getResult} style={{cursor:'pointer'}}>查看结果</a>
            });
            
        }
    }
    tea_evaluate(){
        //alert(this.props.id);
        localStorage.setItem("tea_eval_id",this.props.id);
        document.location = 't-evaluate.html';
    } 
    render(){
        return(<tr>
            <td>{this.props.name}</td>
            <td>{this.props.course}</td>
            <td>{this.state.evaluate_state}</td>
            <td>{this.state.result}</td>
        </tr>)
    }
}

module.exports = TeaEvaListNode;