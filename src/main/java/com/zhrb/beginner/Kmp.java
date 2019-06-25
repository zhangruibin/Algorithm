package com.zhrb.beginner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Kmp
 * @Description TODO
 * @Author Administrator
 * @Date 2019/6/25 10:00
 * @Version
 */
public class Kmp {


    public static void main(String[] args){
        String a = "ABCDABD";
        String b = "BBC ABCDAB ABCDABCDABDE";
        //1.首先计算出 部分匹配表
        int[] next = kmpnext(a);
        //2.然后拿字符串和总串以及匹配表去进行匹配
        int result = kmp(b, a,next);
        //打印匹配表数组
        System.out.println(Arrays.toString(next));
        //打印结果：和字符串获得匹配的位置
        System.out.println("resultPosion:"+result);
    }
    //计算出 部分匹配表
    public static int[] kmpnext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length(); i++){
            while(j > 0 && dest.charAt(j) != dest.charAt(i)){
                j = next[j - 1];
            }
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    //str文本串  dest 模式串
    public static int kmp(String str, String dest,int[] next){
        for(int i = 0, j = 0; i < str.length(); i++){
            while(j > 0 && str.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == dest.charAt(j)){
                j++;
            }
            if(j == dest.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static List<Integer> reKpm(String a,String b,int result,int[] next){
        List<Integer> resultList = new ArrayList<>();
        String tempStr = "";
        int tempResult = -1;
        if (result >= 0 && a.length()+2*result < b.length()){
            resultList.add(result);
            tempStr = b.substring(a.length()+result);
            tempResult = kmp(tempStr, a,next);
        }
        return resultList;
    }

}
