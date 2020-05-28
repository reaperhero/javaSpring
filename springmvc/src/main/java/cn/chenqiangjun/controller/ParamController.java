package cn.chenqiangjun.controller;


import cn.chenqiangjun.domain.Account;
import cn.chenqiangjun.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("param")
public class ParamController {
    @RequestMapping("testParam")
    public String testParam(String username,String password){
        System.out.println("执行了");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    @RequestMapping("saveParam")
    public String saveParam(Account account){
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }

    @RequestMapping("saveUser")
    public String saveUser(User user){
        System.out.println("执行了");
        System.out.println(user);
        return "success";
    }

}
