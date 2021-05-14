package com.zw.cn.page;

import com.zw.cn.base.BaseResult;
import com.zw.cn.base.ResultEnum;
import com.zw.cn.exception.BaseExceptionCode;
import com.zw.cn.exception.ServiceException;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 分页查询的时候使用 PageQueryResponse
 *
 *
 * @author ZhaoWei
 * @date 2020/5/28 16:39 上午
 */
public class PageQueryResponse<T> extends BaseResult<List<T>> {

    private static final long serialVersionUID = -8937008601803151631L;
    /**
     * 页号（页码）
     */
    private int pageIndex;

    /**
     * 总记录数
     */
    private int total;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 设置成功的分页查询结果(非静态方法)
     *
     * @param result
     *            业务数据
     * @param pageIndex
     *            页号
     * @param total
     *            总记录数
     * @param pageSize
     *            页面大小
     * @return
     */
    public PageQueryResponse<T> successPage(List<T> result, int pageIndex, int total, int pageSize) {
        this.setCode(ResultEnum.OK.getCode());
        this.setSuccess(true);
        this.setResult(CollectionUtils.isEmpty(result) ? Collections.EMPTY_LIST : result);
        this.setPageIndex(pageIndex);
        this.setTotal(total);
        this.setPageSize(pageSize);
        return this;
    }

    /**
     * 创建成功的分页结果静态方法
     *
     * @param model
     *            业务参数
     * @param <T>
     * @return
     */
    public static <T> PageQueryResponse<T> createSuccessResult(List<T> model) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        return (PageQueryResponse<T>)rt.successResult(CollectionUtils.isEmpty(model) ? Collections.EMPTY_LIST : model);
    }

    /**
     * 创建成功的分页结果静态方法
     *
     * @param model
     *            业务参数
     * @param pageIndex
     *            页号
     * @param total
     *            总记录数
     * @param pageSize
     *            页面大小
     * @param <T>
     * @return
     */
    public static <T> PageQueryResponse<T> createSuccessResult(List<T> model, int pageIndex, int total, int pageSize) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        return rt.successPage(CollectionUtils.isEmpty(model) ? Collections.EMPTY_LIST : model, pageIndex, total,
            pageSize);
    }

    /**
     * 创建成功的分页结果静态方法
     *
     * @param model
     *            业务参数
     * @param total
     *            总记录数
     * @param <T>
     * @return
     */
    public static <T> PageQueryResponse<T> createSuccessResult(List<T> model, int total) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        return rt.successPage(CollectionUtils.isEmpty(model) ? Collections.EMPTY_LIST : model, 0, total, 0);
    }

    /**
     * 创建失败的分页结果静态方法
     *
     * @param model
     * @param errorCode
     *            错误码
     * @param errorMsg
     * @param <T>
     * @return
     */
    public static <T> PageQueryResponse<T> createPageFailResult(List<T> model, BaseExceptionCode errorCode,
        String errorMsg) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        rt.setResult(CollectionUtils.isEmpty(model) ? Collections.EMPTY_LIST : model);
        rt.fail(errorCode, errorMsg);
        return rt;
    }

    /**
     * 创建失败的分页结果静态方法
     *
     * @param errorCode
     *            错误码
     * @param isRetry
     *            是否重试
     * @return
     */
    public static <T> PageQueryResponse<T> createPageFailResult(BaseExceptionCode errorCode, boolean isRetry) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        return (PageQueryResponse<T>)rt.fail(errorCode);
    }

    public static <T> PageQueryResponse<T> createPageFailResult(BaseExceptionCode errorCode) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        return (PageQueryResponse<T>)rt.fail(errorCode);
    }

    public static <T> PageQueryResponse<T> createPageFailResult(ServiceException serviceException) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        return (PageQueryResponse<T>)rt.failException(serviceException);
    }

    /**
     * 创建失败的分页结果静态方法
     *
     * @param errorCode
     *            错误码
     * @param isRetry
     *            是否重试
     * @return
     */
    public static <T> PageQueryResponse<T> createPageFailResult(BaseExceptionCode errorCode, String errorMsg,
        boolean isRetry) {
        PageQueryResponse<T> rt = new PageQueryResponse<T>();
        rt.setResult(null);
        return (PageQueryResponse<T>)rt.fail(errorCode, errorMsg);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return Math.max(pageIndex, 1);
    }

    public boolean hasNext() {
        int useCount = (getCurrentPage() - 1) * getPageSize() + getSize();
        return total > useCount;
    }

    public int getTotalPage() {
        if (pageSize == 0) {
            return 0;
        }
        return ((total - 1) / pageSize) + 1;
    }

    private int getSize() {
        List<T> page = getResult();
        if (page == null) {
            return 0;
        } else {
            return page.size();
        }
    }

}
