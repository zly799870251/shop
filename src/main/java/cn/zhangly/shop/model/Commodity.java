package cn.zhangly.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Entity
@Table(name = "commodity")
public class Commodity extends BaseEntity {

    private String name;
    @Column(name = "mallPrice")
    private double mallPrice;
    @Column(name = "markPrice")
    private double markPrice;
    private String description;
    private String image;
    @Column(name = "classId")
    private Long classId;

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", mallPrice=" + mallPrice +
                ", markPrice=" + markPrice +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", classId=" + classId +
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}