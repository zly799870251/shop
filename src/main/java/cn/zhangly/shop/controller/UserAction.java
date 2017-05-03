package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 青葉 on 2017/4/25.
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction extends BaseAction {

    @RequestMapping("/loginUI")
    public String loginUI() {
        return "userLogin";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        User user = userService.login(username, password);
        System.out.println(user);
//        if (user != null) {
//            request.getSession().setAttribute("user", user);
//            return "index";
//        } else {
//            return "userLogin";
//        }
        return "userLogin";
    }

    @RequestMapping("/registerUI")
    public String registerUI() {
        return "userRegister";
    }

    @RequestMapping("/register")
    public String register(User user, String checkcode) {
        user.setState(0);
        user.setActivCode(UUID.randomUUID().toString());
        userService.save(user);
        return "success";
    }

    @RequestMapping("/usernameValidate")
    @ResponseBody
    public String usernameValidate(String username) {
        return String.valueOf(userService.usernameValidate(username));
    }

    @RequestMapping("/checkcodeValidate")
    @ResponseBody
    public String checkcodeValidate(String checkcode, HttpServletRequest request) {
        String sessionCode = (String) request.getSession().getAttribute("checkcode");
        sessionCode = sessionCode.toUpperCase();
        checkcode = checkcode.toUpperCase();
        System.out.println("sessionCode = " + sessionCode);
        System.out.println("checkcode = " + checkcode);
        return sessionCode.equals(checkcode) ? "0" : "1";
    }

}
