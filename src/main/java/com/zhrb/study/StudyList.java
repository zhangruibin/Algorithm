package com.zhrb.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName StudyList
 * @Description TODO Study List
 * @Author Administrator
 * @Date 2019/6/27 14:59
 * @Version
 */
public class StudyList {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Name");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list.toString());
        //removeIf 的使用方法
        list.removeIf(next ->next.toString().indexOf("a")>0);
        System.out.println("===============removeIf 1====================");
        System.out.println(list.toString());
        //或者这样写
        Predicate<String> predicate = (s) -> s.equals("ddd");
        list.removeIf(predicate);
        System.out.println("===============removeIf 2====================");
        System.out.println(list.toString());
        List list2 = new LinkedList();
        list2.addAll(list);
        System.out.println("===================addAll================");
        System.out.println(list2.toString());
        List list3 = new LinkedList();
        list3.addAll(list);
        list3.clear();
        System.out.println("===================clear================");
        System.out.println(list3.toString());
        list3.addAll(list);
        list3.addAll(list);
        list3.removeAll(list2);
        System.out.println("===================removeAll 1================");
        System.out.println(list3.toString());
        List list4 = new LinkedList();
        list4.addAll(list);
        list2.add("test");
        System.out.println("===================removeAll 2================");
        System.out.println(list4.toString());
    }
}
