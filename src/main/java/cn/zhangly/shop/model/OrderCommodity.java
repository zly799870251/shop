package cn.zhangly.shop.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 青葉 on 2017/4/24.
 */
@Table(name = "order_commodity")
public class OrderCommodity extends BaseEntity {

    private int number;
    private double price;
    @Column(name = "orderId")
    private Long orderId;
    @Column(name = "commodityId")
    private Long commodityId;

    @Override
    public String toString() {
        return "OrderCommodity{" +
                "number=" + number +
                ", price=" + price +
                ", orderId=" + orderId +
                ", commodityId=" + commodityId +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
}
