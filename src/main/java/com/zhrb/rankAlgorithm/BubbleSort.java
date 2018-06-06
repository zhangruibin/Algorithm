package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

/**
 * Created by zhangrui on 2018/6/5.
 */
/*
* @ClassName BubbleSort
*@Description TODO 冒泡排序,本节介绍两种写法,一种是从前到后遍历,一种是从后往前遍历
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
        //定义一种
        int[] tempArray2 = tempArray;
        System.out.println("排序前的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
        //对数组进行循环,每次都是tempArray[i]与tempArray[i+1]进行比较
        //对第一种排序方式进行统计
        int count = 0;
        //对第二种排序方式进行统计
        int count2 = 0;
        for (int i = 0;i<tempArray.length-1;i++){
            //声明tempNum进行中间变量存储
            int tempNum = -1;
            int tempNum2 = -1;
            //第一种排序
            for (int j = 0;j < (tempArray.length-i-1);j++){
                //如果tempArray[j]<tempArray[j+1],则置换两个存储位置上的数字
                //全部轮询过后把最小的放到最后面
                if (tempArray[j]<tempArray[j+1]){
                    tempNum = tempArray[j];
                    tempArray[j] = tempArray[j+1];
                    tempArray[j+1] = tempNum;
                }
                //不变
                count++;
                System.out.println("\n经第一种的第"+(count)+"次排序方式,此趟排序后,数组为:");
                for(int num:tempArray){
                    System.out.print(num+" ");
                }
            }
            //第二种排序,从后往前比较,内部第一轮比较后,可以实现:最小值在最后面,最大值在最前面,所以每次去头去尾比较内部
            for (int j = (tempArray.length-i-2);j >= i;j--){
                //如果tempArray[j]<tempArray[j+1],则置换两个存储位置上的数字
                System.out.println("\n此时第"+(j+1)+"位上的数字跟第"+(j+2)+"位上的数字比较");
                if (tempArray2[j]<tempArray2[j+1]){
                    tempNum2 = tempArray2[j];
                    tempArray2[j] = tempArray2[j+1];
                    tempArray2[j+1] = tempNum2;
                    System.out.println("第"+(j+1)+"位上的数字与第"+(j+2)+"上的数字交换位置");
                }
                count2++;
                System.out.println("\n经第二种的第"+(count2)+"次排序方式此趟排序后,数组为:");
                for(int num2:tempArray2){
                    System.out.print(num2+" ");
                }
            }
        }
        System.out.println("第一种循环次数为:"+count);
        System.out.println("经过第一种排序后的数组为:");
        for(int num:tempArray){
            System.out.print(num+" ");
        }
        System.out.println("\n_______________________________________________________");
        System.out.println("第二种循环次数为:"+count2);
        //循环次数为(奇数时),(N-1)+(N-2-1)+(N-4-1)+(N-6-1)+...+(N-2n+1)=nN-N²((N=n/2)+1);
        //循环次数为(奇数时),(N-1)+(N-2-1)+(N-4-1)+(N-6-1)+...+(N-2n+1)=nN-N²(N=n/2);
        System.out.println("经过第二种排序后的数组为:");
        for(int num2:tempArray2){
            System.out.print(num2+" ");
        }
        System.out.println("\n_______________________________________________________");
    }
}
