package cn.zhangly.shop.model;

/**
 * Created by 青葉 on 2017/4/21.
 */
public class Classification extends BaseEntity {

    private String name;
    private Classification parent;

    @Override
    public String toString() {
        return "Classification{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classification getParent() {
        return parent;
    }

    public void setParent(Classification parent) {
        this.parent = parent;
    }
}
