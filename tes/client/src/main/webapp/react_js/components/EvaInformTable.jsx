import React, { Component } from 'React';
import EvaInformTableNode from './EvaInformTableNode.jsx'
import axios from '../api/axios_api.jsx'


class EvaInformTable extends Component{
    constructor(props){
        super(props);
        this.state = {
            href:'',
            data:'',
            page_data:[]
        }
    }
    async componentWillMount(){//role==1 =>学生，role==2 =>教师
        
        if(this.props.role==1){
            let sid = localStorage.getItem("stu_id");
            let tid = localStorage.getItem("stu_eval_res_id");
            let param = {
                sid:sid,
                tid:tid
            };
            let data = await axios._getStuEvaResult(param);
            let page_data = [];
            for(let i=0;i<data.length;i++){
                //console.log(data[i]);
                page_data[i] = <EvaInformTableNode subject={data[i].subject} answer={data[i].answer} />;
            }
            this.setState({
                href:'stu-evaluation.html',
                data:data,
                page_data:page_data
            });
        }else{
            let t_id1 = localStorage.getItem("tea_id");
            let t_id2 = localStorage.getItem("tea_eval_res_id");
            let param = {
                t_id1:t_id1,
                t_id2:t_id2
            };
            let data = await axios._getTeaEvaResult(param);
            let page_data = [];
            for(let i=0;i<data.length;i++){
                //console.log(data[i]);
                page_data[i] = <EvaInformTableNode subject={data[i].subject} answer={data[i].answer} />;
            }
            this.setState({
                href:'t-evaluation.html',
                data:data,
                page_data:page_data
            });
            //console.log();
            // this.setState({
            //     href:'t-evaluation.html'
            // })
        }
    }
    render(){
        return(
            <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 p-r-0 title-margin-right">
                    <div class="page-header">
                        <div class="page-title">
                            <h1>总分：<span>{localStorage.getItem('eva_total')}分</span></h1>
                        </div>
                    </div>
                </div>

               
                <div class="col-lg-4 p-l-0 title-margin-left" >
                    <div class="page-header">
                        <div class="page-title">
                            <div class="icon-container"style={{textAlign: 'right'}}>
                                <a href={this.state.href}><span class="ti-arrow-left"></span><span class="icon-name">  返回</span></a>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>

            <section>
                <table id="" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>评价指标</th>
                        <th>满意度</th>
                    </tr>
                    </thead>
                    <tbody>
                        {this.state.page_data}
                    </tbody>
                </table>

            </section>



        </div>
        )
    }
}

module.exports = EvaInformTable;