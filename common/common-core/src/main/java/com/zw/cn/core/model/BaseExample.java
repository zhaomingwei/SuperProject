package com.zw.cn.core.model;

/**
 * BaseExample 基类
 *
 * @author ZhaoWei
 * @ClassName BaseExample
 * @Description 增加分页参数
 * @date 2021-05-08 17:15:04
 */
public abstract class BaseExample {

    protected PageInfo pageInfo;

    protected String groupByClause;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = groupByClause;
    }

}
