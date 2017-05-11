package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Commodity;
import cn.zhangly.shop.model.OrderCommodity;
import cn.zhangly.shop.service.CommodityService;
import cn.zhangly.shop.service.OrderCommodityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangly on 2017/5/11.
 */
@Service
@Transactional
public class OrderCommodityServiceImpl extends BaseDao implements OrderCommodityService {

    @Resource
    private CommodityService commodityService;

    @Override
    public List<OrderCommodity> findAll() {
        return assembleDate(orderCommodityMapper.selectAll());
    }

    @Override
    public OrderCommodity findById(Long id) {
        return assembleDate(orderCommodityMapper.selectByPrimaryKey(id));
    }

    @Override
    public void save(OrderCommodity orderCommodity) {
        orderCommodityMapper.insert(orderCommodity);
    }

    @Override
    public void update(OrderCommodity orderCommodity) {
        orderCommodityMapper.updateByPrimaryKey(orderCommodity);
    }

    @Override
    public void delete(Long id) {
        orderCommodityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        Example example = new Example(OrderCommodity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orderId",orderId);
        example.or(criteria);
        orderCommodityMapper.deleteByExample(example);
    }

    @Override
    public OrderCommodity assembleDate(OrderCommodity orderCommodity){
        // 为订单项注入商品信息
        if (orderCommodity != null) {
            Commodity commodity = commodityMapper.selectByPrimaryKey(orderCommodity.getCommodityId());
            Commodity commodity1 = commodityService.assembleData(commodity);
            if (commodity != null) orderCommodity.setCommodity(commodity1);
            orderCommodity.setPrice(orderCommodity.getNumber() * commodity1.getMallPrice());
        }
        return orderCommodity;
    }

    @Override
    public List<OrderCommodity> assembleDate(List<OrderCommodity> orderCommodities){
        List<OrderCommodity> orderCommodityList = new ArrayList<OrderCommodity>();
        // 为订单项注入商品信息
        if (orderCommodities != null && orderCommodities.size() > 0) {
            for (OrderCommodity orderCommodity : orderCommodities) {
                Commodity commodity = commodityMapper.selectByPrimaryKey(orderCommodity.getCommodityId());
                Commodity commodity1 = commodityService.assembleData(commodity);
                if (commodity != null) orderCommodity.setCommodity(commodity1);
                orderCommodity.setPrice(orderCommodity.getNumber() * commodity1.getMallPrice());
                orderCommodityList.add(orderCommodity);
            }
        }
        return orderCommodityList;
    }
}
