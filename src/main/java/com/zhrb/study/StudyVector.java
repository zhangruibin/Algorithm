package com.zhrb.study;

import java.util.Vector;

/**
 * @ClassName StudyVector
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/1 10:29
 * @Version
 */
public class StudyVector {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("aaa");
        vector.add("666");
        putIfAbsent(vector,"666");
    }

    public static void putIfAbsent(Vector vector,Object object) {
        synchronized(vector) {
            if (!vector.contains(object)) {
                vector.add(object);
            }else {
                System.out.println("The vertor is contains the object of "+object.toString());
            }
        }
    }
}
