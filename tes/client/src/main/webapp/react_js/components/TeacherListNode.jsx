import React from 'react'

class TeacherListNode extends React.Component{
    constructor(props){
        super(props);
        this.add_relationship = this.add_relationship.bind(this);
        this.state = {
            page_data:[]
        }
    }
    componentWillMount(){
        if(this.props.state == 1){
            this.setState({
                page_data:'已绑定'
            })
        }else if(this.props.state == 0){
            this.setState({
                page_data:<button onClick={this.add_relationship} data-toggle="modal" data-target="#myModal" style={{border: 'none',outline:'none',width: '50px'}}><span class="ti-reload"></span></button>
            })
        }
    }
    add_relationship(){
        localStorage.setItem("rel_id",this.props.id);
    }
    render(){
        return(
            <tr>
                        <td>{this.props.number}</td>
                        <td>{this.props.name}</td>
                        <td>{this.props.sex}</td>
                        <td>{this.props.phone}</td>
                        <td>{this.state.page_data}</td>
                    </tr>
        )
    }
}

module.exports = TeacherListNode;