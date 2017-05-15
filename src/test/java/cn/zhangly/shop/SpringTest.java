package cn.zhangly.shop;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.mapper.*;
import cn.zhangly.shop.model.*;
import cn.zhangly.shop.service.*;
import com.github.pagehelper.PageHelper;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Created by 青葉 on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SpringTest {

    @Resource
    private ProcessEngine processEngine;

    // 部署流程定义
    @Test
    public void deploymentProcessDefinition() {
        Deployment order = processEngine.getRepositoryService().createDeployment()
                .name("order")
                .addClasspathResource("processfile/order.bpmn")
                .deploy();
        System.out.println("Id=" + order.getId());
        System.out.println("Name=" + order.getName());
        System.out.println("流程定义已部署完毕！");
    }

    // 启动流程实例
    @Test
    public void startProcessInster(){
        ProcessInstance order = processEngine.getRuntimeService()
                .startProcessInstanceByKey("order");
        System.out.println("DeploymentId= " + order.getDeploymentId());
        System.out.println("Name= " + order.getName());
    }

    public void test(){
    }

    // 删除流程定义
    @Test
    public void deleteProcessDefinition(){
        processEngine.getRepositoryService().deleteDeployment("1");
        System.out.println("流程定义已删除！");
    }

}
