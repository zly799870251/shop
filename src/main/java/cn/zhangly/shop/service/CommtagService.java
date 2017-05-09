package cn.zhangly.shop.service;

import cn.zhangly.shop.model.Commtag;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface CommtagService {

    List<Commtag> findAll();

    Commtag findById(Long id);

    void save(Commtag commtag);

    void update(Commtag commtag);

    void delete(Long id);

}
