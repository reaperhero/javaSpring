package cn.chenqiangjun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String helloController(){
        System.out.println("Hello Controller");
        return "success";
    }
}
