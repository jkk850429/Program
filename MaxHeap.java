/*
* File Name:MaxHeap.java
* ID:103213025
* Author:李柏均
* Since 2015/12/13
* Toolkit: Notepad++
*/
import java.lang.Math;
public class MaxHeap {
    int n; //   <-- 紀錄放了幾個資料
    int[] data = new int[1000];     //宣告陣列
    
    void add(int key) {
        int pos = ++n; //n+1開始放 (方便數學運算)
        int parent = n/2;
        while(key > data[parent] && parent >= 1) {
            data[pos] = data[parent];
            pos = parent;
            parent = pos/2;
        }
        data[pos] = key;
    }
    
    int delete() {
        int max = data[1];
        int pos = 1;
        int key = data[n];
        n = n-1;
        int child = pos*2;   //預設child是左邊那一個
        while(child <= n) {
            if(child+1 <= n && data[child] < data[child+1]) {  //右邊的child存在且大於左邊的
                child = child+1;
            }
            if(data[child] < key) {
                break;
            }
            data[pos] = data[child];
            pos = child;
            child = pos*2;
        }      
        data[pos] = key;
        return max;
    }
    public static void main(String[] argv) {
        MaxHeap tree = new MaxHeap();
        for(int i = 0;i < 10;i++) {
            tree.add( (int)(Math.random()*1000)); //取隨機變數
        }
        for(int i = 0;i < 10;i++) {
            System.out.println( tree.delete() );
        }
    }
}
