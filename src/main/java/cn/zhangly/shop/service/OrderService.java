package cn.zhangly.shop.service;

import cn.zhangly.shop.model.Order;

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

}
