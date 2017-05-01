package cn.zhangly.shop.base;

import cn.zhangly.shop.service.UserService;

import javax.annotation.Resource;

/**
 * Created by 青葉 on 2017/4/26.
 */
public class BaseAction {

    @Resource
    protected UserService userService;

}
