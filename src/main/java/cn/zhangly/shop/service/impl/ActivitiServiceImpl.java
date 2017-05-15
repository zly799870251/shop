package cn.zhangly.shop.service.impl;

import cn.zhangly.shop.base.BaseDao;
import cn.zhangly.shop.service.ActivitiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhangly on 2017/5/15.
 */
@Service
@Transactional
public class ActivitiServiceImpl extends BaseDao implements ActivitiService {
    @Override
    public void deploymentProcessDefinition(String processName) {
    }
}
