package com.zhrb.test;

/**
 * @ClassName TestFinally
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/11 15:02
 * @Version
 */
public class TestFinally {
    public static void main(String args[]) {
        int num = 10;
        System.out.println(test(num));
    }
    public static int test(int b) {
        try {
            b += 10;
            return b++;
        } catch (Exception e2) {
        } finally {
            b += 10;
            //return b; //①
        }
        return b++; //②
    }

}
