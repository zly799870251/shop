package cn.zhangly.shop.model;

import javax.persistence.Column;

/**
 * Created by 青葉 on 2017/4/21.
 */
public class Commodity extends BaseEntity {

    private String name;
    @Column(name = "mallPrice")
    private Double mallPrice;
    @Column(name = "marketPrice")
    private Double marketPrice;
    private String describe;
    private String image;

    private Classification classification;

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
}
