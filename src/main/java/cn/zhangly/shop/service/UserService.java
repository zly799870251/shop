package cn.zhangly.shop.service;

import cn.zhangly.shop.model.User;

import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);

    int usernameValidate(String username);

    User login(String username, String password);
}
