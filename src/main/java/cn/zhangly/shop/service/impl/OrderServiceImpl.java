package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Order;
import cn.zhangly.shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class OrderServiceImpl extends BaseDao implements OrderService {
    @Override
    public List<Order> findAll() {
        return orderMapper.selectAll();
    }

    @Override
    public Order findById(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByExample(order, order.getId());
    }

    @Override
    public void delete(Long id) {
        orderMapper.deleteByPrimaryKey(id);
    }

}
