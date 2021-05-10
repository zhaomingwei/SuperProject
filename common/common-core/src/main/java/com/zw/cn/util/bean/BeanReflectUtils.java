package com.zw.cn.util.bean;

import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class BeanReflectUtils {

    public static void copyProperties(Object source, Object target) {
        if (source == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }
        if (target == null) {
            throw new IllegalArgumentException("No destination bean specified");
        }

        // 获取要复制的属性
        Field[] targetFields = target.getClass().getDeclaredFields();
        int targetSize = targetFields == null ? 0 : targetFields.length;

        // 可以复制的属性
        Field[] sourceFields = source.getClass().getDeclaredFields();
        int sourceSize = sourceFields == null ? 0 : sourceFields.length;

        //	if(targetSize > sourceSize){
        Map<String, Field> targetFieldMap = new HashMap<String, Field>(targetSize);
        for (int i = 0; i < targetSize; i++) {
            Field targetField = targetFields[i];
            if (targetField != null) {
                targetFieldMap.put(targetField.getName().trim(), targetField);
            }
        }

        for (int i = 0; i < sourceSize; i++) {
            Field sourceFiled = sourceFields[i];
            if (sourceFiled != null) {
                Field targetField = targetFieldMap.get(sourceFiled.getName().trim());
                if (targetField != null) {
                    BeanReflectUtils.copyFiled(source, sourceFiled, target, targetField);
                }
            }
        }
//		}else{
//			Map<String,Field> sourceFieldMap = new HashMap<String,Field>(targetSize);
//			for(int i = 0;i < sourceSize;i++){
//				Field sourceField = sourceFields[i];
//				if(sourceField != null){
//					sourceFieldMap.put(sourceField.getName().trim(),sourceField);
//				}
//			}
//
//			for(int i = 0;i < targetSize;i++){
//				Field targetField = targetFields[i];
//				if(targetField != null){
//					Field sourceFiled = sourceFieldMap.get(targetField.getName().trim());
//					if(sourceFiled != null){
//						ReflectUtils.copyFiled(source,sourceFiled,target,targetField);
//					}
//				}
//			}
//		}
    }

    /**
     * by spring
     * org.springframework.beans.BeanUtils
     *
     * @param source
     * @param target
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @author ZhaoWei
     * @date Aug 31, 2017 11:57:40 AM
     */
    public static void copyProperties2(Object source, Object target) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * by spring</p>
     * org.springframework.beans.BeanUtils
     *
     * @param source
     * @param target
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @author ZhaoWei
     * @date Aug 31, 2017 11:57:40 AM
     */
    public static void copyProperties2(Object source, Object target, String... ignoreProperties) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    /**
     * by org.apache.commons.beanutils
     *
     * @param source
     * @param target
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @author ZhaoWei
     * @date Aug 31, 2017 11:57:40 AM
     */
    public static void copyProperties3(Object source, Object target) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.copyProperties(target, source);
    }


    private static void copyFiled(Object source, Field sourceFiled, Object target, Field targetField) {
        if (source != null && sourceFiled != null && target != null && targetField != null) {
            try {
                if (Modifier.isStatic(targetField.getModifiers()) || Modifier.isFinal(targetField.getModifiers())) {
                    return;
                }
                sourceFiled.setAccessible(true);
                Object val = sourceFiled.get(source);
                String valStr = val != null ? valStr = val.toString() : null;
                if (valStr == null || "".equals(valStr.trim())) {
                    return;
                }
                targetField.setAccessible(true);
                String sourceTypeStr = sourceFiled.getType().getName().toLowerCase().trim();
                String targetTypeStr = targetField.getType().getName().toLowerCase().trim();
                if (sourceTypeStr.trim().indexOf(targetTypeStr.trim()) < 0 && targetTypeStr.trim().indexOf(sourceTypeStr.trim()) < 0) {
                    return;
                }
                if ("byte".equals(targetTypeStr) || "java.lang.byte".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Byte.parseByte(valStr));
                    return;
                } else if ("short".equals(targetTypeStr) || "java.lang.short".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Short.parseShort(valStr));
                    return;
                } else if ("int".equals(targetTypeStr) || "java.lang.integer".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Integer.parseInt(valStr));
                    return;
                } else if ("long".equals(targetTypeStr) || "java.lang.long".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Long.valueOf(valStr));
                    return;
                } else if ("float".equals(targetTypeStr) || "java.lang.float".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Float.parseFloat(valStr));
                    return;
                } else if ("double".equals(targetTypeStr) || "java.lang.double".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Double.parseDouble(valStr));
                    return;
                } else if ("boolean".equals(targetTypeStr) || "java.lang.boolean".equalsIgnoreCase(targetTypeStr)) {
                    targetField.set(target, Boolean.parseBoolean(valStr));
                } else if ("java.lang.string".equals(targetTypeStr)) {
                    targetField.set(target, valStr);
                } else {
                    targetField.set(target, val);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param map 包含属性值的 map
     * @param clz 要转化的类型
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InstantiationException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Object map2bean(Map<?, ?> map, Class<?> clz) throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(clz); // 获取类属性   
        Object obj = clz.newInstance(); // 创建 JavaBean 对象   

        // 给 JavaBean 对象的属性赋值   
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。   
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException    如果分析类属性失败
     * @throws IllegalAccessException    如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static HashMap<?, ?> bean2Map(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class<?> type = bean.getClass();
        HashMap<Object, Object> returnMap = new HashMap<Object, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                returnMap.put(propertyName, result);
               /* if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }*/
            }
        }
        return returnMap;
    }


    public static Field getFieldByFieldName(Object obj, String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
                .getSuperclass()) {
            try {
                return superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            }
        }
        return null;
    }

    /**
     * 通过字段名称取值
     *
     * @param obj       对象
     * @param fieldName 字段名
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName)
            throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if (field != null) {
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 通过字段名给对象赋值
     *
     * @param obj       对象名称
     * @param fieldName 字段名
     * @param value     值
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName,
                                           Object value) throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        if (field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }
    }


}