package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by zhangrui on 2018/6/11.
 */
/*
* @ClassName ShellSort
*@Description TODO 希尔排序,就是将分组插入排序,百度百科上是这么解释的:
* 该方法实质上是一种分组插入方法
*比较相隔较远距离（称为增量）的数，使得数移动时能跨过多个元素，
*则进行一次比较就可能消除多个元素交换。D.L.shell于1959年在以他名字命名的排序算法中实现了这一思想。
*算法先将要排序的一组数按某个增量d分成若干组，每组中记录的下标相差d.对每组中全部元素进行排序，
*然后再用一个较小的增量对它进行，在每组中再进行排序。当增量减到1时，整个要排序的数被分成一组，排序完成。
*@Author zhangrui
*@Date 13:56 13:56
*@Version 
* */
public class ShellSort {
    public static void main(String[] args) {
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] tempArray = creatAIntArray.creatArrayLength();
        //生成的数组为
        System.out.println("生成的为排序前的数组为:"+ Arrays.toString(tempArray));
        //每次循环,削减步长
        for (int increment = tempArray.length / 2; increment > 0; increment /=2) {
            for (int i = 0; i <tempArray.length-increment; i++) {
                for (int j = i+increment;j<tempArray.length;j++){
                    if (tempArray[i] > tempArray[j]) {
                        int tempNum = tempArray[i];
                        tempArray[i] = tempArray[j];
                        tempArray[j] = tempNum;
                    }
                }
            }
            System.out.println("此次排序后的数组为:"+Arrays.toString(tempArray)+"此时的步长为:"+increment);
        }
    }
}
