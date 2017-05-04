package cn.zhangly.shop.base;

import java.util.List;

/**
 * Created by zhangly on 2017/5/4.
 */
public interface BaseService<T> {

    List<T> findAll();

    T findById(Long id);

    void save(T entity);

    void update(T entity);

    void delete(Long id);

}
