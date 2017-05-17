package cn.zhangly.shop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(name = "createTime")
    private Date createTime;
    private Double price = 0.00;
    private String state;
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String consignee; // 收货人
    @Column(name = "userId")
    private Long userId;

    @Transient
    private Set<OrderCommodity> orderItem;
    @Transient
    private User user;

    @Override
    public String toString() {
        return "Order{" +
                "createTime=" + createTime +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", consignee='" + consignee + '\'' +
                ", userId=" + userId +
                ", orderItem=" + orderItem +
                ", user=" + user +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<OrderCommodity> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderCommodity> orderItem) {
        this.orderItem = orderItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}