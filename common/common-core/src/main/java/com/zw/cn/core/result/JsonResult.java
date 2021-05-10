package com.zw.cn.core.result;

import com.zw.cn.util.ResultDataUtils;
import com.zw.cn.core.model.Describle;
import com.zw.cn.core.model.PageInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * global return json for result
 *
 * @author ZhaoWei
 * @time 2021-05-08 17:48:36
 */
@SuppressWarnings("serial")
public class JsonResult implements Serializable {

    public static final String Page_Data_Key = "pagedata";
    public static final String Page_Info_Key = "pageinfo";

    public static final int Success = 1;
    public static final int Error = 0;

    private int code;
    private String msg;
    private Map<String, Object> data = new LinkedHashMap<String, Object>();
    private Object bean;
    private List<Object> beanList;

    public void putPage(PageInfo pageInfo, List<?> pageData, String... inFields) {

        this.putListData(Page_Data_Key, pageData, inFields);
        this.data.put(Page_Info_Key, pageInfo);
    }

    /**
     * @param pageInfo
     * @param pageData
     * @param extFieldMap :add extension filed of return list Object
     * @param inFields
     * @author ZhaoWei
     * @date 2021-05-08 17:44:53
     */
    public void putPage(PageInfo pageInfo, List<?> pageData, Map<String, ?> extFieldMap, String... inFields) {

        this.putListData(Page_Data_Key, pageData, extFieldMap, inFields);
        this.data.put(Page_Info_Key, pageInfo);
    }

    /**
     * @param pageInfo
     * @param pageData
     * @param inFields
     * @param innerListInFieldMap : number variable is instance of list,and it appoint into
     *                            fields
     * @author ZhaoWei
     * @date Aug 16, 2017 12:09:30 PM
     */
    public void putPage(PageInfo pageInfo, List<?> pageData, String[] inFields, Map<String, String[]> innerListInFieldMap) {

        this.putListData(Page_Data_Key, pageData, inFields, innerListInFieldMap);
        this.data.put(Page_Info_Key, pageInfo);
    }

    /**
     * @param pageInfo
     * @param pageData
     * @param extFieldMap
     * @param innerListInFieldMap
     * @param inFields
     * @author ZhaoWei
     * @date Aug 16, 2017 12:07:39 PM
     */
    public void putPage(PageInfo pageInfo, List<?> pageData, Map<String, ?> extFieldMap, Map<String, String[]> innerListInFieldMap, String... inFields) {

        this.putListData(Page_Data_Key, pageData, extFieldMap, inFields, innerListInFieldMap);
        this.data.put(Page_Info_Key, pageInfo);
    }

    public void putPageInfo(PageInfo pageInfo) {
        if (pageInfo == null)
            return;
        this.data.put(Page_Info_Key, pageInfo);
    }

    @Deprecated
    public void putPageData(List<?> data, String... fields) {
        this.putListData(Page_Data_Key, data, fields);
    }

    /**
     * @param data
     * @param innerListInFieldMap : number variable is instance of list,and it appoint into
     *                            fields
     * @param fields
     * @author ZhaoWei
     * @date Aug 15, 2017 5:23:52 PM
     */
    @Deprecated
    public void putPageData(List<?> data, Map<String, String[]> innerListInFieldMap, String... fields) {
        this.putListData(Page_Data_Key, data, fields, innerListInFieldMap);
    }

    public void putData(String key, Object value) {

        if (this.checkMapAndDescrible(key, value))
            return;

        this.data.put(key, value);
    }

    public void putData(String key, Object bean, String... fields) {

        if (this.checkMapAndDescrible(key, bean, fields))
            return;
        if (fields == null || fields.length == 0) {
            ResultDataUtils.initIntValue(bean, true);
            this.data.put(key, bean);
            return;
        }
        Map<String, Object> values = ResultDataUtils.getValues(bean, fields);
        this.data.put(key, values);
    }

    public void putData(String key, Object bean, Map<String, String[]> innerListInFieldMap, String... fields) {

        if (this.checkMapAndDescrible(key, bean, innerListInFieldMap, fields))
            return;
        Map<String, Object> values = ResultDataUtils.getValues(bean, fields);
        this.innerListInField(innerListInFieldMap, values);
        this.data.put(key, values);
    }

    /**
     * use the bean class simple name to key witch the first work is lower case
     *
     * @param bean   the field that return to app
     * @param fields
     */
    public void putBeanData(Object bean, String... fields) {
        String key = ResultDataUtils.getBeanName(bean);
        this.putData(key, bean, fields);
    }

    public void putBeanData(Object bean, Map<String, String[]> innerListInFieldMap, String... fields) {
        String key = ResultDataUtils.getBeanName(bean);
        this.putData(key, bean, innerListInFieldMap, fields);
    }

    /**
     * use the user key to put bean
     * <p>
     *
     * @param key    key in return json
     * @param bean   data
     * @param fields fields is bean data
     * @see #putBeanData(Object, String...)
     */
    public void putBeanData(String key, Object bean, String... fields) {

        this.putData(key, bean, fields);
    }

    /**
     * put list into data use customer key
     *
     * @param key
     * @param listBean
     * @param inFields
     */
    @SuppressWarnings("unchecked")
    public void putListData(String key, List<?> listBean, String... inFields) {
        List<Map<String, ?>> retData = new ArrayList<>();

        if (listBean == null) {
            this.data.put(key, new ArrayList<Object>());
            return;
        }

        for (Object bean : listBean) {

            if (bean instanceof Map) {
                retData.add(ResultDataUtils.getMapValues((Map<String, ?>) bean, inFields));
                continue;
            }

            if (bean instanceof Describle) {
                Map<String, Object> values = ((Describle) bean).describ();
                retData.add(values);
                continue;
            }
            Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
            retData.add(values);
        }
        this.data.put(key, retData);
    }

    /**
     * put list into data use customer key
     *
     * @param key
     * @param listBean
     * @param extFieldMap : add extension filed of return list Object
     * @param inFields
     */
    @SuppressWarnings("unchecked")
    public void putListData(String key, List<?> listBean, Map<String, ?> extFieldMap, String... inFields) {
        List<Map<String, ?>> retData = new ArrayList<>();

        if (listBean == null) {
            this.data.put(key, new ArrayList<Object>());
            return;
        }

        @SuppressWarnings("rawtypes")
        Map ExtMapValues = ResultDataUtils.getMapValues(extFieldMap, false, inFields);
        for (Object bean : listBean) {

            if (bean instanceof Map) {
                Map<String, Object> mapValue = ResultDataUtils.getMapValues((Map<String, Object>) bean, inFields);
                mapValue.putAll(ExtMapValues);
                retData.add(mapValue);
                continue;
            }

            if (bean instanceof Describle) {
                Map<String, Object> values = ((Describle) bean).describ();
                values.putAll(ExtMapValues);
                retData.add(values);
                continue;
            }
            Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
            values.putAll(ExtMapValues);
            retData.add(values);
        }

        this.data.put(key, retData);
    }

    /**
     * put list into data use customer key
     *
     * @param key
     * @param listBean
     * @param extFieldMap         :add extension filed of return list Object
     * @param inFields
     * @param innerListInFieldMap :number variable is instance of list,and it appoint into
     *                            fields
     * @author ZhaoWei
     * @date Aug 15, 2017 5:17:14 PM
     */
    @SuppressWarnings("unchecked")
    public void putListData(String key, List<?> listBean, Map<String, ?> extFieldMap, String[] inFields,
                            Map<String, String[]> innerListInFieldMap) {
        List<Map<String, ?>> retData = new ArrayList<>();

        if (listBean == null) {
            this.data.put(key, new ArrayList<Object>());
            return;
        }

        @SuppressWarnings("rawtypes")
        Map ExtMapValues = ResultDataUtils.getMapValues(extFieldMap, false, inFields);
        for (Object bean : listBean) {

            if (bean instanceof Map) {
                Map<String, Object> mapValue = ResultDataUtils.getMapValues((Map<String, Object>) bean, inFields);
                this.innerListInField(innerListInFieldMap, mapValue);
                mapValue.putAll(ExtMapValues);
                retData.add(mapValue);
                continue;
            }

            if (bean instanceof Describle) {
                Map<String, Object> values = ((Describle) bean).describ();
                this.innerListInField(innerListInFieldMap, values);
                values.putAll(ExtMapValues);
                retData.add(values);
                continue;
            }
            Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
            this.innerListInField(innerListInFieldMap, values);
            values.putAll(ExtMapValues);
            retData.add(values);
        }

        this.data.put(key, retData);
    }

    /**
     * put list into data use customer key
     *
     * @param key
     * @param listBean
     * @param inFields
     * @param innerListInFieldMap : number variable is instance of list,and it appoint into
     *                            fields
     * @author ZhaoWei
     * @date Aug 15, 2017 5:02:38 PM
     */
    @SuppressWarnings("unchecked")
    public void putListData(String key, List<?> listBean, String[] inFields,
                            Map<String, String[]> innerListInFieldMap) {
        List<Map<String, ?>> retData = new ArrayList<>();

        if (listBean == null) {
            this.data.put(key, new ArrayList<Object>());
            return;
        }

        for (Object bean : listBean) {

            if (bean instanceof Map) {
                Map<String, Object> mapValue = ResultDataUtils.getMapValues((Map<String, Object>) bean, inFields);
                retData.add(mapValue);
                this.innerListInField(innerListInFieldMap, mapValue);
                continue;
            }

            if (bean instanceof Describle) {
                Map<String, Object> values = ((Describle) bean).describ();
                retData.add(values);
                this.innerListInField(innerListInFieldMap, values);
                continue;
            }

            Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
            retData.add(values);
            this.innerListInField(innerListInFieldMap, values);

        }

        this.data.put(key, retData);
    }

    /**
     * @param innerListInFieldMap
     * @param bean
     * @param mapValue
     * @author ZhaoWei
     * @date Aug 15, 2017 4:51:51 PM
     */
    @SuppressWarnings("unchecked")
    protected void innerListInField(Map<String, String[]> innerListInFieldMap, Map<String, Object> mapValue) {
        for (Entry<String, String[]> entry : innerListInFieldMap.entrySet()) {

            String listKey = entry.getKey();
            String[] listInFields = entry.getValue();

            if (mapValue.containsKey(listKey)) {
                Object o = mapValue.get(listKey);
                if (o instanceof List) {
                    List<?> innerList = (List<?>) o;

                    List<Map<String, ?>> innerData = new ArrayList<>();

                    for (Object innerBean : innerList) {

                        if (innerBean instanceof Map) {
                            innerData.add(ResultDataUtils.getMapValues((Map<String, ?>) innerBean, listInFields));
                            continue;
                        }

                        if (bean instanceof Describle) {
                            Map<String, Object> values = ((Describle) innerBean).describ();
                            innerData.add(values);
                            continue;
                        }
                        Map<String, Object> values = ResultDataUtils.getValues(innerBean, listInFields);
                        innerData.add(values);
                    }
                    mapValue.put(listKey, innerData);
                }
            }
        }
    }

    /**
     * not suggest to use this method,this method will return the
     * <p>
     * field witch not in exFields
     *
     * @param bean
     * @param exFields the field not return to app
     */
    @Deprecated
    public void putBeanDataEx(Object bean, String... exFields) {
        String key = ResultDataUtils.getBeanName(bean);
        Map<String, Object> values = ResultDataUtils.getValuesEx(bean, exFields);
        this.data.put(key, values);
    }

    @SuppressWarnings("unchecked")
    public void putOnlyBean(Object bean, String... inFields) {

        if (bean == null)
            return;
        if (bean instanceof Map) {
            this.bean = ResultDataUtils.getMapValues((Map<String, ?>) bean, inFields);
            return;
        }

        Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);

        this.bean = values;
    }

    @SuppressWarnings("unchecked")
    public void putOnlyBean(Object bean, String[] inFields, Map<String, String[]> innerListInFieldMap) {

        if (bean == null)
            return;
        if (bean instanceof Map) {
            Map<String, Object> mapValues = ResultDataUtils.getMapValues((Map<String, Object>) bean, inFields);
            this.innerListInField(innerListInFieldMap, mapValues);
            this.bean = mapValues;
            return;
        }

        Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
        this.innerListInField(innerListInFieldMap, values);

        this.bean = values;
    }

    /**
     * bean的inFields字段和map的key(和inFields相同)对应的键值对,put进bean
     *
     * @param bean
     * @param map
     * @param inFields
     * @author ZhaoWei
     * @date 2017年5月16日 下午8:12:51
     */
    @SuppressWarnings("unchecked")
    public void putOnlyBean(Object bean, Map<String, ?> map, String... inFields) {

        if (bean == null)
            return;
        if (bean instanceof Map) {
            Map<String, Object> m = (Map<String, Object>) bean;
            m.putAll(map);
            this.bean = ResultDataUtils.getMapValues((Map<String, ?>) bean, inFields);
            return;
        }

        Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
        values.putAll(ResultDataUtils.getMapValues(map, false, inFields));
        this.bean = values;
    }

    /**
     * @param bean
     * @param map
     * @param inFields
     * @author ZhaoWei
     * @date 2017年5月16日 下午8:12:51
     */
    @SuppressWarnings("unchecked")
    public void putOnlyBean(Object bean, Map<String, ?> map, Map<String, String[]> innerListInFieldMap, String... inFields) {

        if (bean == null)
            return;
        if (bean instanceof Map) {
            Map<String, Object> m = (Map<String, Object>) bean;
            m.putAll(map);
            Map<String, Object> mapValues = ResultDataUtils.getMapValues((Map<String, Object>) bean, inFields);
            this.innerListInField(innerListInFieldMap, mapValues);
            this.bean = mapValues;
            return;
        }

        Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
        values.putAll(ResultDataUtils.getMapValues(map, false, inFields));
        this.innerListInField(innerListInFieldMap, values);
        this.bean = values;
    }

    @SuppressWarnings("unchecked")
    public void putOnlyListBean(List<?> listBean, String... inFields) {

        if (listBean == null || listBean.isEmpty()) {
            return;
        }
        beanList = new ArrayList<>();
        for (Object bean : listBean) {
            if (bean instanceof Map) {
                beanList.add(ResultDataUtils.getMapValues((Map<String, ?>) bean, inFields));
                continue;
            }
            if (bean instanceof Describle) {
                Map<String, Object> values = ((Describle) bean).describ();
                beanList.add(values);
                continue;
            }
            Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
            beanList.add(values);

        }
    }

    @SuppressWarnings("unchecked")
    public void putOnlyListBean(List<?> listBean, Map<String, String[]> innerListInFieldMap, String... inFields) {

        if (listBean == null || listBean.isEmpty()) {
            return;
        }
        beanList = new ArrayList<>();
        for (Object bean : listBean) {
            if (bean instanceof Map) {

                Map<String, Object> mapValues = ResultDataUtils.getMapValues((Map<String, Object>) bean, inFields);
                this.innerListInField(innerListInFieldMap, mapValues);
                beanList.add(mapValues);
                continue;
            }
            if (bean instanceof Describle) {
                Map<String, Object> values = ((Describle) bean).describ();
                this.innerListInField(innerListInFieldMap, values);
                beanList.add(values);
                continue;
            }
            Map<String, Object> values = ResultDataUtils.getValues(bean, inFields);
            this.innerListInField(innerListInFieldMap, values);
            beanList.add(values);

        }
    }

    public int getSta() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        if (data.isEmpty()) {

            if (bean != null)
                return bean;
            if (beanList != null && !beanList.isEmpty())
                return beanList;
            return null;
        }

        return data;
    }

    @Deprecated
    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult [code=" + code + ", msg=" + msg + ", data=" + data + ", bean=" + bean + ", beanList="
                + beanList + "]";
    }

    @SuppressWarnings("unchecked")
    private boolean checkMapAndDescrible(String key, Object value, String... fields) {

        if (value instanceof Map) {
            Map<String, ?> mapValues = ResultDataUtils.getMapValues((Map<String, ?>) value, fields);
            this.data.put(key, mapValues);
            return true;
        }

        if (value instanceof Describle) {
            this.data.put(key, ((Describle) value).describ());
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private boolean checkMapAndDescrible(String key, Object value, Map<String, String[]> innerListInFieldMap, String... fields) {

        if (value instanceof Map) {
            Map<String, Object> mapValues = ResultDataUtils.getMapValues((Map<String, Object>) value, fields);
            this.innerListInField(innerListInFieldMap, mapValues);
            this.data.put(key, mapValues);
            return true;
        }

        if (value instanceof Describle) {
            Map<String, Object> describ = ((Describle) value).describ();
            this.innerListInField(innerListInFieldMap, describ);
            this.data.put(key, ((Describle) value).describ());
            return true;
        }
        return false;
    }
}
