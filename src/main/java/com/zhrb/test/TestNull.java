package com.zhrb.test;

/**
 * @ClassName TestNull
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/5 11:17
 * @Version
 */
public class TestNull {
    public static void greet() {
        System.out.println("Hello world!");
    }
    public static void main(String[] args) {
        //对象不是在声明的时候实例化，而是在调用的时候实例化
        TestNull x = null;
        x.greet(); //(1)
        ((TestNull)x).greet(); //(2)
        ((TestNull) null).greet(); //(3)
    }

}
