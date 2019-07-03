package com.zhrb.study;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName StudyConcurrentHashMap
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/2 10:25
 * @Version
 */
public class StudyConcurrentHashMap {

    private Map<Integer,Integer> cache =new ConcurrentHashMap<>(15);

    public static void main(String[]args) {
    StudyConcurrentHashMap ch = new  StudyConcurrentHashMap();
    //System.out.println(ch.fibonaacci(80));
        Map<Object,Object> map =new ConcurrentHashMap<>(15);
        Map map1 = new HashMap();
        map1.put(null,null);
        map1.put(null,1);
        System.out.println(map1.get(null));

    }

    public int fibonaacci(Integer i) {        
        if(i==0||i ==1) {                
            return i;        
        }
        return cache.computeIfAbsent(i,(key) -> {
            System.out.println("fibonaacci : "+key);
            return fibonaacci(key -1)+fibonaacci(key - 2);        
        });
    }

}
