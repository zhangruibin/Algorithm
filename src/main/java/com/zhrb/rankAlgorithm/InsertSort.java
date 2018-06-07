package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

/**
 * Created by zhangrui on 2018/6/7.
 */
/*
* @ClassName InsertSort
*@Description TODO 插入排序,意思就是比较剩余无序数组的第一位,然后把第一位上的数字拿过来,跟前面的有序数组比较,插入合适的位置
*@Author zhangrui
*@Date 9:27 9:27
*@Version 
* */
public class InsertSort {
    public static void main(String[] args) {
        //调用工具包,生成随机数组
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] tempArray = creatAIntArray.creatArrayLength();
        //对生成的数组进行打印
        System.out.println("\n_______________________________________________________");
        System.out.println("排序前的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
        //生成随机无序数组后对该数组进行排序
        //因为是i与i-1上的数字进行比较,i-1最小要等于0,所以i的取值范围为i>=1
        //声明一个flag对循环排序次数进行存储
        int flag = 0;
        for (int i = 1;i < tempArray.length;i++){
            //循环第i次的时候,数组下标为i的跟下标为i-1的比较大小,每次比较都是跟第i位之前的比较.
            //声明中间变量
            int tempNum = -1;
            for (int j = i;j>0;j--){
                // 如果tempArray[j-1]>tempArray[j],则交换位置
                if (tempArray[j-1]>tempArray[j]){
                    tempNum = tempArray[j];
                    tempArray[j] = tempArray[j-1];
                    tempArray[j-1]= tempNum;
                }
                flag++;
                //对每次排序所得到的结果进行遍历输出展示
                System.out.println("经过第"+flag+"次排序后的数组为:");
                for(int num:tempArray){
                    System.out.print(num+" ");
                }
                System.out.println("\n_______________________________________________________");
            }
        }
        System.out.println("排序后的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
    }
}
