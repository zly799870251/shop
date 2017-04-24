package cn.zhangly.shop.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Table(name = "commodity")
public class Commodity extends BaseEntity {

    private String name;
    @Column(name = "mallPrice")
    private Double mallPrice;
    @Column(name = "marketPrice")
    private Double marketPrice;
    private String describe;
    private String image;

    @JoinColumn(name = "classId", referencedColumnName = "id")//设置对应数据表的列名和引用的数据表的列名
    @ManyToOne(targetEntity = Classification.class)
    private Classification classification;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Collection<OrderCommodity> orderCommodities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMallPrice() {
        return mallPrice;
    }

    public void setMallPrice(Double mallPrice) {
        this.mallPrice = mallPrice;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Collection<OrderCommodity> getOrderCommodities() {
        return orderCommodities;
    }

    public void setOrderCommodities(Collection<OrderCommodity> orderCommodities) {
        this.orderCommodities = orderCommodities;
    }
}
