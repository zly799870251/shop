package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Classification;
import cn.zhangly.shop.service.ClassificationService;
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
public class ClassificationServiceImpl extends BaseDao implements ClassificationService {
    @Override
    public List<Classification> findAll() {
        return assembleData(classificationMapper.selectAll());
    }

    @Override
    public Classification findById(Long id) {
        return assembleData(classificationMapper.selectByPrimaryKey(id));
    }

    @Override
    public void save(Classification classification) {
        classificationMapper.insert(classification);
    }

    @Override
    public void update(Classification classification) {
        classificationMapper.updateByExample(classification, classification.getId());
    }

    @Override
    public void delete(Long id) {
        classificationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Classification> findTop() {
        Example example = new Example(Classification.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIsNull("parentId");
        example.or(criteria);
        return assembleData(classificationMapper.selectByExample(example));
    }

    private List<Classification> assembleData(List<Classification> classificationList) {
        List<Classification> returnList = new ArrayList<Classification>();
        if (classificationList != null && classificationList.size() > 0) {
            for (Classification classification : classificationList) {
                Example example = new Example(Classification.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("parentId", classification.getId());
                example.or(criteria);
                List<Classification> list = classificationMapper.selectByExample(example);
                if (list != null && list.size() > 0) {
                    classification.setChildren(new HashSet<Classification>(list));
                }
                returnList.add(classification);
            }
        }
        return returnList;
    }

    private Classification assembleData(Classification classification) {
        if (classification != null) {
            Example example = new Example(Classification.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("parentId", classification.getId());
            example.or(criteria);
            List<Classification> list = classificationMapper.selectByExample(example);
            if (list != null && list.size() > 0) classification.setChildren(new HashSet<Classification>(list));
            return classification;
        }else {
            return null;
        }
    }

}
