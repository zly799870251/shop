package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.*;
import cn.zhangly.shop.service.CommodityService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        commodityMapper.updateByPrimaryKey(commodity);
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

    @Override
    public PageBean<Commodity> getCommodity(int pageNum, int pageSize, Long classId) {
        if (pageNum != 0 && pageSize != 0 && classId != null) {
            Set<Commodity> commoditySet = new HashSet<Commodity>();

            // 查询对象
            Classification byId = classificationMapper.selectByPrimaryKey(classId);

            // 添加本级条件
            Example example = new Example(Commodity.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("classId", classId);
            example.or(criteria);

            // 添加子级条件
            if (byId != null && byId.getChildren() != null && byId.getChildren().size() > 0) {
                for (Classification classification : byId.getChildren()) {
                    Example.Criteria criteria1 = example.createCriteria();
                    criteria1.andEqualTo("classId", classification.getId());
                    example.or(criteria1);
                }
            }

            int count = commodityMapper.selectCountByExample(example);

            // 分页并查询
            PageHelper.startPage(pageNum, pageSize);
            List<Commodity> commodityList = commodityMapper.selectByExample(example);

            commoditySet.addAll(commodityList);
            List<Commodity> commodities = assembleData(new ArrayList<Commodity>(commoditySet));
            return new PageBean<Commodity>(commodities, pageNum, pageSize, count);
        }
        return null;
    }

    @Override
    public Commodity assembleData(Commodity commodity) {
        if (commodity != null) {
            // 注入缩略图集信息
            Example example = new Example(Images.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("commodityId", commodity.getId());
            example.or(criteria);
            List<Images> images = imagesMapper.selectByExample(example);
            if (images != null && images.size() > 0) commodity.setImages(new HashSet<Images>(images));

            // 注入介绍图集信息
            Example example1 = new Example(Introduces.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("commodityId", commodity.getId());
            example1.or(criteria1);
            List<Introduces> introduces = introducesMapper.selectByExample(example);
            if (introduces != null && introduces.size() > 0)
                commodity.setIntroduces(new HashSet<Introduces>(introduces));

            // 注入商品标签集合信息
            Example example2 = new Example(Commtag.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("commodityId", commodity.getId());
            example2.or(criteria2);
            List<Commtag> commtags = commtagMapper.selectByExample(example2);
            if (commtags != null && commtags.size() > 0) commodity.setCommtags(new HashSet<Commtag>(commtags));

            return commodity;
        } else {
            return null;
        }
    }

    @Override
    public List<Commodity> assembleData(List<Commodity> commodityList) {
        List<Commodity> returnlist = new ArrayList<Commodity>();
        if (commodityList != null && commodityList.size() > 0) {
            for (Commodity commodity : commodityList) {
                // 注入缩略图集信息
                Example example = new Example(Images.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("commodityId", commodity.getId());
                example.or(criteria);
                List<Images> images = imagesMapper.selectByExample(example);
                if (images != null && images.size() > 0) commodity.setImages(new HashSet<Images>(images));

                // 注入介绍图集信息
                Example example1 = new Example(Introduces.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("commodityId", commodity.getId());
                example1.or(criteria1);
                List<Introduces> introduces = introducesMapper.selectByExample(example1);
                if (introduces != null && introduces.size() > 0)
                    commodity.setIntroduces(new HashSet<Introduces>(introduces));

                // 注入商品标签集合信息
                Example example2 = new Example(Commtag.class);
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("commodityId", commodity.getId());
                example2.or(criteria2);
                List<Commtag> commtags = commtagMapper.selectByExample(example2);
                if (commtags != null && commtags.size() > 0) commodity.setCommtags(new HashSet<Commtag>(commtags));

                returnlist.add(commodity);
            }
        }
        return returnlist;
    }

}
