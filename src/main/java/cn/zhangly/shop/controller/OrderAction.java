package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by zhangly on 2017/5/16.
 */
@Controller
@Scope("prototype")
@RequestMapping("/order")
public class OrderAction extends BaseAction {

    @RequestMapping("/submitOrder")
    public String submitOrder(Long orderId,String consignee,String address,String phoneNumber){
        System.out.println("orderId= " + orderId);
        // 根据ID查询对应的订单信息
        Order order = orderService.findById(orderId);
        if (order != null){
            order.setCreateTime(new Date());
            order.setConsignee(consignee);
            order.setAddress(address);
            order.setPhoneNumber(phoneNumber);
            System.out.println(order);
        }
        return "shoppingCart";
    }

}
