package cn.zhangly.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Table(name = "commodity")
public class Commodity extends BaseEntity {

    private String name;
    @Column(name = "mallPrice")
    private double mallPrice; /* 商品现价 */
    @Column(name = "markPrice")
    private double markPrice; /* 商品原价 */
    private String description;
    private Integer seecount; /* 查看数 */
    private Integer buycount; /* 购买数 */
    @Column(name = "classId")
    private Long classId;

    @Transient
    private Set<Images> images; /* 缩略图集 */
    @Transient
    private Set<Introduces> introduces; /* 介绍图集 */
    @Transient
    private Set<Commtag> commtags; /* 商品标签 */

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", mallPrice=" + mallPrice +
                ", markPrice=" + markPrice +
                ", description='" + description + '\'' +
                ", seecount=" + seecount +
                ", buycount=" + buycount +
                ", classId=" + classId +
                ", images=" + images +
                ", introduces=" + introduces +
                ", commtags=" + commtags +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMallPrice() {
        return mallPrice;
    }

    public void setMallPrice(double mallPrice) {
        this.mallPrice = mallPrice;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(double markPrice) {
        this.markPrice = markPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSeecount() {
        return seecount;
    }

    public void setSeecount(Integer seecount) {
        this.seecount = seecount;
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Set<Images> getImages() {
        return images;
    }

    public void setImages(Set<Images> images) {
        this.images = images;
    }

    public Set<Introduces> getIntroduces() {
        return introduces;
    }

    public void setIntroduces(Set<Introduces> introduces) {
        this.introduces = introduces;
    }

    public Set<Commtag> getCommtags() {
        return commtags;
    }

    public void setCommtags(Set<Commtag> commtags) {
        this.commtags = commtags;
    }
}
