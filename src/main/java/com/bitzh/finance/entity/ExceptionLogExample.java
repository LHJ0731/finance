package com.bitzh.finance.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExceptionLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExceptionLogExample() {
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

        public Criteria andExcIdIsNull() {
            addCriterion("exc_id is null");
            return (Criteria) this;
        }

        public Criteria andExcIdIsNotNull() {
            addCriterion("exc_id is not null");
            return (Criteria) this;
        }

        public Criteria andExcIdEqualTo(String value) {
            addCriterion("exc_id =", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotEqualTo(String value) {
            addCriterion("exc_id <>", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdGreaterThan(String value) {
            addCriterion("exc_id >", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdGreaterThanOrEqualTo(String value) {
            addCriterion("exc_id >=", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdLessThan(String value) {
            addCriterion("exc_id <", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdLessThanOrEqualTo(String value) {
            addCriterion("exc_id <=", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdLike(String value) {
            addCriterion("exc_id like", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotLike(String value) {
            addCriterion("exc_id not like", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdIn(List<String> values) {
            addCriterion("exc_id in", values, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotIn(List<String> values) {
            addCriterion("exc_id not in", values, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdBetween(String value1, String value2) {
            addCriterion("exc_id between", value1, value2, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotBetween(String value1, String value2) {
            addCriterion("exc_id not between", value1, value2, "excId");
            return (Criteria) this;
        }

        public Criteria andExcNameIsNull() {
            addCriterion("exc_name is null");
            return (Criteria) this;
        }

        public Criteria andExcNameIsNotNull() {
            addCriterion("exc_name is not null");
            return (Criteria) this;
        }

        public Criteria andExcNameEqualTo(String value) {
            addCriterion("exc_name =", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameNotEqualTo(String value) {
            addCriterion("exc_name <>", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameGreaterThan(String value) {
            addCriterion("exc_name >", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameGreaterThanOrEqualTo(String value) {
            addCriterion("exc_name >=", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameLessThan(String value) {
            addCriterion("exc_name <", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameLessThanOrEqualTo(String value) {
            addCriterion("exc_name <=", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameLike(String value) {
            addCriterion("exc_name like", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameNotLike(String value) {
            addCriterion("exc_name not like", value, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameIn(List<String> values) {
            addCriterion("exc_name in", values, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameNotIn(List<String> values) {
            addCriterion("exc_name not in", values, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameBetween(String value1, String value2) {
            addCriterion("exc_name between", value1, value2, "excName");
            return (Criteria) this;
        }

        public Criteria andExcNameNotBetween(String value1, String value2) {
            addCriterion("exc_name not between", value1, value2, "excName");
            return (Criteria) this;
        }

        public Criteria andOperUsernameIsNull() {
            addCriterion("oper_username is null");
            return (Criteria) this;
        }

        public Criteria andOperUsernameIsNotNull() {
            addCriterion("oper_username is not null");
            return (Criteria) this;
        }

        public Criteria andOperUsernameEqualTo(String value) {
            addCriterion("oper_username =", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameNotEqualTo(String value) {
            addCriterion("oper_username <>", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameGreaterThan(String value) {
            addCriterion("oper_username >", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("oper_username >=", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameLessThan(String value) {
            addCriterion("oper_username <", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameLessThanOrEqualTo(String value) {
            addCriterion("oper_username <=", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameLike(String value) {
            addCriterion("oper_username like", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameNotLike(String value) {
            addCriterion("oper_username not like", value, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameIn(List<String> values) {
            addCriterion("oper_username in", values, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameNotIn(List<String> values) {
            addCriterion("oper_username not in", values, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameBetween(String value1, String value2) {
            addCriterion("oper_username between", value1, value2, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperUsernameNotBetween(String value1, String value2) {
            addCriterion("oper_username not between", value1, value2, "operUsername");
            return (Criteria) this;
        }

        public Criteria andOperMethodIsNull() {
            addCriterion("oper_method is null");
            return (Criteria) this;
        }

        public Criteria andOperMethodIsNotNull() {
            addCriterion("oper_method is not null");
            return (Criteria) this;
        }

        public Criteria andOperMethodEqualTo(String value) {
            addCriterion("oper_method =", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodNotEqualTo(String value) {
            addCriterion("oper_method <>", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodGreaterThan(String value) {
            addCriterion("oper_method >", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodGreaterThanOrEqualTo(String value) {
            addCriterion("oper_method >=", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodLessThan(String value) {
            addCriterion("oper_method <", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodLessThanOrEqualTo(String value) {
            addCriterion("oper_method <=", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodLike(String value) {
            addCriterion("oper_method like", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodNotLike(String value) {
            addCriterion("oper_method not like", value, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodIn(List<String> values) {
            addCriterion("oper_method in", values, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodNotIn(List<String> values) {
            addCriterion("oper_method not in", values, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodBetween(String value1, String value2) {
            addCriterion("oper_method between", value1, value2, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperMethodNotBetween(String value1, String value2) {
            addCriterion("oper_method not between", value1, value2, "operMethod");
            return (Criteria) this;
        }

        public Criteria andOperUrlIsNull() {
            addCriterion("oper_url is null");
            return (Criteria) this;
        }

        public Criteria andOperUrlIsNotNull() {
            addCriterion("oper_url is not null");
            return (Criteria) this;
        }

        public Criteria andOperUrlEqualTo(String value) {
            addCriterion("oper_url =", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotEqualTo(String value) {
            addCriterion("oper_url <>", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlGreaterThan(String value) {
            addCriterion("oper_url >", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlGreaterThanOrEqualTo(String value) {
            addCriterion("oper_url >=", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlLessThan(String value) {
            addCriterion("oper_url <", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlLessThanOrEqualTo(String value) {
            addCriterion("oper_url <=", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlLike(String value) {
            addCriterion("oper_url like", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotLike(String value) {
            addCriterion("oper_url not like", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlIn(List<String> values) {
            addCriterion("oper_url in", values, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotIn(List<String> values) {
            addCriterion("oper_url not in", values, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlBetween(String value1, String value2) {
            addCriterion("oper_url between", value1, value2, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotBetween(String value1, String value2) {
            addCriterion("oper_url not between", value1, value2, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperIpIsNull() {
            addCriterion("oper_ip is null");
            return (Criteria) this;
        }

        public Criteria andOperIpIsNotNull() {
            addCriterion("oper_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOperIpEqualTo(String value) {
            addCriterion("oper_ip =", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotEqualTo(String value) {
            addCriterion("oper_ip <>", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpGreaterThan(String value) {
            addCriterion("oper_ip >", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpGreaterThanOrEqualTo(String value) {
            addCriterion("oper_ip >=", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLessThan(String value) {
            addCriterion("oper_ip <", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLessThanOrEqualTo(String value) {
            addCriterion("oper_ip <=", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLike(String value) {
            addCriterion("oper_ip like", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotLike(String value) {
            addCriterion("oper_ip not like", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpIn(List<String> values) {
            addCriterion("oper_ip in", values, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotIn(List<String> values) {
            addCriterion("oper_ip not in", values, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpBetween(String value1, String value2) {
            addCriterion("oper_ip between", value1, value2, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotBetween(String value1, String value2) {
            addCriterion("oper_ip not between", value1, value2, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeIsNull() {
            addCriterion("oper_createtime is null");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeIsNotNull() {
            addCriterion("oper_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeEqualTo(Date value) {
            addCriterion("oper_createtime =", value, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeNotEqualTo(Date value) {
            addCriterion("oper_createtime <>", value, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeGreaterThan(Date value) {
            addCriterion("oper_createtime >", value, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_createtime >=", value, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeLessThan(Date value) {
            addCriterion("oper_createtime <", value, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_createtime <=", value, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeIn(List<Date> values) {
            addCriterion("oper_createtime in", values, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeNotIn(List<Date> values) {
            addCriterion("oper_createtime not in", values, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeBetween(Date value1, Date value2) {
            addCriterion("oper_createtime between", value1, value2, "operCreatetime");
            return (Criteria) this;
        }

        public Criteria andOperCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_createtime not between", value1, value2, "operCreatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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