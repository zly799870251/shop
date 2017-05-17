package cn.zhangly.shop.base;

import cn.zhangly.shop.model.User;
import cn.zhangly.shop.service.*;
import org.activiti.engine.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 青葉 on 2017/4/26.
 */
public class BaseAction {

    @Resource
    protected ClassificationService classificationService;
    @Resource
    protected CommodityService commodityService;
    @Resource
    protected OrderService orderService;
    @Resource
    protected UserService userService;
    @Resource
    protected OrderCommodityService orderCommodityService;

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

    protected User getCurrentUser(HttpServletRequest request){
        return  (User) request.getSession().getAttribute("user");
    }

}
