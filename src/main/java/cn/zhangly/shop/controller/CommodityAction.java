package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Commodity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangly on 2017/5/8.
 */
@Controller
@Scope("prototype")
@RequestMapping("/commodity")
public class CommodityAction extends BaseAction {

    @RequestMapping("/details")
    public String viewDetails(HttpServletRequest request, Long id) {
        Commodity commodity = commodityService.findById(id);
        request.setAttribute("commodity", commodity);
        return "details";
    }

}
