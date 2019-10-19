import React from 'react'
import ReactDOM from 'react-dom'

import EvaInformTable from './components/EvaInformTable.jsx'

ReactDOM.render(
    //role==1 =>学生，role==2 =>教师
    <EvaInformTable role={2}  />,
    document.getElementById('main')
)