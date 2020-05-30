package cn.chenqiangjun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("表现层：查询所有账户...");
        return "list";
    }
}
