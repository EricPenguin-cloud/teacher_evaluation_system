import React from 'react'
import ReactDOM from 'react-dom'

import StuInform from './components/StuInform.jsx'

ReactDOM.render(
    <StuInform number={stu_inform.number} name={stu_inform.name} sex={stu_inform.sex} grade={stu_inform.grade.name} />,
    document.getElementById('stu_inform')
)
