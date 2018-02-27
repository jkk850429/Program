/*
* File Name: classwork1
* ID:103213025
* Author: 李柏均
* Since 2015/3/27
* Toolkit: Notepad++
*/
public class Stack {  //堆疊(先進後出)
    //宣告陣列data
    int[] data = new int[1000];
    //宣告變數top
    int top;
    public Stack() {
    }
    //宣告函數push為加入一個值的函數(從頂端加入)
    public void push(int x) {
        data[top++] = x;
    }
    //宣告函數push為刪去一個值的函數(從頂端先拿走)
    public int pop() {
        return data[--top];
    }
    //函數判斷是否是空的
    public boolean isEmpty() {
        return top == 0;
    //函數判斷是否是滿的
    public boolean isFull() {
        return top == data.length;
    }
}