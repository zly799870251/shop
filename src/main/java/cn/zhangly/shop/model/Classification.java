package cn.zhangly.shop.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Table(name = "classification")
public class Classification extends BaseEntity {

    private String name;

    @JoinColumn(name = "parentId", referencedColumnName = "id")//设置对应数据表的列名和引用的数据表的列名
    @ManyToOne//设置在“一方”pojo的外键字段上
    private Classification parent;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Collection<Classification> children;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Collection<Commodity> commodities;

    @Override
    public String toString() {
        return "Classification{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", children=" + children +
                ", commodities=" + commodities +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classification getParent() {
        return parent;
    }

    public void setParent(Classification parent) {
        this.parent = parent;
    }

    public Collection<Classification> getChildren() {
        return children;
    }

    public void setChildren(Collection<Classification> children) {
        this.children = children;
    }

    public Collection<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(Collection<Commodity> commodities) {
        this.commodities = commodities;
    }
}
