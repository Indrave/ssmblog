package com.ssmblog.core.entity;

/**
 * @author wangyj
 * @date 2018/3/18
 * @description
 */
public class PageBean {

    //页码
    private int page;

    //每页数量
    private int pageSize;

    private int start;

    public PageBean(int page, int pageSize) {
        super();
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (page - 1) * pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
