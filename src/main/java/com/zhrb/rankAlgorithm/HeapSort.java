package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

import java.util.Arrays;

/*
* @ClassName HeapSort
*@Description TODO 堆排序 思想分为三步:
* TODO 1:构造出一个大顶堆,或者小顶堆.
* TODO 2:将大顶堆/(小顶堆)的堆顶数字跟堆底元素交换位置,然后把堆底元素除去,当成新数组.
* TODO 3:重复执行第一步和第二步.
*@Author zhangrui
*@Date 14:15 14:15
*@Version 
* */
public class HeapSort {
    public static void main(String[] args) {
        //输入数字,生成随机数组
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] tempArray = creatAIntArray.creatArrayLength();
        //对生成的数组进行打印
        System.out.println("排序前:"+Arrays.toString(tempArray));
        //第一步,构造出一个大顶堆
        int i = 0;
        int length = tempArray.length;
        for(i=tempArray.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            creatBigHeap(tempArray,i,length);
        }
        //第二步,将大顶堆的堆顶数字跟堆底元素交换位置,然后继续调用第一步,把除了沉到底部的其他部分堆,再构成一个大顶堆,然后再执行此步
        //所以,应该是递归
        for(int j=tempArray.length-1;j>0;j--){
           //将堆顶元素与末尾元素进行交换
            int temp = tempArray[0];
            tempArray[0] = tempArray[j];
            tempArray[j] = temp;
            //重新对堆进行调整
            creatBigHeap(tempArray,0,j);
        }
        //对排序后的数组进行输出打印
        System.out.println("排序后:"+Arrays.toString(tempArray));
    }
    public static void creatBigHeap(int[] tempArray,int i,int length){
        for (int j = 2*i+1;j < length;j=2*j+1){
            if(j+1<length && tempArray[j]<tempArray[j+1]){
                j++;
            }
            //如果子节点数值大于父节点数值,则交换父子位置
            if(tempArray[j] > tempArray[i]){
                int tempNum = tempArray[i];
                tempArray[i] = tempArray[j];
                tempArray[j] = tempNum;
                //交换过位置后,此时的临时堆堆顶下标变化
                i = j;
            }
        }
    }
}
