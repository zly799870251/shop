package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Commtag;
import cn.zhangly.shop.model.Images;
import cn.zhangly.shop.service.CommtagService;
import cn.zhangly.shop.service.ImagesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class CommtagServiceImpl extends BaseDao implements CommtagService {
    @Override
    public List<Commtag> findAll() {
        return commtagMapper.selectAll();
    }

    @Override
    public Commtag findById(Long id) {
        return commtagMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Commtag commtag) {
        commtagMapper.insert(commtag);
    }

    @Override
    public void update(Commtag commtag) {
        commtagMapper.updateByExample(commtag, commtag.getId());
    }

    @Override
    public void delete(Long id) {
        commtagMapper.deleteByPrimaryKey(id);
    }
}
