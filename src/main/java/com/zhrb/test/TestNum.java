package com.zhrb.test;

/**
 * @ClassName TestNum
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/4 11:30
 * @Version
 */
public class TestNum {
    public static void main(String[] args) {
        System.out.println(12345+5432L);
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x99)
                System.out.print("Found it!");
        }
        String taobao = "taobao";
        taobao += "ali";
        System.out.println(taobao.intern());
        /*String s = new String("1") + new String("2");
        System.out.println(s.intern() == s);

        */
        System.out.println("--------------------------");
        test();
        test1();
    }
    public static void test(){
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("2") + new String("2");
        String s4 = "22";
        s3.intern();
        System.out.println(s3 == s4);
    }

    public static void test1(){
        String s11 = new String("3");
        s11.intern();
        String s22 = "3";
        System.out.println(s11 == s22);

        String s33 = new String("4") + new String("4");
        s33.intern();
        String s44 = "44";
        System.out.println(s33 == s44);
    }
    /*
    * 根据输出结果我们应该这样理解：JDK1.8的情况下，intern是将String对象的值，从堆中拷贝到常量池中。
    * 为什么会的出来这个结论？
    * 首先我们要理解下String类型的 == 比较比较的是什么，比较的是两个Sting类型的字符串编码是否一样吗？No。
    * String类型的==比较，比较的是String对象的引用是否是同一个。
    * 那么接下来的问题就比较好理解了，先从test()方法来看：
    * test()方法中，String s = new String("1")的执行过程是：
    * 1.先在堆中创建了一个对象，这个对象的值为"1"，然后将这个对象指向s.
    * 2.String s2 = "1"的执行过程是在常量池中创建一个值为"1"的String字符，此时它的引用是s2。
    * 3.s.intern();是将在堆中存储的对象"1"拷贝到常量池中，此时在堆中有两个对象"1"引用为s以及另一个"1"引用为s2.
    * 4.对s和s2两个对象进行比较，得到堆中两个不同存储位的索引，则比较结果为false。
    *同理，test()方法s3是在堆中创建了两个"1"将两个"1"的存储合并起来定义为s3，然后在常量池中创建了一个"11"的值定义为s4.
    * 然后将在堆中的对象拷贝到常量池中，此时
    **/
}
