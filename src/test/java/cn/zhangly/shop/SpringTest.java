package cn.zhangly.shop;

import cn.zhangly.shop.mapper.*;
import cn.zhangly.shop.model.*;
import cn.zhangly.shop.service.*;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 青葉 on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SpringTest {

    @Resource
    private OrderService service;

    @Test
    public void test(){
        List<Order> list = service.findOrderByUser(1L);
        for (Order entity : list) System.out.println(entity);
    }

}
