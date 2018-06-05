package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

/**
 * Created by zhangrui on 2018/6/5.
 */
/*
* @ClassName BubbleSort
*@Description TODO 冒泡排序,JDK1.8中sort()
*@Author zhangrui
*@Date 16:45 16:45
*@Version 
* */
public class BubbleSort {
    public static void main(String[] args) {
        //先声明一个数组
        //int[] tempArray = {1,9,3,5,2,8,4};
        //调用其他类的方法,产生随机数组
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] tempArray = creatAIntArray.creatArrayLength();
        System.out.println("排序前的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
        //对数组进行循环,每次都是tempArray[i]与tempArray[i+1]进行比较
        for (int i = 0;i<tempArray.length-1;i++){
            //声明tempNum进行中间变量存储
            int tempNum = -1;
            for (int j = 0;j < (tempArray.length-i-1);j++){
                //如果tempArray[j]<tempArray[j+1],则置换两个存储位置上的数字
                if (tempArray[j]<tempArray[j+1]){
                    tempNum = tempArray[j];
                    tempArray[j] = tempArray[j+1];
                    tempArray[j+1] = tempNum;
                }
            }
        }
        System.out.println("排序后的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
    }
}
