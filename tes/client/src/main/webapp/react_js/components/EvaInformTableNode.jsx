import React, { Component } from 'React';

class EvaInformTableNode extends Component{
    constructor(props){
        super(props);
    }
    render(){
        return(     
        <tr>
            <td>{this.props.subject}</td>
            <td>{this.props.answer}</td>
        </tr>           
        )
    }
}

module.exports = EvaInformTableNode;