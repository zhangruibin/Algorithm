package com.zhrb.rankAlgorithm;


import java.util.Scanner;

/*
* @ClassName SelectionSort
*@Description TODO 选择排序,简单排序
*@Author zhangrui
*@Date 15:31 15:31
*@Version 
* */
public class SelectionSort {
    /*/**
    * @author zhangrui
    * @Description  选择排序的核心思想是交换位置,找到数组的最小值放到首位,
    * 然后对除了首位的剩下的数组在此找到最小值放到第二个位置,以此类推
    * @Date 15:57 2018/6/4
    * @Param [args]
    * @returu void
    **/
    public static void main(String[] args) {
        //先生成动态生成数组的长度
        int arrayLength = creatArrayLength();
        //然后对arrayLength值进行判断,正确的话调用指定的排序方法进行排序
        switch (arrayLength){
            case -1:
                break;
            case 0:
                break;
            default:
                System.out.println("---------开始排序-------");
                simpleSelectSort(arrayLength);
                System.out.println("---------结束排序-------");
        }
    }
    /*/**
    * @author zhangrui
    * @Description  选择排序
    * @Date 11:22 2018/6/5
    * @Param [arrayLength] 传入int类型的值,为所要排序的数组的长度
    * @returu void
    **/
    public static void simpleSelectSort(int arrayLength){
        int[] oldArray = new int[arrayLength];
        int random = 0;
        int temoCount = 0;
        for (int i = 0;i< arrayLength;i++){
            random = Integer.parseInt((Math.random()*10+"").substring(0,(Math.random()*10+"").indexOf(".")));
            if (random != oldArray[i]){
                oldArray[temoCount] = random;
                temoCount++;
            }
        }
        System.out.println("排序前的数组为:");
        for(int num:oldArray){
            System.out.print(num+" ");
        }
        //生成了排序前的数组,下面开始使用选择排序进行数字的大小排序
        //声明一个z进行标志是第几轮排序,因为:
        // 第一轮把整个数组里面的最小值找到了放在了第一位,
        // 第二轮只需要找到除第一位之外后面的数组所存储的最小值,以此类推.
        int z = 0;
        //声明一个flag对循环排序次数进行存储
        int flag = 1;
        // 做第i趟排序
        for(int i = 0; i < oldArray.length - 1; i++) {
            z = i;
            //对排除了相对最小值的数组在此进行循环取剩下数组中的最小值
            for(int j = z + 1; j < oldArray.length; j++){
                if(oldArray[j] < oldArray[z]){
                    //最小值是oldArray[j],这时最小值的存储下标是j
                    z = j;
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            //交换a[i]和a[z]的位置,oldArray[z]为第i轮外层循环的最小值,这时候前i-1位都是排序好的,所以把相对小的放在第i位
            if(i != z){
                int temp = oldArray[i];
                oldArray[i] = oldArray[z];
                oldArray[z] = temp;
            }
            //else就是i=z的时候,这就是最后一轮,最后一轮里只剩下最大的数在队尾,所以不用操作
            //计数器加一
            flag++;
            //对每次排序所得到的结果进行遍历输出展示
            System.out.println("\n经过第"+(i+1)+"次排序后的数组为:");
            for(int num:oldArray){
                System.out.print(num+" ");
            }
        }
        //存储到新数组中
        System.out.println("\n最终排序后的数组为:");
        for(int num:oldArray){
            System.out.print(num+" ");
        }
        System.out.println("\n循环的次数为:"+flag+"次.");
    }
    /*/**
    * @author zhangrui
    * @Description 设定键盘监听事件,返回值为int类型,输入的为非int类型的话,返回-1,为0的话返回0,为int的话返回一个int值
    * @Date 11:23 2018/6/5
    * @Param []
    * @returu int
    **/
    public static int creatArrayLength(){
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
                return -1;
            }
        }
            int length = Integer.parseInt(n.toString());
            System.out.println("定义的活动数组长度为:"+n);
            return length;
    }
}
