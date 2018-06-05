package com.zhrb.util;

import java.util.Scanner;

/**
 * Created by zhangrui on 2018/6/5.
 */
/*
* @ClassName CreatAIntArray
*@Description TODO
*@Author zhangrui
*@Date 17:30 17:30
*@Version 
* */
public class CreatAIntArray {
    public int[] creatArrayLength(){
        //设定键盘监听事件进行数组长度的定义
        System.out.println("-----请输入一个数字------");
        Scanner sc =new Scanner(System.in);
        String n = sc.next();
        int s = 0;
        for (s = 0;s<n.length();s++){
            //判断此位上是否是数字
            if (!Character.isDigit(n.charAt(s))){
                //此位上不是数字
                System.out.println("输入的不是数字!");
                return null;
            }
        }
        int length = Integer.parseInt(n.toString());
        System.out.println("定义的活动数组长度为:"+n);
        int[] tempArray = new int[length];
        int random = 0;
        int temoCount = 0;
        for (int i = 0;i< length;i++){
            random = (int) (Math.random()*length);
            if (random != tempArray[i]){
                tempArray[temoCount] = random;
                temoCount++;
            }
        }
        return tempArray;
    }
}
