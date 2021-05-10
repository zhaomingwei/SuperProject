package com.zw.cn.core.model;

/**
 * 排序信息
 *
 * @author ZhaoWei
 * @ClassName SortInfo
 * @Description
 * @date 2021-05-08 17:17:00
 */
public class SortInfo {
    /**
     * 排序列(字段)
     */
    private Byte sortCol;
    /**
     * 排序方向
     */
    private Byte sortDirect;

    /**
     * 排序列(字段)
     */
    public Byte getSortCol() {
        return sortCol;
    }

    /**
     * 排序列(字段)
     */
    public void setSortCol(Byte sortCol) {
        this.sortCol = sortCol;
    }

    /**
     * 排序方向
     */
    public Byte getSortDirect() {
        return sortDirect;
    }

    /**
     * 排序方向
     */
    public void setSortDirect(Byte sortDirect) {
        this.sortDirect = sortDirect;
    }
}

