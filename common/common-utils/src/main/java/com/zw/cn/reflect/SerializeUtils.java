package com.zw.cn.reflect;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SerializeUtils {

    private static Log log = LogFactory.getLog(SerializeUtils.class);

    public static Map<byte[], byte[]> getBytesMap(Object bean) {
        Map<String, Object> map = ReflectUtils.describe(bean);
        Map<byte[], byte[]> retMap = new HashMap<byte[], byte[]>();
        for (String key : map.keySet()) {
            Object value = map.get(key);

            if (value instanceof Serializable) {
                retMap.put(key.getBytes(), serialize(map.get(key)));
            } else {
                log.warn("bean :" + bean.getClass().getSimpleName() + " field:" + key + " do not implements serializable!");
            }
        }
        return retMap;
    }

    public static byte[] serialize(Object obj) {
        byte[] bytes = null;

        if (!(obj instanceof Serializable)) {
            return null;
        }
        ByteArrayOutputStream bo = null;
        ObjectOutputStream oo = null;
        try {
            // object to bytearray
            bo = new ByteArrayOutputStream();
            oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            oo.flush();
            bytes = bo.toByteArray();

            bo.flush();
        } catch (Exception e) {
            log.error("translation byte[]: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeStream(bo, oo);
        }
        return bytes;
    }

    @SuppressWarnings("unchecked")
    public static <T> T deSerialize(byte[] bytes) {
        Object obj = null;
        ByteArrayInputStream bi = null;
        ObjectInputStream oi = null;
        try {
            // bytearray to object
            bi = new ByteArrayInputStream(bytes);
            oi = new ObjectInputStream(bi);

            obj = oi.readObject();

        } catch (Exception e) {

            log.error("Failed to deserialize object type: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeStream(bi, oi);
        }
        return (T) obj;
    }

    public static Map<String, Object> byteMapToMap(Map<byte[], byte[]> properties) {
        Map<String, Object> map = new HashMap<>();

        for (byte[] key : properties.keySet()) {
            String str = new String(key);
            Object value = deSerialize(properties.get(key));

            map.put(str, value);
        }
        return map;
    }

    public static Map<byte[], byte[]> mapToByteMap(Map<String, ?> map) {
        Map<byte[], byte[]> retMap = new HashMap<byte[], byte[]>();
        for (String key : map.keySet()) {
            Object value = map.get(key);

            if (value instanceof Serializable) {
                retMap.put(key.getBytes(), serialize(map.get(key)));

            } else {
                log.warn(" field:" + key + " do not implements serializable!");
            }
        }
        return retMap;
    }

    public static <T> T populate(T bean, Map<byte[], byte[]> properties) {
        try {

            Map<String, Object> map = byteMapToMap(properties);

            BeanUtils.populate(bean, map);

            return bean;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            log.error("not writable method:" + e.getCause());
        }
        return null;
    }

    public static <T> T populate(Class<T> beanClass, Map<byte[], byte[]> properties) {
        try {
            T bean = beanClass.newInstance();
            return populate(bean, properties);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            log.error("not default constructor!" + e.getCause());
        }
        return null;
    }


    private static void closeStream(OutputStream fristStream, OutputStream secondStream) {
        try {
            if (fristStream != null)
                fristStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (secondStream != null)
                try {
                    secondStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private static void closeStream(InputStream fristStream, InputStream secondStream) {
        try {
            if (fristStream != null)
                fristStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (secondStream != null)
                try {
                    secondStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
