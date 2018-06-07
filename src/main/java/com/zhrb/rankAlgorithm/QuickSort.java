package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

/**
 * Created by zhangrui on 2018/6/7.
 */
/*
* @ClassName QuickSort
*@Description TODO 快速排序,QuickSort,找基准点1,然后以这个基准点1为准,找基准点1应该在的位置,
* TODO 这个位置上,基准点1左面的数都小于这个基准点1,基准点1右面的数都大于这个基准点1.
* TODO 然后再从基准点1的左面序列找到一个基准点21,在基准点1的右面找到一个基准点22.
* TODO 然后再次进行找基准点排序,递归,最后得到的就是有序数组
*@Author zhangrui
*@Date 10:56 10:56
*@Version 
* */
public class QuickSort {
    public static void main(String[] args) {
        //调用工具类生成数组
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] tempArray = creatAIntArray.creatArrayLength();
        //对生成的数组进行打印
        System.out.println("\n_______________________________________________________");
        System.out.println("排序前的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
        //快排
        quickSort(tempArray,0,tempArray.length-1);
        System.out.println("排序后的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
    }
    /*/**
    * @author zhangrui
    * @Description //因为是递归,所以另写一个方法,然后以备递归调用
    * @Date 11:19 2018/6/7
    * @Param [tempArray, index, end]
    * @returu void
    **/
    public static void quickSort(int []tempArray,int index,int end){
        //开始使用快速排序对随机生成的数组进行排序
        //第一步找基准点1,定义第一个数为基准点1
        //开始从两端开始比较,比flag1大的数都放在右半边,比flag1小的数都放在左半边
        if (index>end){
            //结束标志
            return;
        }
        int i = index;
        int j = end;
        int flag = tempArray[i];
        // 从表的两端交替向中间扫描
        while (i < j) {
            //因为基准选的是左端首位,所以要右端的先执行,即,先对j进行循环
            while (i < j && tempArray[j] > flag)
                j--;
            if (i < j)
                // 用比基准小的值替换低位值
                tempArray[i++] = tempArray[j];
            while (i < j && tempArray[i] < flag)
                i++;
                // 用比基准大的值替换高位值
            if (i < j)
                tempArray[j--] = tempArray[i];
        }
        tempArray[i] = flag;// 一次遍历后,把
        quickSort(tempArray, index, i - 1);
        quickSort(tempArray, i + 1, end);
    }
}
