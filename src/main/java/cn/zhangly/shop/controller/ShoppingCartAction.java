package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.BaseEntity;
import cn.zhangly.shop.model.Order;
import cn.zhangly.shop.model.OrderCommodity;
import cn.zhangly.shop.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by zhangly on 2017/5/11.
 */
@Controller
@Scope("prototype")
@RequestMapping("/shoppingCart")
public class ShoppingCartAction extends BaseAction {

    @RequestMapping("/shoppingCart")
    public String shoppingCart(HttpServletRequest request) {
        if (getCurrentUser(request) == null) return "index";
        getStory(request);
        return "shoppingCart";
    }

    @RequestMapping("/addShoppingCart")
    @ResponseBody
    public String addShoppingCart(HttpServletRequest request, Long commodityId, int number) throws UnsupportedEncodingException {
        if(getCurrentUser(request) != null){
            OrderCommodity orderCommodity = new OrderCommodity();
            orderCommodity.setNumber(number);
            orderCommodity.setPrice(commodityService.findById(commodityId).getMallPrice() * number);
            orderCommodity.setCommodityId(commodityId);
            orderService.addOrderCommodity(orderCommodity,getCurrentUser(request).getId());
            return "";
        }else {
            return "error";
        }
    }

    @RequestMapping("/deleteShopingCart")
    public String deleteShopingCart(HttpServletRequest request, Long id) {
        if (id != null) orderCommodityService.delete(id);
        getStory(request);
        return "shoppingCart";
    }

    @RequestMapping("/clearShoppingCart")
    public String clearShoppingCart(HttpServletRequest request,Long orderId){
        orderCommodityService.deleteByOrderId(orderId);
        getStory(request);
        return "shoppingCart";
    }

    private void getStory(HttpServletRequest request) {
        User user = getCurrentUser(request);
        List<Order> orderList = orderService.findOrderByUser(user.getId());
        if (orderList != null && orderList.size() > 0) {
            request.setAttribute("order", orderList.get(0));
        }else {
            request.setAttribute("order",new Order());
        }
    }

}
