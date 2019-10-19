import React from 'react'
import ReactDOM from 'react-dom'
import EvaluateTable from './components/EvaluateTable.jsx'

ReactDOM.render(
    //role==1 =>学生，role==2 =>教师
    <EvaluateTable role={1} />,
    document.getElementById("evaluate_item")
)