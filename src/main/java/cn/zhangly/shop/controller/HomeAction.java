package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Classification;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 青葉 on 2017/4/25.
 */
@Controller
@Scope("prototype")
@RequestMapping("/home")
public class HomeAction extends BaseAction {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        return "index";
    }

}
