/*
* File Name: Sort.java
* ID:103213025
* Author:���f��
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
        //i�N��insert��������m
        for(int i = 1;i<n; i++){
            int tmp = data[i];
            //j�N��n�������m
            int j= i-1;
            while(j>=0&&data[j]>tmp){
                data[j+1] = data[j];
                j=j-1;
            }
            data[j+1] = tmp;
        }
    }
    //�L�X���ͪ��üơA���B�L�Υ��O�d
    public static void print(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
            System.out.println();
        }
    }
    //�ˬd�Ƨǫ᪺�}�C�O�_�����Ӥj�p���ǱƦC�n
    public static boolean isSorted(int[] data) {
        for(int i = 0;i <data.length -1;i++) 
            if(data[i] > data[i+1])
                return false;
        return true;
    }
    public static void main(String[] argv){
        //�ŧi�}�C
        int[] data = new int[1000000];
        long startTime,endTime;
        for(int i = 0;i < data.length;i++) 
            //important
            //random -> 0<a<1
            //�ҨD1000000 �h*1000000+1
            //0<=x*(b-a+1)<b-a+1
            //0<=(int)(x*(b-a+1))<=b-a
            //a<=a+(int)(x*(b-a+1))<=b
            //�H������
            data[i] = (int)(Math.random()*1000001);
        //�O���Ƨǩһݮɶ��æL�X
        startTime = System.currentTimeMillis();
        sort(data);
        endTime = System.currentTimeMillis();
        System.out.println("insertion sort:"+(endTime-startTime)+ "ms");
        isSorted(data);
        //�O��binary search���5000�Ҫ᪺�ɶ��æL�X
        long s,e;
        s= System.currentTimeMillis();
        search(data,5000);
        e= System.currentTimeMillis();
        System.out.println("binary search:"+(e-s)+ "ms");
    }
}
