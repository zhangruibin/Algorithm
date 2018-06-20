package com.zhrb.rankAlgorithm;

import com.zhrb.util.CreatAIntArray;

import java.util.Arrays;

/*
* @ClassName BucketSort
*@Description TODO 桶排序 BucketSort
* TODO 1.首先按照一定的自定义的映射规则,把一个待排序的数组,划分为N个小数组,这些小数组是宏观有序的;
* TODO 2.然后把每个小数组内部排列有序,这个排列过程使用的是其他的排序,比如快排之类的;
* TODO 3.最后当把每个小数组都排序好后,把这些小数组按照宏观有序的的顺序组合起来就是有序的大数组.
*@Author zhangrui
*@Date 15:31 15:31
*@Version 
* */
public class BucketSort {
    public static void main(String[] args) {
        CreatAIntArray creatAIntArray = new CreatAIntArray();
        int[] tempArray = creatAIntArray.creatArrayLength();
        System.out.println("排序前的数组为"+ Arrays.toString(tempArray));
        int[] afterBucketSort = bucketSort(tempArray);
        System.out.println("排序后的数组为"+ Arrays.toString(afterBucketSort));
    }
    public static int[] bucketSort(int[] arr){
        //1.首先将大数组数据进行分桶，这里采用映射关系为f(x)=x/100,也可以选择其他。
        int bucketCount =100;
        Integer[][] bucket = new Integer[bucketCount][arr.length];
        for (int i=0; i<arr.length; i++){
            //根据定义的映射函数来确定放在哪个桶里,在哪个桶就是二维数组的横向变量x坐标的值
            int x = arr[i]/bucketCount;
            for (int y=0; y<arr.length; y++){
                if (bucket[x][y]==null){
                    bucket[x][y]=arr[i];
                    break;
                }
            }
        }
        //2.然后,小桶排序,循环遍历每个桶,每遍历一个桶,将桶中的数字进行排序
        for (int i=0; i<bucket.length; i++){
            for (int j=1; j<bucket[i].length; ++j){
                if(bucket[i][j]==null){
                    break;
                }
                int value = bucket[i][j];
                int position=j;
                while (position>0 && bucket[i][position-1]>value){
                    bucket[i][position] = bucket[i][position-1];
                    position--;
                }
                bucket[i][position] = value;
            }

        }
        //3.最后将全部有序的小数组整合,就是有序的数组
        for (int x=0, index=0; x<bucket.length; x++){
            for (int y=0; y<bucket[x].length; y++){
                if (bucket[x][y]!=null){
                    arr[index] = bucket[x][y];
                    index++;
                }
                else{
                    break;
                }
            }
        }
        return arr;
    }
}
