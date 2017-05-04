package cn.zhangly.shop.base;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
