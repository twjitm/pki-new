package com.pki.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author twjitm
 */
public class ZCollectionUtil {

    /**
     * 截取某列表的部分数据
     *
     * @param <T>
     * @param list
     * @param skip
     * @param pageSize
     */
    public static <T> List<T> getSubListPage(List<T> list, int skip, int pageSize) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int startIndex = skip;
        int endIndex = skip + pageSize;
        if (startIndex > endIndex || startIndex > list.size()) {
            return null;
        }
        if (endIndex > list.size()) {
            endIndex = list.size();
        }
        return list.subList(startIndex, endIndex);
    }

    /**
     * 通过远程URL获取本地IP地址
     *
     * @param urlCanGainIp
     */
    public static String getInetIpAddress(String urlCanGainIp) {
        InputStream in = null;
        try {
            URL url = new URL(urlCanGainIp);
            in = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "", ip = null;
            while ((line = reader.readLine()) != null) {
                ip = parseIpAddress(line);
                if (!ZStringUtil.isEmptyStr(ip)) {
                    return ip;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 判断某个地址是否是IP地址
     *
     * @param content
     */
    public static boolean isIpAddress(String content) {
        String rt = parseIpAddress(content);
        if (!ZStringUtil.isEmptyStr(rt)) {
            if (rt.equals(content)) {
                return true;
            }
        }
        return false;
    }

    /*
     * 解释IP地址
     */
    private static String parseIpAddress(String content) {
        String regexIp = "((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]\\d|[1-9])";
        Pattern pattern = Pattern.compile(regexIp);
        Matcher matcher = pattern.matcher(content);
        String rt = null;
        while (matcher.find()) {
            rt = matcher.group();
        }
        return rt;
    }



    private static Field[] getAllFields(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] rt = null;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] tmp = clazz.getDeclaredFields();
            rt = combine(rt, tmp);
        }
        return rt;
    }

    private static Field[] combine(Field[] a, Field[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Field[] rt = new Field[a.length + b.length];
        System.arraycopy(a, 0, rt, 0, a.length);
        System.arraycopy(b, 0, rt, a.length, b.length);
        return rt;
    }

    private static Object getFieldsValueObj(Object obj, String fieldName) {
        Field field = getDeclaredField(obj, fieldName);
        field.setAccessible(true);
        try {
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Field getDeclaredField(Object object, String fieldName) {
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (Exception e) {
            }
        }
        return null;
    }

    private static Method getSetMethod(Object object, String method, Class<?> fieldType) {
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                return clazz.getDeclaredMethod(method, fieldType);
            } catch (Exception e) {
            }
        }
        return null;
    }


    private static String buildSetMethod(String fieldName) {
        StringBuffer sb = new StringBuffer("set");
        if (fieldName.length() > 1) {
            String first = fieldName.substring(0, 1);
            String next = fieldName.substring(1);
            sb.append(first.toUpperCase()).append(next);
        } else {
            sb.append(fieldName.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 判断某个list是否没有数据
     *
     * @param <T>
     * @param list
     * @return
     */
    public static <T> boolean isEmpty(List<T> list) {
        boolean b = false;
        if (list == null || list.isEmpty()) {
            b = true;
        }
        return b;
    }

    /**
     * 判断一个map是否为空
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<Object, Object> map) {
        boolean b = false;
        if (map == null || map.isEmpty()) {
            b = true;
        }
        return b;
    }

}
