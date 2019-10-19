package com.cqgcxy.client.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class AdminPageController {
    @RequestMapping("/admin-login.html")
    public String login(){
        return "/page/administer/admin-login.html";
    }
    @RequestMapping("/admin-index.html")
    public String index(){
        return "/page/administer/admin-index.html";
    }
    @RequestMapping("/import-stu.html")
    public String import_stu(){
        return "/page/administer/import-stu.html";
    }
    @RequestMapping("/import-tea.html")
    public String import_tea(){
        return "/page/administer/import-tea.html";
    }
    @RequestMapping("/inform-stu.html")
    public String inform_stu(){
        return "/page/administer/inform-stu.html";
    }
    @RequestMapping("/inform-tea.html")
    public String inform_tea(){
        return "/page/administer/inform-tea.html";
    }
}
