package com.zhrb.study;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName StudyIntAndInteger
 * @Description TODO Integer拆包封包，重写System.out.println
 * @Author Administrator
 * @Date 2019/7/1 14:49
 * @Version
 */
public class StudyIntAndInteger {
    public static void main(String[] args) {

        Integer a = 4;
        Integer b = 5;

        method(a, b);
        System.out.println("a=" + a + " b=" + b);
        System.out.println("hello world");

        int a1 = 4;
        int b1 = 5;

        method2(a1, b1);
        System.out.println("a1=" + a1 + " b1=" + b1);
        System.out.println("hello world");
    }
    public static void method(Integer a,Integer b) {
        try {
            //integer的构造方法默认变量时value
            Field field = Integer.class.getDeclaredField("value");
            //允许改变
            field.setAccessible(true);
            field.set(a, 400);
            field.set(b, 500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void method2(int a,int b) {
        try {
            PrintStream printStream = new PrintStream(System.out){
              @Override
              public void   println(String x){
                  if (x.startsWith("a1")){
                      super.println(x+"00");
                  }
                  if (x.startsWith("b1")){
                      super.println(x+"00");
                  }
              }
            };
            System.setOut(printStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
