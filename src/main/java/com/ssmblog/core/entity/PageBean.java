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
    private int rows;

    private int start;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
