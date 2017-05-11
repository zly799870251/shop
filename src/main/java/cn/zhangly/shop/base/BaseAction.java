package cn.zhangly.shop.base;

import cn.zhangly.shop.model.User;
import cn.zhangly.shop.service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 青葉 on 2017/4/26.
 */
public class BaseAction {

    @Resource
    protected ClassificationService classificationService;
    @Resource
    protected CommodityService commodityService;
    @Resource
    protected OrderService orderService;
    @Resource
    protected UserService userService;
    @Resource
    protected OrderCommodityService orderCommodityService;

    protected User getCurrentUser(HttpServletRequest request){
        return  (User) request.getSession().getAttribute("user");
    }

}
