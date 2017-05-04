package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Commodity;
import cn.zhangly.shop.service.CommodityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class CommodityServiceImpl extends BaseDao implements CommodityService {
    @Override
    public List<Commodity> findAll() {
        return commodityMapper.selectAll();
    }

    @Override
    public Commodity findById(Long id) {
        return commodityMapper.selectByPrimaryKey(id);
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

}
