package cn.zhangly.shop.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by 青葉 on 2017/4/24.
 */
@Table(name = "order_commodity")
public class OrderCommodity extends BaseEntity {

    private int number;
    private double price;

    @JoinColumn(name = "orderId",referencedColumnName = "id")
    @ManyToOne
    private Order order;

    @JoinColumn(name = "commodityId",referencedColumnName = "id")
    @ManyToOne
    private Commodity commodity;

    @Override
    public String toString() {
        return "OrderCommodity{" +
                "number=" + number +
                ", price=" + price +
                ", order=" + order +
                ", commodity=" + commodity +
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
