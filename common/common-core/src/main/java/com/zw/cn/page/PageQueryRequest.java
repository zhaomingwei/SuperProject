package com.zw.cn.page;

/**
 * 支持分页查询
 *
 * @author ZhaoWei
 * @date 2020/5/28 16:39 上午
 */
public class PageQueryRequest<T> extends BaseQuery<T> {

    /**
     * 默认页面大小
     */
    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 默认页号
     */
    private static final int DEFAULT_PAGE_INDEX = 1;

    /**
     * 页面大小最大值
     */
    public static final int MAX_PAGE_SIZE = 500;

    /**
     * 初始化大小
     */
    private int page = DEFAULT_PAGE_INDEX;

    /**
     * 默认初始化大小
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    private boolean queryCount = true; // 是否查询总记录数

    /**
     * 页面偏移量
     */
    private int skip;

    public int getPage() {
        return this.page <= 0 ? DEFAULT_PAGE_INDEX : this.page;
    }

    public void setPage(int page) {
        this.page = page <= 0 ? DEFAULT_PAGE_INDEX : page;
    }

    public int getPageSize() {
        return this.pageSize > 0 && this.pageSize <= MAX_PAGE_SIZE ? this.pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int getStartPos() {
        return (this.getPage() - 1) * this.getPageSize();
    }

    public boolean isQueryCount() {
        return queryCount;
    }

    public void setQueryCount(boolean queryCount) {
        this.queryCount = queryCount;
    }

    public boolean getQueryCount() {
        return this.queryCount;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }
}
