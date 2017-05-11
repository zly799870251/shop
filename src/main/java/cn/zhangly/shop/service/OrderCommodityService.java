package cn.zhangly.shop.service;

import cn.zhangly.shop.model.OrderCommodity;

import java.util.List;

/**
 * Created by zhangly on 2017/5/11.
 */
public interface OrderCommodityService {

    List<OrderCommodity> findAll();

    OrderCommodity findById(Long id);

    void save(OrderCommodity orderCommodity);

    void update(OrderCommodity orderCommodity);

    void delete(Long id);

    void deleteByOrderId(Long orderId);

    OrderCommodity assembleDate(OrderCommodity orderCommodity);

    List<OrderCommodity> assembleDate(List<OrderCommodity> orderCommodities);
}
