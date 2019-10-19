package com.cqgcxy.client.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeaPageController {
    @RequestMapping("/t-login.html")
    public String login(){
        return "/page/teacher/t-login.html";
    }
    @RequestMapping("/t-index.html")
    public String index(){
        return "/page/teacher/t-index.html";
    }
    @RequestMapping("/t-evaluate.html")
    public String evaluate(){
        return "/page/teacher/t-evaluate.html";
    }
    @RequestMapping("/t-evaluation.html")
    public String evaluation(){
        return "/page/teacher/t-evaluation.html";
    }
    @RequestMapping("/t-updatePw.html")
    public String stu_updata_pw(){
        return "/page/teacher/t-updatePw.html";
    }
    @RequestMapping("/t-viewResult.html")
    public String stu_view_result(){
        return "/page/teacher/t-viewResult.html";
    }
    @RequestMapping("/teacher.html")
    public String student(){
        return "/page/teacher/teacher.html";
    }
    @RequestMapping("/t-MyResult.html")
    public String my_result(){
        return "/page/teacher/t-MyResult.html";
    }
    @RequestMapping("/t-MyEvaluation.html")
    public String my_MyEvalution(){
        return "/page/teacher/t-MyEvaluation.html";
    }

}
