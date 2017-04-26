package cn.zhangly.shop.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 青葉 on 2017/4/25.
 */
@Controller
@Scope("prototype")
@RequestMapping("/home")
public class HomeAction {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
