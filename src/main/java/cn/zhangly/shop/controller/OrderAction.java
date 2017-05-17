package cn.zhangly.shop.controller;

import cn.zhangly.shop.base.BaseAction;
import cn.zhangly.shop.model.Order;
import cn.zhangly.shop.model.User;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangly on 2017/5/16.
 */
@Controller
@Scope("prototype")
@RequestMapping("/order")
public class OrderAction extends BaseAction {

    // 查看我的订单
    @RequestMapping("/findMyOrder")
    public String findMyOrder(HttpServletRequest request) {
        if (getCurrentUser(request) == null) return "index";
        User user = getCurrentUser(request);
        List<Order> orderList = orderService.findAllOrderByUser(user.getId());
        request.setAttribute("orderList", orderList);
        return "myorder";
    }

    // 提交订单
    @RequestMapping("/submitorder")
    public String submitOrder(HttpServletRequest request, Long orderId) {

        Order byId = orderService.findById(orderId);
        byId.setCreateTime(new Date());
        byId.setState("pending");

        // 更改订单状态
        orderService.update(byId);

        // 启动流程实例并执行提交订单
        Map<String, Object> param = new HashMap<>();
        param.put("orderId", byId.getId());
        param.put("userId", getCurrentUser(request).getId());

        // 启动订单流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("order", param);

        // 查询到该流程的提交订单任务并完成
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .taskAssignee(getCurrentUser(request).getId().toString())
                .singleResult();
        taskService.complete(task.getId());

        // 将信息推送到页面
        request.setAttribute("order", byId);
        request.setAttribute("processInstanceId", processInstance.getId());

        return "order";

    }

    @RequestMapping("/order_payOrder")
    public String orderPayOrder(HttpServletRequest request, Long orderId, String consignee, String address, String phoneNumber, String processInstanceId) {
        if (processInstanceId != null) {
            Task task = taskService.createTaskQuery()
                    .taskAssignee(getCurrentUser(request).getId().toString())
                    .processInstanceId(processInstanceId)
                    .orderByTaskCreateTime().asc()
                    .singleResult();
            System.out.println(task.getAssignee());
            orderId = (Long) taskService.getVariable(task.getId(), "orderId");
            Order order = orderService.findById(orderId);

            // 改变订单状态
            order.setState("already");
            orderService.update(order);
            // 完成任务
            taskService.complete(task.getId());

            request.setAttribute("message", "您的包裹正在加紧发货中，请耐心等待！");
            return "message";
        } else if (orderId != null) {
            Order order = orderService.findById(orderId);
            Task task = taskService.createTaskQuery()
                    .taskAssignee(getCurrentUser(request).getId().toString())
                    .processVariableValueEquals("orderId", orderId)
                    .orderByTaskCreateTime().asc()
                    .singleResult();

            // 改变订单状态
            order.setState("already");
            orderService.update(order);
            // 完成任务
            taskService.complete(task.getId());

            request.setAttribute("message", "您的包裹正在加紧发货中，请耐心等待！");
            return "message";
        }

        return "index";
    }

    // 确认收货
    @RequestMapping("/confirmReceipt")
    public String confirmReceipt(HttpServletRequest request, Long orderId) {
        Task task = taskService.createTaskQuery()
                .taskAssignee(getCurrentUser(request).getId().toString())
                .processVariableValueEquals("orderId", orderId)
                .orderByTaskCreateTime().asc()
                .singleResult();

        // 收货
        taskService.complete(task.getId());

        // 更改状态
        Order byId = orderService.findById(orderId);
        byId.setState("completed");
        orderService.update(byId);

        return findMyOrder(request);
    }

    @RequestMapping("/doPayUI")
    public String doPayUI(HttpServletRequest request,Long orderId){
        if (getCurrentUser(request) == null) return "index";
        Order order = orderService.findById(orderId);
        request.setAttribute("order", order);
        return "order";
    }

}
