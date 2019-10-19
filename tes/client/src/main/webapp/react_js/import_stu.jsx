import React from 'react'
import ReactDOM from 'react-dom'

import FileImportForm from './components/FileImportForm.jsx';

ReactDOM.render(    //role==1 =>学生，role==2 =>教师
    <FileImportForm role={1}/>,
    document.getElementById("file_import")
) 