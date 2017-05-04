package cn.zhangly.shop.service;

import cn.zhangly.shop.model.Classification;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface ClassificationService {

    List<Classification> findAll();

    Classification findById(Long id);

    void save(Classification classification);

    void update(Classification classification);

    void delete(Long id);

    List<Classification> findTop();
}
