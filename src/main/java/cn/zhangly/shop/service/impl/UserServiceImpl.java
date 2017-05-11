package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.User;
import cn.zhangly.shop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseDao implements UserService {
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int usernameValidate(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        example.or(criteria);
        return userMapper.selectCountByExample(example);
    }

    @Override
    public User login(String username, String password) {
        Example example1 = new Example(User.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("username", username);
        criteria1.andEqualTo("password", password);
        example1.or(criteria1);
        List<User> users1 = userMapper.selectByExample(example1);
        Example example2 = new Example(User.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("email",username);
        criteria2.andEqualTo("password",password);
        example2.or(criteria2);
        List<User> users2 = userMapper.selectByExample(example2);
        if (users1.size() > 0){
            return users1.get(0);
        }else if (users2.size() > 0){
            return users2.get(0);
        }else {
            return null;
        }
    }
}
