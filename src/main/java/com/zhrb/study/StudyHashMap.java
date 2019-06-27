package com.zhrb.study;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

/**
 * @ClassName StudyHashMap
 * @Description TODO Read hash map resource base on Jdk1.8
 * @Author Administrator
 * @Date 2019/6/26 9:44
 * @Version
 */
public class StudyHashMap {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>(8);
        map.put("name", "RebornChang");
        map.put("gender", "男");
        map.put("phone", "18888888888");
        map.put(null, null);
        //1.Map的迭代
        // 通用的Map迭代方式
        System.out.println("==============Map的迭代======================");
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        System.out.println("====================================");
        // JDK8的迭代方式
        map.forEach((key, value) -> {
            System.out.println(key + "：" + value);
        });
        //2.Map的比较器
        //comparingByKey
        //comparingByValue
        //public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey() {
        //    return (Comparator<Map.Entry<K, V>> & Serializable)
        //            (c1, c2) -> c1.getKey().compareTo(c2.getKey());
        //}
        //public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
        //    return (Comparator<Map.Entry<K, V>> & Serializable)
        //            (c1, c2) -> c1.getValue().compareTo(c2.getValue());
        //}
        System.out.println("==================Map的比较器==================");
        Map<Object, Object> map2 = new ConcurrentHashMap<>();
    }



}
