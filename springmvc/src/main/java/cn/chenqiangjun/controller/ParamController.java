package cn.chenqiangjun.controller;


import cn.chenqiangjun.domain.Account;
import cn.chenqiangjun.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


    @RequestMapping("getServlet")
    public String getServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }



}
