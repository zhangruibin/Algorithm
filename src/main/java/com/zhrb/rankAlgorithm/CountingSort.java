package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by zhangrui on 2018/6/14.
 */
/*
* @ClassName CountingSort
*@Description TODO 计数排序 1:先声明一排有序的空桶.
* TODO 2:每个桶代表一个数字,然后对要排序的数组进行遍历,每遍历一个数,把这个数字放入到对应的桶里.
* TODO 3:遍历完毕后,按序查桶即为排好顺序.
* TODO 很重要的一点,怎样有效率的声明桶数量来代表的待排序数组最小值和最大值?
*@Author zhangrui
*@Date 14:38 14:38
*@Version 
* */
public class CountingSort {
    public static void main(String[] args) {
        //创建一个随机的数组
        int [] tempArray = new CreatAIntArray().creatArrayLength();
        //对生成的数组进行输出
        System.out.println("排序前的数组为:"+Arrays.toString(tempArray));
        //开始声明桶,找到数组的最小值和最大值
        int minNum = tempArray[0];
        int maxNum = tempArray[0];
        for (int i = 0;i < tempArray.length;i++){
            if (tempArray[i] < minNum){
                minNum = tempArray[i];
            }
            if (tempArray[i] > maxNum){
                maxNum = tempArray[i];
            }
        }
        System.out.println("最小数字为:"+minNum);
        System.out.println("最大数字位:"+maxNum);
        //找到最大最小值的之后,就开始声明有序桶,桶的初始位代表的值为minNum最大值为maxNum
        //数组的长度为(maxNum-minNum+1)
        int[] bucketArray = new int[(maxNum-minNum+1)];
        //声明了有序桶之后,开始对数字进行放桶操作
        for (int j = 0;j < tempArray.length;j++){
            //因为是找到了待排序数组的最小值minNum,所以,与数组数组比较的值应为(j+minNum)
            //如果遍历的值大小与数组代表的数字大小相等,则放入
            //j次循环得到的数字是tempArray[j],则存储到下标为tempArray[j]+minNum的桶中
            bucketArray[tempArray[j]-minNum] = bucketArray[tempArray[j]-minNum]+1;
        }
        //将得到的桶排序结果进行输出,输出的是桶排序的数组的下标
        //可以声明新数组对该序列进行存储
        int[] finalArray = new int[tempArray.length];
        int count = 0;
        for (int k = 0;k < bucketArray.length;k++){
            if (bucketArray[k] != 0){
                //桶里装的值可能不是1,所以,在不等于一的时候,对桶里面的数字进行遍历存储
                if (bucketArray[k]!= 1){
                    for (int z = 0;z < bucketArray[k];z++){
                        finalArray[count] = k+minNum;
                        count++;
                    }
                }else {
                    finalArray[count] = k+minNum;
                    count++;
                }
            }
        }
        System.out.println("排序后的数组为:"+Arrays.toString(finalArray));
    }
}
