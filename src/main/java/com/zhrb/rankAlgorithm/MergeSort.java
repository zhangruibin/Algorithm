package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

import java.util.Arrays;

/*
* @ClassName MergeSort
*@Description TODO 归并排序,把一个数组二分形式拆分成最小单位,然后每个最小单位排序,再跟同级单位组合
*@Author zhangrui
*@Date 14:38 14:38
*@Version 
* */
public class MergeSort {
    public static void main(String []args){
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] arr = creatAIntArray.creatArrayLength();
        System.out.println("排序前_________________");
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后_________________");
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int []arr){
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int []temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            //左边归并排序，使得左子序列有序
            sort(arr,left,mid,temp);
            //右边归并排序，使得右子序列有序
            sort(arr,mid+1,right,temp);
            //将两个有序子数组合并操作
            merge(arr,left,mid,right,temp);
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid+1;
        //临时数组指针
        int t = 0;
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while(i<=mid){
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while(j<=right){
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
