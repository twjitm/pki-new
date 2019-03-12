package com.pki.utils;


import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author twjitm
 */
public class ZStringUtil {

    /**
     * 默认的文本分隔符
     */
    public static final String Default_Split = "#";

    /**
     * 判断字符串是否为空
     *
     * @param string
     */
    public static boolean isEmptyStr(String string) {
        if (string == null || "".equals(string.trim())) {
            return true;
        }
        return false;
    }


    /**
     * 自定义格式输出文本{0} {1}
     *
     * @param s
     * @param objects
     */
    public static String format(String s, Object... objects) {
        if (objects != null && objects.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            sb.append("{").append(i).append("}");
            int j = s.indexOf(sb.toString());
            while (j >= 0) {
                if (i < objects.length) {
                    s = s.replace(sb.toString(), objects[i] == null ? "" : objects[i].toString());
                }
                i++;
                sb = new StringBuilder();
                sb.append("{").append(i).append("}");
                j = s.indexOf(sb.toString());
            }
        }
        return s;
    }

    /**
     * 获取拼起来的key
     *
     * @param splitString
     * @param strings
     * @return
     */
    public static String getString(String splitString, String... strings) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
            if (i == strings.length - 1) {
                break;
            }
            stringBuffer.append(splitString);
        }
        return stringBuffer.toString();
    }

    public static int[] splitToIntArray(String input, String separator) {

        String[] items = StringUtils.split(input, separator);
        if (items == null) {
            return new int[0];
        }
        int[] ints = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            if (!StringUtils.isEmpty(items[i])) {
                ints[i] = Integer.parseInt(items[i]);
            }

        }
        return ints;

    }

    public static long[] splitToLongArray(String input, String separator) {

        String[] items = StringUtils.split(input, separator);
        if (items == null) {
            return new long[0];
        }
        long[] longs = new long[items.length];
        for (int i = 0; i < items.length; i++) {
            if (!StringUtils.isEmpty(items[i])) {
                longs[i] = Long.parseLong(items[i]);
            }

        }
        return longs;

    }

    public static double[] splitToDoubleArray(String input, String separator) {
        String[] items = StringUtils.split(input, separator);
        if (items == null) {
            return new double[0];
        }
        double[] doubles = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            if (!StringUtils.isEmpty(items[i])) {
                doubles[i] = Double.parseDouble(items[i]);
            }
        }
        return doubles;
    }

    public static int[][] splitToIntArray2D(String data, String outerSplit, String innerSplit) {
        String[] items = StringUtils.split(data, outerSplit);
        if (items == null) {
            return new int[0][];
        }
        int[][] values = new int[items.length][];
        for (int i = 0; i < items.length; i++) {
            int[] s = splitToIntArray(items[i], innerSplit);
            values[i] = s;
        }
        return values;
    }

    public static Map<Integer, Integer> splitToIntMap(String input, String outerSplit, String innerSplit) {
        String[] strs = StringUtils.split(input, outerSplit);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        if (strs == null) {
            return map;
        }
        for (String str : strs) {
            String[] innerStr = StringUtils.split(str, innerSplit);
            if (innerStr.length == 2) {
                map.put(Integer.valueOf(innerStr[0]), Integer.valueOf(innerStr[1]));
            }
        }

        return map;
    }

    public static Map<Integer, Long> splitToIntLongMap(String input, String outerSplit, String innerSplit) {
        String[] strs = StringUtils.split(input, outerSplit);
        Map<Integer, Long> map = new LinkedHashMap<>();
        if (strs == null) {
            return map;
        }
        for (String str : strs) {
            String[] innerStr = StringUtils.split(str, innerSplit);
            if (innerStr.length == 2) {
                map.put(Integer.valueOf(innerStr[0]), Long.valueOf(innerStr[1]));
            }
        }

        return map;
    }

    public static Map<Integer, Double> splitToIntDoubleMap(String input, String outerSplit, String innerSplit) {
        String[] strs = StringUtils.split(input, outerSplit);
        Map<Integer, Double> map = new LinkedHashMap<>();
        if (strs == null) {
            return map;
        }
        for (String str : strs) {
            String[] innerStr = StringUtils.split(str, innerSplit);
            if (innerStr.length == 2) {
                map.put(Integer.valueOf(innerStr[0]), Double.valueOf(innerStr[1]));
            }
        }

        return map;
    }

    public static Map<String, Integer> splitToStringIntMap(String input, String outerSplit, String innerSplit) {
        String[] strs = StringUtils.split(input, outerSplit);
        Map<String, Integer> map = new LinkedHashMap<>();
        if (strs == null) {
            return map;
        }
        for (String str : strs) {
            String[] innerStr = StringUtils.split(str, innerSplit);
            if (innerStr.length == 2) {
                map.put(innerStr[0], Integer.valueOf(innerStr[1]));
            }
        }

        return map;
    }

    public static List<Map<Integer, Integer>> splitToIntKVList(String input, String outerSplit, String innerSplit) {
        String[] strs = StringUtils.split(input, outerSplit);
        List<Map<Integer, Integer>> kvList = new ArrayList<>();
        if (strs == null) {
            return kvList;
        }
        for (String str : strs) {
            String[] innerStr = StringUtils.split(str, innerSplit);
            if (innerStr.length == 2) {
                kvList.add(new HashMap<>(Integer.parseInt(innerStr[0]), Integer.valueOf(innerStr[1])));
            }
        }
        return kvList;
    }

    public static List<Integer> splitToIntList(String input, String s) {
        String[] items = StringUtils.split(input, s);
        if (items == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (!StringUtils.isEmpty(items[i])) {
                list.add(Integer.parseInt(items[i]));
            }

        }
        return list;
    }

    public static List<Long> splitToLongList(String input, String s) {
        String[] items = StringUtils.split(input, s);
        if (items == null) {
            return Collections.emptyList();
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (!StringUtils.isEmpty(items[i])) {
                list.add(Long.parseLong(items[i]));
            }

        }
        return list;
    }

    /**
     * 效率高于java原生自带的分割算法
     */
    public static List<String> split(String input, String s) {
        String[] items = StringUtils.split(input, s);
        if (items == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(items);
    }
}
