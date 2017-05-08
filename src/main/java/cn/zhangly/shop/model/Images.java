package cn.zhangly.shop.model;

import javax.persistence.Table;

/**
 * Created by zhangly on 2017/5/8.
 */
@Table(name = "images")
public class Images extends BaseEntity {

    private String path;
    private Long dependentId;

    @Override
    public String toString() {
        return "Images{" +
                "path='" + path + '\'' +
                ", dependentId=" + dependentId +
                '}';
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getDependentId() {
        return dependentId;
    }

    public void setDependentId(Long dependentId) {
        this.dependentId = dependentId;
    }
}
