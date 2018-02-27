/*
* File Name: homework4.c
* ID:103213024
* Author:李柏均
* Since 2014/10/22
* Toolkit: Notepad++
*/
#include <stdio.h>
int f(int a) {
    //設立int型態函數f()
    int y=0;
    //宣告變數y一開始為0
    while (a!=0) {
    //當a不等於0時迴圈
        y=y*10+a%10;
        //整數先進位後再加入尾數
        a=a/10;
        //去掉最後一位數
    }
    return y;
    //傳回y
}
int main() {
    int a;
    //宣告變數a
    scanf("%d",&a);
    //輸入一整數
    printf("%d",f(a));
    //印出反轉數
    printf("\n");
    //印出換行
    return 0;
}

    

