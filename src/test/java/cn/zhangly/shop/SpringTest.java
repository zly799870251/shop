package cn.zhangly.shop;

import cn.zhangly.shop.mapper.UserMapper;
import cn.zhangly.shop.model.User;
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
    private UserMapper userMapper;

    @Test
    public void test(){
        for (User user : userMapper.selectAll()) System.out.println(user);
    }

}
