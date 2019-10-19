package com.cqgcxy.client.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StuPageController {

    @RequestMapping("/stu-login.html")
    public String login(){
        return "/page/student/stu-login.html";
    }
    @RequestMapping("/stu-index.html")
    public String index(){
        return "/page/student/stu-index.html";
    }
    @RequestMapping("/stu-evaluate.html")
    public String evaluate(){
        return "/page/student/stu-evaluate.html";
    }
    @RequestMapping("/stu-evaluation.html")
    public String evaluation(){
        return "/page/student/stu-evaluation.html";
    }
    @RequestMapping("/stu-updatePw.html")
    public String stu_updata_pw(){
        return "/page/student/stu-updatePw.html";
    }
    @RequestMapping("/stu-viewResult.html")
    public String stu_view_result(){
        return "/page/student/stu-viewResult.html";
    }
    @RequestMapping("/student.html")
    public String student(){
        return "/page/student/student.html";
    }
}
