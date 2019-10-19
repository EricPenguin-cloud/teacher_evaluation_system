import React from 'react'

class StudentNode extends React.Component{
    constructor(props){
        super(props);
        // 绑定
        this.alter = this.alter.bind(this);
        this.reset = this.reset.bind(this);
        this.state = {
            //0:未修改状态  1:修改状态
            status : 0
        }
    }
    //学生信息修改提交
    alter(){
        if(this.state.status == 0){
            
            //点击将文本换成可修改的文本框

            this.props.number = <input class="input_alter" id="alter_number" type="text" 
                                    value={this.props.number} />
            this.props.name = <input class="input_alter" id="alter_name" type="text" 
                                    value={this.props.name} />
            this.props.sex = <input class="input_alter" id="alter_sex" type="text" 
                                    value={this.props.sex} />
            this.props.grade = <input class="input_alter" id="alter_grade" type="text" 
                                    value={this.props.grade} />
            
            this.setState({
                status : 1
            })
        }else{

            //提交修改

            let id = document.getElementById("stu_id").value;
            let number = document.getElementById("alter_number").value;
            let name = document.getElementById("alter_name").value;
            let sex = document.getElementById("alter_sex").value;
            let grade = document.getElementById("alter_grade").value;
            
            let param = new URLSearchParams();
            param.append('id', id);
            param.append('number', number);
            param.append('name', name);
            param.append('sex',sex);
            param.append('grade', grade);




            this.props.number = number;
            this.props.name = name;
            this.props.sex = sex;
            this.props.grade = grade;
            
            this.setState({
                status : 0
            })
        }
    }

    reset(){
        alert("1111");
    }

    render(){
        return(
            <tr>
                <input type="hidden" value={this.props.id} id='stu_id' />
                <td>{this.props.number}</td>
                <td>{this.props.name}</td>
                <td>{this.props.sex}</td>
                <td>{this.props.grade}</td>
                <th><a onClick={this.alter}> <span class="ti-pencil-alt"></span></a></th>
                <th><button onClick={this.reset} style={{border: "none",background: "none"}}><span class="ti-reload"></span></button></th>
            </tr>
        )
    }
}

module.exports = StudentNode;
