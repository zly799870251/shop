package cn.zhangly.shop.service;

import org.activiti.engine.runtime.ProcessInstance;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by zhangly on 2017/5/15.
 */
public interface ActivitiService {

    void deploymentProcessDefinition(String path) throws FileNotFoundException;

    ProcessInstance startProcessInstance(Map<String, Object> param);

    void completeTask(String taskId);

    void deleteProcessInstance(String processInstanceId);

}
