import React from 'react'
import ReactDOM from 'react-dom'
import TeacherList from './components/TeacherList.jsx'
import RelModel from './components/RelModel.jsx'


ReactDOM.render(
    <TeacherList />,
    document.getElementById("tea_list")
); 
ReactDOM.render(
    <RelModel />,
    document.getElementById('myModal')
)