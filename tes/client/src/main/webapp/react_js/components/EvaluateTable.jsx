import React, { Component } from 'React';
import EvaluateNode from './EvaluateNode.jsx'
import axios from '../api/axios_api.jsx'

class EvaluateTable extends Component{
    constructor(props){
        super(props);
        this.evaluate_submit = this.evaluate_submit.bind(this);
        this.loadStuEva = this.loadStuEva.bind(this);
        this.loadTeaEva = this.loadTeaEva.bind(this);
        this.state = {
            evaluate_item: [],
            data:[]
        };
    }
    async loadStuEva(){             //学生获得所有评价信息
        
        let data = await axios._getStuEvaluateTable();
        let evaluate_item = [];
        console.log(data.evaluate_item);
        for(let i=0;i<data.evaluate_item.length;i++){
            evaluate_item[i] = <EvaluateNode  id={data.evaluate_item[i].id} content={data.evaluate_item[i].content}/>
        }
        this.setState({
            evaluate_item: evaluate_item,
            data:data.evaluate_item
        });
    }
    async loadTeaEva(){             //  教师获得所有评价信息
        let data = await axios._getTeaEvaluateTbale();
        let evaluate_item = [];
        console.log(data.evaluate_item);
        for(let i=0;i<data.evaluate_item.length;i++){
            evaluate_item[i] = <EvaluateNode  id={data.evaluate_item[i].id} content={data.evaluate_item[i].content}/>
        }
        this.setState({
            evaluate_item: evaluate_item,
            data:data.evaluate_item
        });
    }
    componentDidMount() {
        //alert(this.props.role);
        if(this.props.role==1){
            this.loadStuEva();
        }else if(this.props.role==2){
            this.loadTeaEva();
        }
        
    }
    isElementNull(list){
        for(let i=0;i<list.length;i++){
            if(list[i].checked){
                break;
            }
            if(i==list.length-1){
                return false;
            }
        }
        return true;
    }
    getAnswer(answer){
        switch(answer){
            case "4":
                return "不满意";
                break;
            case "6":
                return "一般满意";
                break;
            case "8":
                return "满意";
                break;
            case "10":
                return "非常满意";
                break;
        }
    }
    async evaluate_submit(){
        let list = new Array();
        let total = 0;
        let evaluate_item = this.state.data;
        let isNull = false;

        for(let i=0;i<evaluate_item.length;i++){
            let obj = document.getElementsByName("card_"+(i+1));
            if(this.isElementNull(obj)==false){
                isNull = true;
                alert("评价题目未完成，请将其填满");
                break;
            }else{
                for(let j=0; j<obj.length; j++) { //遍历Radio 
                    if (obj[j].checked) {
                        let record_scnd={
                            subject:evaluate_item[i].content,
                            answer:this.getAnswer(obj[j].value),
                            score:obj[j].value
                        };
                        list.push(record_scnd);
                        total = total+parseInt(obj[j].value);                   
                    }
                }
            }
        }
        if(isNull==false){
            
            let result = 'yes';
            //role==1 =>学生，role==2 =>教师
            if(this.props.role == 1){   //sid评价tid
                let param = {
                    tid:localStorage.getItem("eval_id"),
                    sid:localStorage.getItem("stu_id"),
                    total:total+""
                };
                console.log(JSON.stringify(param));
                result =await axios._submitStuAval(param,list);
                if(result=='success'){
                    alert("评价成功！");
                    document.location = './stu-evaluation.html'
                }
                
            }else if(this.props.role == 2){  //t_id1评价t_id2
                let param = {
                    t_id1:localStorage.getItem("tea_id"),
                    t_id2:localStorage.getItem("tea_eval_id"),
                    total:total+""
                };
            
                result =await axios._submitTeaAval(param,list);
                console.log(result);
                if(result=='success'){
                    alert("评价成功！");
                    document.location = './t-evaluation.html'
                }
            }
            
            
            
        }
        


    }
    render(){
        return (
            <div>
                <div id="main-content" >
                    {this.state.evaluate_item}
                </div>
                <div style={{height: "100px",textAlign: "center"}}>
                    <button onClick = {this.evaluate_submit}  class="btn btn-primary btn-flat m-b-30 m-t-30" style={{backgroundColor: "#EBECF1",border:"none",width: "1000px",height: "50px",color: "#7E7E92"}}>Sign in</button>
                </div>
            </div>
            );

    }
}

module.exports = EvaluateTable;
    
