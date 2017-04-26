package cn.zhangly.shop.controller;

import cn.zhangly.shop.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 青葉 on 2017/4/25.
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "userLogin";
    }

    @RequestMapping("/registerUI")
    public String registerUI(){
        return "userRegister";
    }

    @RequestMapping("/register")
    public String register(User user, HttpServletRequest request){
        System.out.println(user);
        return "registerSuccess";
    }

}
