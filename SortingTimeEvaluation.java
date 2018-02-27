/*
* File Name: Sort.java
* ID:103213025
* Author:李柏均
* Since 2015/9/25
* Toolkit: Notepad++
*/
import java.lang.Math;
public class SortingTimeEvaluation {
    //binary search
    public static boolean search(int[] data,int v) {
        int l = 0,r =data.length - 1;
        while (l <= r){
            int mid = (l + r)/2;
            if (data[mid] == v)
                return true;
            if (data[mid] <v)
                l = mid +1;
            else
                r = mid -1;
        }
        return false;
    }
    //insertion sort
    public static void sort(int[] data) {
        int n = data.length;
        //i代表insert的元素位置
        for(int i = 1;i<n; i++){
            int tmp = data[i];
            //j代表要比較的位置
            int j= i-1;
            while(j>=0&&data[j]>tmp){
                data[j+1] = data[j];
                j=j-1;
            }
            data[j+1] = tmp;
        }
    }
    //印出產生的亂數，此處無用先保留
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
            System.out.println();
        }
    }
    //檢查排序後的陣列是否有按照大小順序排列好
    public static boolean isSorted(int[] data) {
        for(int i = 0;i <data.length -1;i++) 
            if(data[i] > data[i+1])
                return false;
        return true;
    }
    public static void main(String[] argv){
        //宣告陣列
        int[] data = new int[1000000];
        long startTime,endTime;
        for(int i = 0;i < data.length;i++) 
            //important
            //random -> 0<a<1
            //所求1000000 則*1000000+1
            //0<=x*(b-a+1)<b-a+1
            //0<=(int)(x*(b-a+1))<=b-a
            //a<=a+(int)(x*(b-a+1))<=b
            //隨機取數
            data[i] = (int)(Math.random()*1000001);
        //記錄排序所需時間並印出
        startTime = System.currentTimeMillis();
        sort(data);
        endTime = System.currentTimeMillis();
        System.out.println("insertion sort:"+(endTime-startTime)+ "ms");
        isSorted(data);
        //記錄binary search找到5000所花的時間並印出
        long s,e;
        s= System.currentTimeMillis();
        search(data,5000);
        e= System.currentTimeMillis();
        System.out.println("binary search:"+(e-s)+ "ms");
    }
}
