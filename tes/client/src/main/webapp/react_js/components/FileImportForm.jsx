import React, { Component } from 'React';
import axio from '../api/axios_api.jsx';
import XLSX from 'xlsx';
class FileImportForm extends  Component{
    constructor(props){
        super(props);
        this.submit = this.submit.bind(this);
        this.state={
            stu_page:''
        };
    }
    async componentDidMount(){
        if(this.props.role==1){
            let data = await axio._getGradeList();
            let page_data = [];
            console.log(data);
            for(let i=0;i<data.length;i++){
                page_data[i]=<option value={data[i].id}>{data[i].name}</option>
            }

            let stu_page = <h6 style={{position: 'relative',left: '-300px'}}>请选择班级&nbsp;&nbsp;&nbsp;&nbsp;
                    <select id='gid' style={{border:'none',height: '35px',outline:'none'}}>
                        {page_data}
                    </select>
                 </h6>
            this.setState({
                stu_page:stu_page
            }); 
        }
        
    }
    async submit(){
        let role=this.props.role;
        let fileObj = document.getElementById("file_data").files[0];
        var reader = new FileReader();
        reader.onload = function(e) {
            var data = e.target.result;
            var workbook = XLSX.read(data, {type: 'binary'});
            workbook.SheetNames.forEach(async function (sheetName) {
                var roa = XLSX.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
                if(role==1){
                    let param = [];
                    roa.forEach(element => {
                        param.push({
                            number:element.number,
                            name:element.name,
                            sex:element.sex,
                            gid:document.getElementById('gid').value
                        })
                    });
                    
                    let result = await axio._submitStuInform(param);
                    if(result==true){
                        alert("学生信息导入成功");         
                    }
                }else if(role==2){
                    let result = await axio._submitTeaInform(roa);
                    if(result==true){
                        alert("教师信息导入成功");         
                    }
                }
            });
        };
        reader.readAsBinaryString(fileObj);
    }
    render(){
        return(
            <div>
                {this.state.stu_page}
                <div style={{width: '600px',float:'right',position: 'relative',top: '-40px',right: '100px'}}>
                        <input type="file" id='file_data' />
                        <button  style={{border: 'none',height: '35px',width: '80px'}} onClick={this.submit}>确&nbsp;&nbsp;定</button>
                </div>  
            </div>        
             
        );
    }
}

module.exports = FileImportForm;