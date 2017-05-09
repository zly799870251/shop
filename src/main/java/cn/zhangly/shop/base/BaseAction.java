package cn.zhangly.shop.base;

import cn.zhangly.shop.service.ClassificationService;
import cn.zhangly.shop.service.CommodityService;
import cn.zhangly.shop.service.OrderService;
import cn.zhangly.shop.service.UserService;

import javax.annotation.Resource;

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
}
