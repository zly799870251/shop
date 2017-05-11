package cn.zhangly.shop.service;

import cn.zhangly.shop.model.*;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface OrderService {

    List<Order> findAll();

    Order findById(Long id);

    void save(Order order);

    void update(Order order);

    void delete(Long id);

    List<Order> findOrderByUser(Long userId);

    Order assembleData(Order order);

    List<Order> assembleData(List<Order> orders);

    void addOrderCommodity(OrderCommodity orderCommodity, Long userId);
}
