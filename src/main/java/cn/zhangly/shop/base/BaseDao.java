package cn.zhangly.shop.base;

import cn.zhangly.shop.mapper.*;
import org.activiti.engine.*;

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
    @Resource
    protected ImagesMapper imagesMapper;
    @Resource
    protected IntroducesMapper introducesMapper;
    @Resource
    protected CommtagMapper commtagMapper;

    // activiti相关Service
    @Resource
    protected ProcessEngine processEngine;
    @Resource
    protected FormService formService;
    @Resource
    protected HistoryService historyService;
    @Resource
    protected IdentityService identityService;
    @Resource
    protected ManagementService managementService;
    @Resource
    protected RepositoryService repositoryService;
    @Resource
    protected RuntimeService runtimeService;
    @Resource
    protected TaskService taskService;

}
