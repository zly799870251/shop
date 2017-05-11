package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Images;
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
public class ImagesServiceImpl extends BaseDao implements ImagesService {
    @Override
    public List<Images> findAll() {
        return imagesMapper.selectAll();
    }

    @Override
    public Images findById(Long id) {
        return imagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Images images) {
        imagesMapper.insert(images);
    }

    @Override
    public void update(Images images) {
        imagesMapper.updateByPrimaryKey(images);
    }

    @Override
    public void delete(Long id) {
        imagesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Images> findByCommodityId(Long commodityId) {
        Example example = new Example(Images.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commodityId", commodityId);
        example.or(criteria);
        return imagesMapper.selectByExample(example);
    }

}
