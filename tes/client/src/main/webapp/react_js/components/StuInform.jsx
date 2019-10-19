import React from 'react'

class StuInform extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
            <tr>
                <th>{this.props.number}</th>
                <th>{this.props.name}</th>
                <th>{this.props.sex}</th>
                <th>{this.props.grade}</th>
            </tr>
        )
    }
}

module.exports = StuInform;