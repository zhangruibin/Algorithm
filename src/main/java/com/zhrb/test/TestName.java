package com.zhrb.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName TestName
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/5 11:20
 * @Version
 */
public class TestName {
    private String first, last;
    public TestName(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public boolean equals(Object o) {
        TestName n = (TestName)o;
        return n.first.equals(first) && n.last.equals(last);
    }
    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new TestName("Mickey", "Mouse"));
        HashSet ss = new HashSet();
        ss.add(new TestName("Mickey", "Mouse"));
        Map s1 = new HashMap();
        TestName testName = null;
        s1.put(testName,new TestName("Mickey", "Mouse"));

        System.out.println(s.contains(new TestName("Mickey", "Mouse")));
        System.out.println(ss.contains(new TestName("Mickey", "Mouse")));
        System.out.println(s1.containsValue(new TestName("Mickey", "Mouse")));
    }
}
