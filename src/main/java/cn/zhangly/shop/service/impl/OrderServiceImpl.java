package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.mapper.OrderCommodityMapper;
import cn.zhangly.shop.model.Commodity;
import cn.zhangly.shop.model.Order;
import cn.zhangly.shop.model.OrderCommodity;
import cn.zhangly.shop.model.PageBean;
import cn.zhangly.shop.service.CommodityService;
import cn.zhangly.shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class OrderServiceImpl extends BaseDao implements OrderService {

    @Resource
    private CommodityService commodityService;

    @Override
    public List<Order> findAll() {
        return assembleData(orderMapper.selectAll());
    }

    @Override
    public Order findById(Long id) {
        return assembleData(orderMapper.selectByPrimaryKey(id));
    }

    @Override
    public void save(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void delete(Long id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Order> findOrderByUser(Long userId) {
        // 获取用户订单列表
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", userId)
                .andEqualTo("state", "unpaid");
        example.or(criteria);
        example.orderBy("id").desc();
        List<Order> orders = orderMapper.selectByExample(example);
        System.out.println("orders=" + orders);
        return assembleData(orders);
    }

    @Override
    public Order assembleData(Order order) {
        // 注入订单项
        Example example1 = new Example(OrderCommodity.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("orderId", order.getId());
        example1.or(criteria1);
        example1.orderBy("id").desc();
        List<OrderCommodity> orderCommodities = orderCommodityMapper.selectByExample(example1);
        List<OrderCommodity> commodities = new ArrayList<OrderCommodity>();
        // 为订单项注入商品信息
        if (orderCommodities != null && orderCommodities.size() > 0) {
            for (OrderCommodity orderCommodity : orderCommodities) {
                Commodity commodity = commodityMapper.selectByPrimaryKey(orderCommodity.getCommodityId());
                commodity = commodityService.assembleData(commodity);
                if (commodity != null) orderCommodity.setCommodity(commodity);
                orderCommodity.setPrice(orderCommodity.getNumber() * commodity.getMallPrice());
                commodities.add(orderCommodity);
            }
        }
        order.setOrderItem(new HashSet<OrderCommodity>(commodities));
        double price = 0;
        for (OrderCommodity orderCommodity : commodities) {
            price += orderCommodity.getPrice();
        }
        order.setPrice(price);
        return order;
    }

    @Override
    public List<Order> assembleData(List<Order> orders) {
        List<Order> orderList = new ArrayList<Order>();
        if (orders != null && orders.size() > 0) {
            for (Order order : orders) {
                // 注入订单项
                Example example1 = new Example(OrderCommodity.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("orderId", order.getId());
                example1.or(criteria1);
                List<OrderCommodity> orderCommodities = orderCommodityMapper.selectByExample(example1);
                List<OrderCommodity> commodities = new ArrayList<OrderCommodity>();
                // 为订单项注入商品信息
                if (orderCommodities != null && orderCommodities.size() > 0) {
                    for (OrderCommodity orderCommodity : orderCommodities) {
                        Commodity commodity = commodityMapper.selectByPrimaryKey(orderCommodity.getCommodityId());
                        if (commodity != null) orderCommodity.setCommodity(commodityService.assembleData(commodity));
                        orderCommodity.setPrice(orderCommodity.getNumber() * commodity.getMallPrice());
                        commodities.add(orderCommodity);
                    }
                }
                order.setOrderItem(new HashSet<OrderCommodity>(commodities));
                double price = 0;
                for (OrderCommodity orderCommodity : commodities) {
                    price += orderCommodity.getPrice();
                }
                order.setPrice(price);
                orderList.add(order);
            }
        }
        return orderList;
    }

    @Override
    public void addOrderCommodity(OrderCommodity orderCommodity, Long userId) {
        List<Order> orderByUser = findOrderByUser(userId);
        if (orderByUser != null && orderByUser.size() > 0) {
            Order order = orderByUser.get(0);
            orderCommodity.setOrderId(order.getId());
        }
        orderCommodityMapper.insert(orderCommodity);
    }

}
