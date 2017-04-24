package cn.zhangly.shop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by 青葉 on 2017/4/21.
 */
@Table(name = "user")
public class User extends BaseEntity {

    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private Integer state;
    @Column(name = "activCode")
    private String activCode;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Collection<Order> orders;

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", state=" + state +
                ", activCode='" + activCode + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getActivCode() {
        return activCode;
    }

    public void setActivCode(String activCode) {
        this.activCode = activCode;
    }
}
