package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.service.ActivitiService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by zhangly on 2017/5/15.
 */
@Service
@Transactional
public class ActivitiServiceImpl extends BaseDao implements ActivitiService {
    @Override
    public void deploymentProcessDefinition(String path) throws FileNotFoundException {
        repositoryService.createDeployment()
                .name(path)
                .addClasspathResource(path)
                .deploy();
        System.out.println("流程实例已部署完成！");
    }

    @Override
    public ProcessInstance startProcessInstance(Map<String, Object> param) {
        return runtimeService.startProcessInstanceByKey("order");
    }

    @Override
    public void completeTask(String taskId) {
        taskService.complete(taskId);
    }

    @Override
    public void deleteProcessInstance(String processInstanceId) {
        runtimeService.deleteProcessInstance(processInstanceId,"");
    }
}
