package com.zw.cn.entity.authBus.authApplyForm;

import com.zw.cn.core.model.BaseExample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class AuthApplyFormExample extends BaseExample implements Serializable {
    /**
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    protected String orderByClause;

    /**
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    protected boolean distinct;

    /**
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    protected List<Criteria> oredCriteria;

    public AuthApplyFormExample() {
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
     * AuthApplyForm<p/>
     * t_bcc_auth_apply_form
     * @date Thu Apr 29 16:48:04 CST 2021
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
            addCriterion("authApplyForm.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("authApplyForm.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("authApplyForm.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("authApplyForm.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("authApplyForm.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("authApplyForm.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("authApplyForm.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("authApplyForm.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("authApplyForm.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("authApplyForm.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("authApplyForm.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("authApplyForm.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("authApplyForm.user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("authApplyForm.user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("authApplyForm.user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("authApplyForm.user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("authApplyForm.user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("authApplyForm.user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("authApplyForm.user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("authApplyForm.user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("authApplyForm.user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("authApplyForm.user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("authApplyForm.user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNull() {
            addCriterion("authApplyForm.apply_no is null");
            return (Criteria) this;
        }

        public Criteria andApplyNoIsNotNull() {
            addCriterion("authApplyForm.apply_no is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNoEqualTo(String value) {
            addCriterion("authApplyForm.apply_no =", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotEqualTo(String value) {
            addCriterion("authApplyForm.apply_no <>", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThan(String value) {
            addCriterion("authApplyForm.apply_no >", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.apply_no >=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThan(String value) {
            addCriterion("authApplyForm.apply_no <", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.apply_no <=", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoLike(String value) {
            addCriterion("authApplyForm.apply_no like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotLike(String value) {
            addCriterion("authApplyForm.apply_no not like", value, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoIn(List<String> values) {
            addCriterion("authApplyForm.apply_no in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotIn(List<String> values) {
            addCriterion("authApplyForm.apply_no not in", values, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoBetween(String value1, String value2) {
            addCriterion("authApplyForm.apply_no between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andApplyNoNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.apply_no not between", value1, value2, "applyNo");
            return (Criteria) this;
        }

        public Criteria andBusCodeIsNull() {
            addCriterion("authApplyForm.bus_code is null");
            return (Criteria) this;
        }

        public Criteria andBusCodeIsNotNull() {
            addCriterion("authApplyForm.bus_code is not null");
            return (Criteria) this;
        }

        public Criteria andBusCodeEqualTo(String value) {
            addCriterion("authApplyForm.bus_code =", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeNotEqualTo(String value) {
            addCriterion("authApplyForm.bus_code <>", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeGreaterThan(String value) {
            addCriterion("authApplyForm.bus_code >", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.bus_code >=", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeLessThan(String value) {
            addCriterion("authApplyForm.bus_code <", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.bus_code <=", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeLike(String value) {
            addCriterion("authApplyForm.bus_code like", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeNotLike(String value) {
            addCriterion("authApplyForm.bus_code not like", value, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeIn(List<String> values) {
            addCriterion("authApplyForm.bus_code in", values, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeNotIn(List<String> values) {
            addCriterion("authApplyForm.bus_code not in", values, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeBetween(String value1, String value2) {
            addCriterion("authApplyForm.bus_code between", value1, value2, "busCode");
            return (Criteria) this;
        }

        public Criteria andBusCodeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.bus_code not between", value1, value2, "busCode");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("authApplyForm.apply_status is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("authApplyForm.apply_status is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(String value) {
            addCriterion("authApplyForm.apply_status =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(String value) {
            addCriterion("authApplyForm.apply_status <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(String value) {
            addCriterion("authApplyForm.apply_status >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.apply_status >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(String value) {
            addCriterion("authApplyForm.apply_status <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.apply_status <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLike(String value) {
            addCriterion("authApplyForm.apply_status like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotLike(String value) {
            addCriterion("authApplyForm.apply_status not like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<String> values) {
            addCriterion("authApplyForm.apply_status in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<String> values) {
            addCriterion("authApplyForm.apply_status not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(String value1, String value2) {
            addCriterion("authApplyForm.apply_status between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.apply_status not between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andAuditTypeIsNull() {
            addCriterion("authApplyForm.audit_type is null");
            return (Criteria) this;
        }

        public Criteria andAuditTypeIsNotNull() {
            addCriterion("authApplyForm.audit_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTypeEqualTo(String value) {
            addCriterion("authApplyForm.audit_type =", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotEqualTo(String value) {
            addCriterion("authApplyForm.audit_type <>", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeGreaterThan(String value) {
            addCriterion("authApplyForm.audit_type >", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.audit_type >=", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeLessThan(String value) {
            addCriterion("authApplyForm.audit_type <", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.audit_type <=", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeLike(String value) {
            addCriterion("authApplyForm.audit_type like", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotLike(String value) {
            addCriterion("authApplyForm.audit_type not like", value, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeIn(List<String> values) {
            addCriterion("authApplyForm.audit_type in", values, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotIn(List<String> values) {
            addCriterion("authApplyForm.audit_type not in", values, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeBetween(String value1, String value2) {
            addCriterion("authApplyForm.audit_type between", value1, value2, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditTypeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.audit_type not between", value1, value2, "auditType");
            return (Criteria) this;
        }

        public Criteria andAuditPersonIsNull() {
            addCriterion("authApplyForm.audit_person is null");
            return (Criteria) this;
        }

        public Criteria andAuditPersonIsNotNull() {
            addCriterion("authApplyForm.audit_person is not null");
            return (Criteria) this;
        }

        public Criteria andAuditPersonEqualTo(String value) {
            addCriterion("authApplyForm.audit_person =", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotEqualTo(String value) {
            addCriterion("authApplyForm.audit_person <>", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonGreaterThan(String value) {
            addCriterion("authApplyForm.audit_person >", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.audit_person >=", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonLessThan(String value) {
            addCriterion("authApplyForm.audit_person <", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.audit_person <=", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonLike(String value) {
            addCriterion("authApplyForm.audit_person like", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotLike(String value) {
            addCriterion("authApplyForm.audit_person not like", value, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonIn(List<String> values) {
            addCriterion("authApplyForm.audit_person in", values, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotIn(List<String> values) {
            addCriterion("authApplyForm.audit_person not in", values, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonBetween(String value1, String value2) {
            addCriterion("authApplyForm.audit_person between", value1, value2, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditPersonNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.audit_person not between", value1, value2, "auditPerson");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNull() {
            addCriterion("authApplyForm.audit_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIsNotNull() {
            addCriterion("authApplyForm.audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("authApplyForm.audit_time =", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("authApplyForm.audit_time <>", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("authApplyForm.audit_time >", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.audit_time >=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("authApplyForm.audit_time <", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.audit_time <=", value, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("authApplyForm.audit_time in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("authApplyForm.audit_time not in", values, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.audit_time between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.audit_time not between", value1, value2, "auditTime");
            return (Criteria) this;
        }

        public Criteria andAuditSugIsNull() {
            addCriterion("authApplyForm.audit_sug is null");
            return (Criteria) this;
        }

        public Criteria andAuditSugIsNotNull() {
            addCriterion("authApplyForm.audit_sug is not null");
            return (Criteria) this;
        }

        public Criteria andAuditSugEqualTo(String value) {
            addCriterion("authApplyForm.audit_sug =", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugNotEqualTo(String value) {
            addCriterion("authApplyForm.audit_sug <>", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugGreaterThan(String value) {
            addCriterion("authApplyForm.audit_sug >", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.audit_sug >=", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugLessThan(String value) {
            addCriterion("authApplyForm.audit_sug <", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.audit_sug <=", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugLike(String value) {
            addCriterion("authApplyForm.audit_sug like", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugNotLike(String value) {
            addCriterion("authApplyForm.audit_sug not like", value, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugIn(List<String> values) {
            addCriterion("authApplyForm.audit_sug in", values, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugNotIn(List<String> values) {
            addCriterion("authApplyForm.audit_sug not in", values, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugBetween(String value1, String value2) {
            addCriterion("authApplyForm.audit_sug between", value1, value2, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuditSugNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.audit_sug not between", value1, value2, "auditSug");
            return (Criteria) this;
        }

        public Criteria andAuthSourceIsNull() {
            addCriterion("authApplyForm.auth_source is null");
            return (Criteria) this;
        }

        public Criteria andAuthSourceIsNotNull() {
            addCriterion("authApplyForm.auth_source is not null");
            return (Criteria) this;
        }

        public Criteria andAuthSourceEqualTo(String value) {
            addCriterion("authApplyForm.auth_source =", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_source <>", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceGreaterThan(String value) {
            addCriterion("authApplyForm.auth_source >", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_source >=", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceLessThan(String value) {
            addCriterion("authApplyForm.auth_source <", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_source <=", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceLike(String value) {
            addCriterion("authApplyForm.auth_source like", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceNotLike(String value) {
            addCriterion("authApplyForm.auth_source not like", value, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceIn(List<String> values) {
            addCriterion("authApplyForm.auth_source in", values, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_source not in", values, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_source between", value1, value2, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthSourceNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_source not between", value1, value2, "authSource");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeIsNull() {
            addCriterion("authApplyForm.auth_person_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeIsNotNull() {
            addCriterion("authApplyForm.auth_person_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_type =", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_type <>", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeGreaterThan(String value) {
            addCriterion("authApplyForm.auth_person_type >", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_type >=", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeLessThan(String value) {
            addCriterion("authApplyForm.auth_person_type <", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_type <=", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeLike(String value) {
            addCriterion("authApplyForm.auth_person_type like", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeNotLike(String value) {
            addCriterion("authApplyForm.auth_person_type not like", value, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeIn(List<String> values) {
            addCriterion("authApplyForm.auth_person_type in", values, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_person_type not in", values, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_person_type between", value1, value2, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonTypeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_person_type not between", value1, value2, "authPersonType");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeIsNull() {
            addCriterion("authApplyForm.auth_person_code is null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeIsNotNull() {
            addCriterion("authApplyForm.auth_person_code is not null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_code =", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_code <>", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeGreaterThan(String value) {
            addCriterion("authApplyForm.auth_person_code >", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_code >=", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeLessThan(String value) {
            addCriterion("authApplyForm.auth_person_code <", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_code <=", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeLike(String value) {
            addCriterion("authApplyForm.auth_person_code like", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeNotLike(String value) {
            addCriterion("authApplyForm.auth_person_code not like", value, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeIn(List<String> values) {
            addCriterion("authApplyForm.auth_person_code in", values, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_person_code not in", values, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_person_code between", value1, value2, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonCodeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_person_code not between", value1, value2, "authPersonCode");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameIsNull() {
            addCriterion("authApplyForm.auth_person_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameIsNotNull() {
            addCriterion("authApplyForm.auth_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_name =", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_name <>", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameGreaterThan(String value) {
            addCriterion("authApplyForm.auth_person_name >", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_name >=", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameLessThan(String value) {
            addCriterion("authApplyForm.auth_person_name <", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_person_name <=", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameLike(String value) {
            addCriterion("authApplyForm.auth_person_name like", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameNotLike(String value) {
            addCriterion("authApplyForm.auth_person_name not like", value, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameIn(List<String> values) {
            addCriterion("authApplyForm.auth_person_name in", values, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_person_name not in", values, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_person_name between", value1, value2, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthPersonNameNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_person_name not between", value1, value2, "authPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameIsNull() {
            addCriterion("authApplyForm.auth_legal_person_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameIsNotNull() {
            addCriterion("authApplyForm.auth_legal_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_name =", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_name <>", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameGreaterThan(String value) {
            addCriterion("authApplyForm.auth_legal_person_name >", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_name >=", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameLessThan(String value) {
            addCriterion("authApplyForm.auth_legal_person_name <", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_name <=", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameLike(String value) {
            addCriterion("authApplyForm.auth_legal_person_name like", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameNotLike(String value) {
            addCriterion("authApplyForm.auth_legal_person_name not like", value, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameIn(List<String> values) {
            addCriterion("authApplyForm.auth_legal_person_name in", values, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_legal_person_name not in", values, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_legal_person_name between", value1, value2, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonNameNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_legal_person_name not between", value1, value2, "authLegalPersonName");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneIsNull() {
            addCriterion("authApplyForm.auth_legal_person_phone is null");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneIsNotNull() {
            addCriterion("authApplyForm.auth_legal_person_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone =", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone <>", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneGreaterThan(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone >", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone >=", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneLessThan(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone <", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone <=", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneLike(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone like", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneNotLike(String value) {
            addCriterion("authApplyForm.auth_legal_person_phone not like", value, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneIn(List<String> values) {
            addCriterion("authApplyForm.auth_legal_person_phone in", values, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_legal_person_phone not in", values, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_legal_person_phone between", value1, value2, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthLegalPersonPhoneNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_legal_person_phone not between", value1, value2, "authLegalPersonPhone");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNull() {
            addCriterion("authApplyForm.auth_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("authApplyForm.auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(String value) {
            addCriterion("authApplyForm.auth_type =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_type <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(String value) {
            addCriterion("authApplyForm.auth_type >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_type >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(String value) {
            addCriterion("authApplyForm.auth_type <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_type <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLike(String value) {
            addCriterion("authApplyForm.auth_type like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotLike(String value) {
            addCriterion("authApplyForm.auth_type not like", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<String> values) {
            addCriterion("authApplyForm.auth_type in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_type not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_type between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_type not between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeIsNull() {
            addCriterion("authApplyForm.merchant_bus_type is null");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeIsNotNull() {
            addCriterion("authApplyForm.merchant_bus_type is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_type =", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeNotEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_type <>", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeGreaterThan(String value) {
            addCriterion("authApplyForm.merchant_bus_type >", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_type >=", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeLessThan(String value) {
            addCriterion("authApplyForm.merchant_bus_type <", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_type <=", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeLike(String value) {
            addCriterion("authApplyForm.merchant_bus_type like", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeNotLike(String value) {
            addCriterion("authApplyForm.merchant_bus_type not like", value, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeIn(List<String> values) {
            addCriterion("authApplyForm.merchant_bus_type in", values, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeNotIn(List<String> values) {
            addCriterion("authApplyForm.merchant_bus_type not in", values, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeBetween(String value1, String value2) {
            addCriterion("authApplyForm.merchant_bus_type between", value1, value2, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusTypeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.merchant_bus_type not between", value1, value2, "merchantBusType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeIsNull() {
            addCriterion("authApplyForm.merchant_bus_sub_type is null");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeIsNotNull() {
            addCriterion("authApplyForm.merchant_bus_sub_type is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type =", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeNotEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type <>", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeGreaterThan(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type >", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type >=", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeLessThan(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type <", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type <=", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeLike(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type like", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeNotLike(String value) {
            addCriterion("authApplyForm.merchant_bus_sub_type not like", value, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeIn(List<String> values) {
            addCriterion("authApplyForm.merchant_bus_sub_type in", values, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeNotIn(List<String> values) {
            addCriterion("authApplyForm.merchant_bus_sub_type not in", values, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeBetween(String value1, String value2) {
            addCriterion("authApplyForm.merchant_bus_sub_type between", value1, value2, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andMerchantBusSubTypeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.merchant_bus_sub_type not between", value1, value2, "merchantBusSubType");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentIsNull() {
            addCriterion("authApplyForm.auth_fill_content is null");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentIsNotNull() {
            addCriterion("authApplyForm.auth_fill_content is not null");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentEqualTo(String value) {
            addCriterion("authApplyForm.auth_fill_content =", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentNotEqualTo(String value) {
            addCriterion("authApplyForm.auth_fill_content <>", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentGreaterThan(String value) {
            addCriterion("authApplyForm.auth_fill_content >", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_fill_content >=", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentLessThan(String value) {
            addCriterion("authApplyForm.auth_fill_content <", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.auth_fill_content <=", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentLike(String value) {
            addCriterion("authApplyForm.auth_fill_content like", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentNotLike(String value) {
            addCriterion("authApplyForm.auth_fill_content not like", value, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentIn(List<String> values) {
            addCriterion("authApplyForm.auth_fill_content in", values, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentNotIn(List<String> values) {
            addCriterion("authApplyForm.auth_fill_content not in", values, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_fill_content between", value1, value2, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andAuthFillContentNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.auth_fill_content not between", value1, value2, "authFillContent");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("authApplyForm.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("authApplyForm.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("authApplyForm.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("authApplyForm.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("authApplyForm.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("authApplyForm.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("authApplyForm.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("authApplyForm.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("authApplyForm.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("authApplyForm.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("authApplyForm.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("authApplyForm.valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("authApplyForm.valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("authApplyForm.valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("authApplyForm.valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("authApplyForm.valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("authApplyForm.valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("authApplyForm.valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("authApplyForm.valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("authApplyForm.valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("authApplyForm.valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("authApplyForm.valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("authApplyForm.valid not between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andIndateIsNull() {
            addCriterion("authApplyForm.indate is null");
            return (Criteria) this;
        }

        public Criteria andIndateIsNotNull() {
            addCriterion("authApplyForm.indate is not null");
            return (Criteria) this;
        }

        public Criteria andIndateEqualTo(Date value) {
            addCriterion("authApplyForm.indate =", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateNotEqualTo(Date value) {
            addCriterion("authApplyForm.indate <>", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateGreaterThan(Date value) {
            addCriterion("authApplyForm.indate >", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateGreaterThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.indate >=", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateLessThan(Date value) {
            addCriterion("authApplyForm.indate <", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateLessThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.indate <=", value, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateIn(List<Date> values) {
            addCriterion("authApplyForm.indate in", values, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateNotIn(List<Date> values) {
            addCriterion("authApplyForm.indate not in", values, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.indate between", value1, value2, "indate");
            return (Criteria) this;
        }

        public Criteria andIndateNotBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.indate not between", value1, value2, "indate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("authApplyForm.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("authApplyForm.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("authApplyForm.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("authApplyForm.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("authApplyForm.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("authApplyForm.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("authApplyForm.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("authApplyForm.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("authApplyForm.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("authApplyForm.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("authApplyForm.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("authApplyForm.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("authApplyForm.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("authApplyForm.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("authApplyForm.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("authApplyForm.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("authApplyForm.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("authApplyForm.update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("authApplyForm.create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("authApplyForm.create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("authApplyForm.create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("authApplyForm.create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("authApplyForm.create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("authApplyForm.create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("authApplyForm.create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("authApplyForm.create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("authApplyForm.create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("authApplyForm.create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("authApplyForm.create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.create_user_name not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIsNull() {
            addCriterion("authApplyForm.create_user_code is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIsNotNull() {
            addCriterion("authApplyForm.create_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeEqualTo(String value) {
            addCriterion("authApplyForm.create_user_code =", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotEqualTo(String value) {
            addCriterion("authApplyForm.create_user_code <>", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThan(String value) {
            addCriterion("authApplyForm.create_user_code >", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.create_user_code >=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThan(String value) {
            addCriterion("authApplyForm.create_user_code <", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.create_user_code <=", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeLike(String value) {
            addCriterion("authApplyForm.create_user_code like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotLike(String value) {
            addCriterion("authApplyForm.create_user_code not like", value, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeIn(List<String> values) {
            addCriterion("authApplyForm.create_user_code in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotIn(List<String> values) {
            addCriterion("authApplyForm.create_user_code not in", values, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeBetween(String value1, String value2) {
            addCriterion("authApplyForm.create_user_code between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andCreateUserCodeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.create_user_code not between", value1, value2, "createUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNull() {
            addCriterion("authApplyForm.update_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIsNotNull() {
            addCriterion("authApplyForm.update_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameEqualTo(String value) {
            addCriterion("authApplyForm.update_user_name =", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotEqualTo(String value) {
            addCriterion("authApplyForm.update_user_name <>", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThan(String value) {
            addCriterion("authApplyForm.update_user_name >", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.update_user_name >=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThan(String value) {
            addCriterion("authApplyForm.update_user_name <", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.update_user_name <=", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameLike(String value) {
            addCriterion("authApplyForm.update_user_name like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotLike(String value) {
            addCriterion("authApplyForm.update_user_name not like", value, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameIn(List<String> values) {
            addCriterion("authApplyForm.update_user_name in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotIn(List<String> values) {
            addCriterion("authApplyForm.update_user_name not in", values, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameBetween(String value1, String value2) {
            addCriterion("authApplyForm.update_user_name between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.update_user_name not between", value1, value2, "updateUserName");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNull() {
            addCriterion("authApplyForm.update_user_code is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIsNotNull() {
            addCriterion("authApplyForm.update_user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeEqualTo(String value) {
            addCriterion("authApplyForm.update_user_code =", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotEqualTo(String value) {
            addCriterion("authApplyForm.update_user_code <>", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThan(String value) {
            addCriterion("authApplyForm.update_user_code >", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("authApplyForm.update_user_code >=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThan(String value) {
            addCriterion("authApplyForm.update_user_code <", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLessThanOrEqualTo(String value) {
            addCriterion("authApplyForm.update_user_code <=", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeLike(String value) {
            addCriterion("authApplyForm.update_user_code like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotLike(String value) {
            addCriterion("authApplyForm.update_user_code not like", value, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeIn(List<String> values) {
            addCriterion("authApplyForm.update_user_code in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotIn(List<String> values) {
            addCriterion("authApplyForm.update_user_code not in", values, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeBetween(String value1, String value2) {
            addCriterion("authApplyForm.update_user_code between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }

        public Criteria andUpdateUserCodeNotBetween(String value1, String value2) {
            addCriterion("authApplyForm.update_user_code not between", value1, value2, "updateUserCode");
            return (Criteria) this;
        }
    }

    /**
     * authApplyForm<p/>
     * t_bcc_auth_apply_form
     * @date Thu Apr 29 16:48:04 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * AuthApplyForm<p/>
     * t_bcc_auth_apply_form
     * @date Thu Apr 29 16:48:04 CST 2021
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