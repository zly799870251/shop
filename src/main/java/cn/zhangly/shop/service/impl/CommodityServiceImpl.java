package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Classification;
import cn.zhangly.shop.model.Commodity;
import cn.zhangly.shop.model.Images;
import cn.zhangly.shop.service.CommodityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class CommodityServiceImpl extends BaseDao implements CommodityService {
    @Override
    public List<Commodity> findAll() {
        return assembleData(commodityMapper.selectAll());
    }

    @Override
    public Commodity findById(Long id) {
        return assembleData(commodityMapper.selectByPrimaryKey(id));
    }

    @Override
    public void save(Commodity commodity) {
        commodityMapper.insert(commodity);
    }

    @Override
    public void update(Commodity commodity) {
        commodityMapper.updateByExample(commodity, commodity.getId());
    }

    @Override
    public void delete(Long id) {
        commodityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Commodity> findByClassId(Long classId) {
        Example example = new Example(Commodity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classId", classId);
        example.or(criteria);
        return assembleData(commodityMapper.selectByExample(example));
    }

    private Commodity assembleData(Commodity commodity) {
        Example example = new Example(Commodity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("commodityId", commodity.getId());
        example.or(criteria);
        List<Images> images = imagesMapper.selectByExample(example);
        if (images != null && images.size() > 0) commodity.setImages(new HashSet<Images>(images));
        return commodity;
    }

    private List<Commodity> assembleData(List<Commodity> commodityList) {
        List<Commodity> returnlist = new ArrayList<Commodity>();
        if (commodityList != null && commodityList.size() > 0) {
            for (Commodity commodity : commodityList) {
                Example example = new Example(Images.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("commodityId", commodity.getId());
                example.or(criteria);
                List<Images> images = imagesMapper.selectByExample(example);
                if (images != null && images.size() > 0) commodity.setImages(new HashSet<Images>(images));
                returnlist.add(commodity);
            }
        }
        return returnlist;
    }

}
