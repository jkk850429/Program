/*
* File Name: homework3.c
* ID:103213025
* Author:李柏均
* Since 2014/10/14
* Toolkit: Notepad++
*/
#include <stdio.h>
int IsLeap(int year,char calendar) {
    //宣告函數IsLeap是由一個整數和一個字元所組成
    if (calendar== 'a') {
    //如果字元calendar是a(西元)    
        if (year%4==0&&year%100!=0||year%400==0)
        //如果整數year能被4整除且不能被100整除 或是能被400整除        
            return 1;
            //傳回值為1    
        else
            return 0;
            //否則傳回0
    }else {
    //如果字元calendar不是a(是國曆)    
        year=year+1911;
        //year變成原本的year再加1911    
        if (year%4==0&&year%100!=0||year%400==0)
        //如果整數year能被4整除且不能被100整除 或是能被400整除          
            return 1;
            //傳回值為1    
        else         
            return 0;
            //否則傳回0
    }
}
int main () {
    int year;
    //宣告一個變數year
    char calendar;
    //宣告一個字元calendar
    scanf("%d%c",&year,&calendar);
    //輸入year和calendar的值
    if (IsLeap(year,calendar)) {
    //如果符合閏年(函數IsLeap)    
        printf("Yes\n");
        //印出Yes
    }else {
        printf("No\n");
        //否則印出No
    }
    return 0;
}
    
    
    
    