package cn.chenqiangjun.controller;

import cn.chenqiangjun.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping(value = "anno")
@SessionAttributes(value = "msg") // 把msg=陈强军存入到session域对象
public class AnnotationsController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }


//    @RequestMapping("/testModelAttribute")
//    public String testModelAttribute(User user){
//        System.out.println(user);
//        return "success";
//    }
//
//    /**
//     * 该方法会先执行，与表单提交重复的内容会被表单覆盖，表单没有的内容原封不动的传上去
//     * @param uname
//     * @return
//     */
//    @ModelAttribute
//    public User showUser(String uname){
//        System.out.println("showUser执行了");
//        //通过用户名查询数据库（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }


    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 未带参数的方法需要添加到 map中
     * @param uname
     * @param map
     */
    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了");
        //通过用户名查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }


    /**
     * 存入session
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        model.addAttribute("msg","陈强军");
        return "success";
    }

    /**
     * 获取session
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelmap){
        String msg = (String) modelmap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除session
     * @return
     */
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        status.setComplete();
        return "success";
    }

}
