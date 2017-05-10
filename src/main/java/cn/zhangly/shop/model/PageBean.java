package cn.zhangly.shop.model;

import java.util.List;

/**
 * Created by zhangly on 2017/5/10.
 */
public class PageBean<T> {

    private List<T> recodeList;

    private int pageNum;

    private int pageSize;

    private int count;

    private int pageCount;

    public PageBean() {
    }

    public PageBean(List<T> recodeList, int pageNum, int pageSize, int count) {
        this.recodeList = recodeList;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        this.pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "recodeList=" + recodeList +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", pageCount=" + pageCount +
                '}';
    }

    public List<T> getRecodeList() {
        return recodeList;
    }

    public void setRecodeList(List<T> recodeList) {
        this.recodeList = recodeList;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
