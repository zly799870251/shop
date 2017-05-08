package cn.zhangly.shop.service;

import cn.zhangly.shop.model.Commodity;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface CommodityService {

    List<Commodity> findAll();

    Commodity findById(Long id);

    void save(Commodity commodity);

    void update(Commodity commodity);

    void delete(Long id);

    List<Commodity> findByClassId(Long classId);
}
