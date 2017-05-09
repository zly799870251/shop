package cn.zhangly.shop.service;

import cn.zhangly.shop.model.Introduces;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface IntroducesService {

    List<Introduces> findAll();

    Introduces findById(Long id);

    void save(Introduces introduces);

    void update(Introduces introduces);

    void delete(Long id);

}
