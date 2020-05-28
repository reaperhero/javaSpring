package cn.chenqiangjun.controller;

import cn.chenqiangjun.domain.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserVoController {

    @RequestMapping("testString")
    public String testString(Model model){
        System.out.println("testString执行了");
        UserVo userVo = new UserVo();
        userVo.setUsername("陈强军");
        userVo.setAge(20);
        // model对象
        model.addAttribute("user",userVo);
        userVo.setPassword("123ds45");
        return "uservo";
    }


    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了");
        // 1、请求转发
        // 不会再去走视图解析器，需要手动写全路径
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 2、重定向
        // 重定向用户会请求两次，返回给用户的页面只能是WEB-INF下的文件
        // response.sendRedirect(request.getContextPath()+"/index.jsp");

        // 3、直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("hello");
        return;
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建对象
        System.out.println("testModelAndView执行了");
        ModelAndView mv = new ModelAndView();
        UserVo userVo = new UserVo();
        userVo.setUsername("陈强军");
        userVo.setAge(20);
        userVo.setPassword("asdsada");
        // 把uservo对象加入到mv中
        mv.addObject("user",userVo);

        // 跳转到哪个页面
        mv.setViewName("uservo");
        return mv;
    }

    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了。。");

        // 请求转发
        // return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/userui.jsp";
    }



    /**
     * @RequestBody：服务器接收到的json格式的数据解析成实体类型
     * @ResponseBody：服务器响应时将返回的数据解析成json格式
     *
     * @param uservo
     * @return
     */
    @RequestMapping("testAjax")
    public @ResponseBody UserVo testAjax(@RequestBody String body,UserVo userVo){
        System.out.println("testAjax执行了。。");
        System.out.println(body);
        // 做响应，模拟查询数据库
        userVo.setUsername("response-username");
        userVo.setPassword("response-pws");
        userVo.setAge(25);
        return userVo;
    }

}
