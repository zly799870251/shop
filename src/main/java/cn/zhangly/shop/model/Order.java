package cn.zhangly.shop.model;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by 青葉 on 2017/4/21.
 */
public class Order extends BaseEntity {

    @Column(name = "createTime")
    private Date createTime;
    private Double price;
    private String state;
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String consignee; // 收货人

    @ManyToOne(targetEntity = User.class)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}