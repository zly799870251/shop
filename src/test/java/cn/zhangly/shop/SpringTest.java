package cn.zhangly.shop;

import cn.zhangly.shop.mapper.*;
import cn.zhangly.shop.model.*;
import cn.zhangly.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Created by 青葉 on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SpringTest {

    @Resource
    private UserService userService;

    @Test
    public void test(){
        System.out.println(userService.usernameValidate("wangwu"));
    }

}
