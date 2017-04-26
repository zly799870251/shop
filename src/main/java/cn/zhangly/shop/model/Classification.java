package cn.zhangly.shop.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Table(name = "classification")
public class Classification extends BaseEntity {

    private String name;
    @Column(name = "parentId")
    private Long parentId;

    @Override
    public String toString() {
        return "Classification{" +
                "name='" + name + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
