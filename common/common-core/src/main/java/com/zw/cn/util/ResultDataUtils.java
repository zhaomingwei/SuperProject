package com.zw.cn.util;

import java.beans.PropertyDescriptor;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ResultDataUtils
 * @Description
 * @date 2021-05-08 17:49:09
 */
public class ResultDataUtils {

    public static String getBeanName(Object bean) {
        if (bean == null)
            return "dto";
        String key = bean.getClass().getSimpleName();
        key = Character.toLowerCase(key.charAt(0))
                + key.substring(1, key.length());

        return key;
    }

    public static Map<String, Object> getValues(Object bean, String... fields) {
        if (bean == null)
            return null;
        if (fields == null || fields.length == 0)
            return describe(bean);

        Map<String, Object> map = new LinkedHashMap<String, Object>();

        for (String field : fields) {
            Object value = getValue(bean, field);
            map.put(field, value);//if value is null，still put data
        }

        return map;
    }

    public static <T> Map<String, T> getMapValues(Map<String, T> map, boolean needNull, String... keys) {
        if (map == null)
            return null;
        if (keys == null || keys.length == 0)
            return map;

        Map<String, T> resultMap = new LinkedHashMap<>();

        for (String key : keys) {
            T object = map.get(key);
            if (object != null || needNull)
                resultMap.put(key, object);
        }

        return resultMap;
    }

    public static <T> Map<String, T> getMapValues(Map<String, T> map, String... keys) {
        return getMapValues(map, true, keys);
    }

    public static void initIntValue(Object bean, boolean needNull) {
        if (bean == null)
            return;
        List<String> names = getFieldNames(bean.getClass());
        for (String name : names) {
            try {
                PropertyDescriptor pd = new PropertyDescriptor(name,
                        bean.getClass());
                Object invoke = pd.getReadMethod().invoke(bean);
                if (invoke != null || needNull)
                    continue;

                Class<?> returnType = pd.getReadMethod().getReturnType();
                if (returnType == Integer.class) {
                    setValue(bean, name, 0);
                }
                if (returnType == Double.class) {
                    setValue(bean, name, 0.00d);
                }
                if (returnType == Long.class) {
                    setValue(bean, name, 0);
                }
            } catch (Exception e) {
            }
        }
    }

    public static Map<String, Object> getValuesEx(Object bean, String... exFields) {
        if (bean == null)
            return null;
        if (exFields == null || exFields.length == 0)
            return describe(bean);

        Map<String, Object> map = describe(bean);

        for (String field : exFields) {
            map.remove(field);
        }

        return map;
    }
}
