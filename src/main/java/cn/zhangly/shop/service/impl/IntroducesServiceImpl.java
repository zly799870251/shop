package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.model.Introduces;
import cn.zhangly.shop.model.Order;
import cn.zhangly.shop.service.IntroducesService;
import cn.zhangly.shop.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 青葉 on 2017/4/26.
 */
@Service
@Transactional
public class IntroducesServiceImpl extends BaseDao implements IntroducesService {
    @Override
    public List<Introduces> findAll() {
        return introducesMapper.selectAll();
    }

    @Override
    public Introduces findById(Long id) {
        return introducesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(Introduces introduces) {
        introducesMapper.insert(introduces);
    }

    @Override
    public void update(Introduces introduces) {
        introducesMapper.updateByPrimaryKey(introduces);
    }

    @Override
    public void delete(Long id) {
        introducesMapper.deleteByPrimaryKey(id);
    }

}
