package cn.zhangly.shop.base;

import cn.zhangly.shop.mapper.*;

import javax.annotation.Resource;

/**
 * Created by 青葉 on 2017/4/26.
 */
public class BaseDao {

    @Resource
    protected AdminUserMapper adminUserMapper;
    @Resource
    protected ClassificationMapper classificationMapper;
    @Resource
    protected CommodityMapper commodityMapper;
    @Resource
    protected OrderCommodityMapper orderCommodityMapper;
    @Resource
    protected OrderMapper orderMapper;
    @Resource
    protected UserMapper userMapper;

}
