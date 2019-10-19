import React from 'react'
import ReactDOM from 'react-dom'
import EvaluateTable from './components/EvaluateTable.jsx'
//import UserInform from './commponent/UserInform.jsx'

//let stu_inform = JSON.parse(localStorage.getItem('stu_inform'));

// ReactDOM.render(
//     <UserInform name={stu_inform.name} />,
//     document.getElementById('user_inform')
// )
ReactDOM.render(
    //role==1 =>学生，role==2 =>教师
    <EvaluateTable role={2} />,
    document.getElementById("evaluate_item")
)