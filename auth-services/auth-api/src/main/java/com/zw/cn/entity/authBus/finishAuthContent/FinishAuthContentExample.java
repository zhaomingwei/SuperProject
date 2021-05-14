package com.zw.cn.entity.authBus.finishAuthContent;

import com.zw.cn.core.model.BaseExample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinishAuthContentExample extends BaseExample implements Serializable {
    /**
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    protected String orderByClause;

    /**
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    protected boolean distinct;

    /**
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    protected List<Criteria> oredCriteria;

    public FinishAuthContentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * FinishAuthContent<p/>
     * t_bcc_finish_auth_content
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("finishAuthContent.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("finishAuthContent.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("finishAuthContent.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("finishAuthContent.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("finishAuthContent.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("finishAuthContent.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("finishAuthContent.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("finishAuthContent.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("finishAuthContent.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("finishAuthContent.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("finishAuthContent.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("finishAuthContent.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("finishAuthContent.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("finishAuthContent.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("finishAuthContent.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("finishAuthContent.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("finishAuthContent.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("finishAuthContent.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("finishAuthContent.user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("finishAuthContent.user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("finishAuthContent.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("finishAuthContent.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("finishAuthContent.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNull() {
            addCriterion("finishAuthContent.apply_no is null");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNotNull() {
            addCriterion("finishAuthContent.apply_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNoEqualTo(String value) {
            addCriterion("finishAuthContent.apply_no =", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotEqualTo(String value) {
            addCriterion("finishAuthContent.apply_no <>", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThan(String value) {
            addCriterion("finishAuthContent.apply_no >", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.apply_no >=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThan(String value) {
            addCriterion("finishAuthContent.apply_no <", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.apply_no <=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLike(String value) {
            addCriterion("finishAuthContent.apply_no like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotLike(String value) {
            addCriterion("finishAuthContent.apply_no not like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoIn(List<String> values) {
            addCriterion("finishAuthContent.apply_no in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotIn(List<String> values) {
            addCriterion("finishAuthContent.apply_no not in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoBetween(String value1, String value2) {
            addCriterion("finishAuthContent.apply_no between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.apply_no not between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeIsNull() {
            addCriterion("finishAuthContent.auth_content_code is null");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeIsNotNull() {
            addCriterion("finishAuthContent.auth_content_code is not null");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeEqualTo(String value) {
            addCriterion("finishAuthContent.auth_content_code =", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeNotEqualTo(String value) {
            addCriterion("finishAuthContent.auth_content_code <>", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeGreaterThan(String value) {
            addCriterion("finishAuthContent.auth_content_code >", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.auth_content_code >=", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeLessThan(String value) {
            addCriterion("finishAuthContent.auth_content_code <", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.auth_content_code <=", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeLike(String value) {
            addCriterion("finishAuthContent.auth_content_code like", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeNotLike(String value) {
            addCriterion("finishAuthContent.auth_content_code not like", value, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeIn(List<String> values) {
            addCriterion("finishAuthContent.auth_content_code in", values, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeNotIn(List<String> values) {
            addCriterion("finishAuthContent.auth_content_code not in", values, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeBetween(String value1, String value2) {
            addCriterion("finishAuthContent.auth_content_code between", value1, value2, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthContentCodeNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.auth_content_code not between", value1, value2, "authContentCode");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkIsNull() {
            addCriterion("finishAuthContent.auth_file_link is null");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkIsNotNull() {
            addCriterion("finishAuthContent.auth_file_link is not null");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkEqualTo(String value) {
            addCriterion("finishAuthContent.auth_file_link =", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkNotEqualTo(String value) {
            addCriterion("finishAuthContent.auth_file_link <>", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkGreaterThan(String value) {
            addCriterion("finishAuthContent.auth_file_link >", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.auth_file_link >=", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkLessThan(String value) {
            addCriterion("finishAuthContent.auth_file_link <", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.auth_file_link <=", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkLike(String value) {
            addCriterion("finishAuthContent.auth_file_link like", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkNotLike(String value) {
            addCriterion("finishAuthContent.auth_file_link not like", value, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkIn(List<String> values) {
            addCriterion("finishAuthContent.auth_file_link in", values, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkNotIn(List<String> values) {
            addCriterion("finishAuthContent.auth_file_link not in", values, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkBetween(String value1, String value2) {
            addCriterion("finishAuthContent.auth_file_link between", value1, value2, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andAuthFileLinkNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.auth_file_link not between", value1, value2, "authFileLink");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("finishAuthContent.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("finishAuthContent.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("finishAuthContent.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("finishAuthContent.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("finishAuthContent.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("finishAuthContent.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("finishAuthContent.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("finishAuthContent.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("finishAuthContent.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("finishAuthContent.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("finishAuthContent.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIndateIsNull() {
            addCriterion("finishAuthContent.indate is null");
            return (Criteria) this;
        }

        public Criteria andIndateIsNotNull() {
            addCriterion("finishAuthContent.indate is not null");
            return (Criteria) this;
        }

        public Criteria andIndateEqualTo(Date value) {
            addCriterion("finishAuthContent.indate =", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateNotEqualTo(Date value) {
            addCriterion("finishAuthContent.indate <>", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateGreaterThan(Date value) {
            addCriterion("finishAuthContent.indate >", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateGreaterThanOrEqualTo(Date value) {
            addCriterion("finishAuthContent.indate >=", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateLessThan(Date value) {
            addCriterion("finishAuthContent.indate <", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateLessThanOrEqualTo(Date value) {
            addCriterion("finishAuthContent.indate <=", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateIn(List<Date> values) {
            addCriterion("finishAuthContent.indate in", values, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateNotIn(List<Date> values) {
            addCriterion("finishAuthContent.indate not in", values, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateBetween(Date value1, Date value2) {
            addCriterion("finishAuthContent.indate between", value1, value2, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateNotBetween(Date value1, Date value2) {
            addCriterion("finishAuthContent.indate not between", value1, value2, "indate");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("finishAuthContent.valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("finishAuthContent.valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("finishAuthContent.valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("finishAuthContent.valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("finishAuthContent.valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("finishAuthContent.valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("finishAuthContent.valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("finishAuthContent.valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("finishAuthContent.valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("finishAuthContent.valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("finishAuthContent.valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("finishAuthContent.valid not between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("finishAuthContent.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("finishAuthContent.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("finishAuthContent.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("finishAuthContent.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("finishAuthContent.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishAuthContent.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("finishAuthContent.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("finishAuthContent.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("finishAuthContent.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("finishAuthContent.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("finishAuthContent.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("finishAuthContent.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("finishAuthContent.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("finishAuthContent.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("finishAuthContent.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("finishAuthContent.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("finishAuthContent.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishAuthContent.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("finishAuthContent.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("finishAuthContent.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("finishAuthContent.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("finishAuthContent.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("finishAuthContent.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("finishAuthContent.update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("finishAuthContent.create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("finishAuthContent.create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("finishAuthContent.create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("finishAuthContent.create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("finishAuthContent.create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("finishAuthContent.create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("finishAuthContent.create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("finishAuthContent.create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("finishAuthContent.create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.create_user_name not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIsNull() {
            addCriterion("finishAuthContent.create_user_code is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIsNotNull() {
            addCriterion("finishAuthContent.create_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_code =", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_code <>", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThan(String value) {
            addCriterion("finishAuthContent.create_user_code >", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_code >=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThan(String value) {
            addCriterion("finishAuthContent.create_user_code <", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.create_user_code <=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLike(String value) {
            addCriterion("finishAuthContent.create_user_code like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotLike(String value) {
            addCriterion("finishAuthContent.create_user_code not like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIn(List<String> values) {
            addCriterion("finishAuthContent.create_user_code in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotIn(List<String> values) {
            addCriterion("finishAuthContent.create_user_code not in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeBetween(String value1, String value2) {
            addCriterion("finishAuthContent.create_user_code between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.create_user_code not between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("finishAuthContent.update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("finishAuthContent.update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("finishAuthContent.update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("finishAuthContent.update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("finishAuthContent.update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("finishAuthContent.update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("finishAuthContent.update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("finishAuthContent.update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("finishAuthContent.update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNull() {
            addCriterion("finishAuthContent.update_user_code is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNotNull() {
            addCriterion("finishAuthContent.update_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_code =", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_code <>", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThan(String value) {
            addCriterion("finishAuthContent.update_user_code >", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_code >=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThan(String value) {
            addCriterion("finishAuthContent.update_user_code <", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("finishAuthContent.update_user_code <=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLike(String value) {
            addCriterion("finishAuthContent.update_user_code like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotLike(String value) {
            addCriterion("finishAuthContent.update_user_code not like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIn(List<String> values) {
            addCriterion("finishAuthContent.update_user_code in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotIn(List<String> values) {
            addCriterion("finishAuthContent.update_user_code not in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeBetween(String value1, String value2) {
            addCriterion("finishAuthContent.update_user_code between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotBetween(String value1, String value2) {
            addCriterion("finishAuthContent.update_user_code not between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }
    }

    /**
     * finishAuthContent<p/>
     * t_bcc_finish_auth_content
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * FinishAuthContent<p/>
     * t_bcc_finish_auth_content
     * @date Thu Apr 29 09:35:59 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}