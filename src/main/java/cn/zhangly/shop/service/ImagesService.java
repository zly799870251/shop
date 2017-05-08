package cn.zhangly.shop.service;

import cn.zhangly.shop.model.Images;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface ImagesService {

    List<Images> findAll();

    Images findById(Long id);

    void save(Images images);

    void update(Images images);

    void delete(Long id);

    List<Images> findByCommodityId(Long commodityId);
}
