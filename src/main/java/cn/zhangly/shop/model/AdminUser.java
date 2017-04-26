package cn.zhangly.shop.model;

import javax.persistence.Table;

/**
 * Created by 青葉 on 2017/4/24.
 */
@Table(name = "adminuser")
public class AdminUser extends BaseEntity {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "AdminUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
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
}
