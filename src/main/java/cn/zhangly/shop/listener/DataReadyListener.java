package cn.zhangly.shop.listener;

import cn.zhangly.shop.model.Classification;
import cn.zhangly.shop.service.ClassificationService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
@Component("dataReadyListener")
public class DataReadyListener implements ApplicationListener<ContextRefreshedEvent>,ServletContextAware {

    @Resource
    private ClassificationService classificationService;

    private ServletContext servletContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("执行DataReadyListener监听器！");

        // 初始化顶级菜单数据
        List<Classification> topList = classificationService.findTop();
        servletContext.setAttribute("topClassificationList", topList);

        System.out.println("顶级菜单数据初始化完毕");
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
