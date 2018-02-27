/*
* File Name:Sorted Permutation.java
* ID:103213025
* Author:李柏均
* Since 2015/10/11
* Toolkit: Notepad++
*/
import java.util.Scanner;
public class SortedPermutation{
    //列出datat所有的排列
    public static void perm(char[] data) {
        perm(data,0);
    }
    //data:要排列的陣列
    //pos:由pos這個位置以後的元素作排列
    public static  void perm(char[] data,int pos) {
        //終止條件
        if(pos == data.length-1) {
            for (int i = 0;i < data.length;i++)
                System.out.print(data[i]);
            System.out.println();
            return;
        }
        //化簡
        //由pos~data.length - 1之間的元素任挑一個放到pos位置上
        for(int i = pos; i < data.length;i++) {
        //先用插入法
            char tmp = data[i];
            for (int j = i;j > pos;j--)
                data[j] = data[j-1];
            data[pos] = tmp;
            perm(data,pos+1);
            tmp = data[pos];
            for (int j = pos;j < i;j++)
                data[j] = data [j+1];
            data[i] = tmp;
        }
    }
    public static void main(String[] argv) {
        char[] d = {'劉','憲','一'};
        perm(d);
    }
}