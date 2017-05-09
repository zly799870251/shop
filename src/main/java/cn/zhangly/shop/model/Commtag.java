package cn.zhangly.shop.model;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by zhangly on 2017/5/9.
 */
@Table(name = "commtag")
public class Commtag extends BaseEntity {

    private String title;
    private String tagcolor;
    @Column(name = "commodityId")
    private Long commodityId;

    @Override
    public String toString() {
        return "Commtag{" +
                "title='" + title + '\'' +
                ", tagcolor='" + tagcolor + '\'' +
                ", commodityId=" + commodityId +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagcolor() {
        return tagcolor;
    }

    public void setTagcolor(String tagcolor) {
        this.tagcolor = tagcolor;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }
}
