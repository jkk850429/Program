/*
* File Name:Eval.java
* ID:103213025
* Author:李柏均
* Since 2015/11/1
* Toolkit: Notepad++
*/
public class Eval {
    private static int[] isp = new int[]{1,1,2,2,3,0}; //分別設定+-*/^(的isp以及icp,數字越大代表優先權越高
    private static int[] icp = new int[]{1,1,2,2,4,8};
    private static String[] opList = new String[] {"+","-","*","/","^","("};
    public static int opID (String op) {      //用來找相對應的符號
        for(int i=0;i<opList.length;i++) {
            if(op.equals(opList[i]))
                return i;//found
        }
        return -1; //not found
    }
    public static void toPost(String[] infix) {
        int opid;
        Stack s = new Stack();
        String op;
        for(int i =0;i<infix.length;i++) {
            if(infix[i].equals(")")) {        //判斷:如果是)就把到(裡面的東西印出
                while(!s.isEmpty()&&!(op = s.pop()).equals("(")) {
                    System.out.print(op+"");
                }
            }else if((opid = opID(infix[i]))!=-1) {  //判斷:如果堆疊裡面的符號比我現在手上的符號層級高,就先印出
                while(!s.isEmpty()) {
                    if(isp[opID(op = s.pop())] >= icp[opID(infix[i])]) {
                        System.out.print(op+"");
                }else {
                    s.push(op);
                    break;
                }
            }
            s.push(infix[i]);
            }else {       //判斷:如果是數字，則印出
                System.out.print(infix[i]+"");
            }
        }
        while(!s.isEmpty())
            System.out.print(s.pop()+"");
                System.out.println();
    }
    public static void main(String[] argv) {
        String[] exp = new String[] {
        "(","2","+","3",")","^","(","1","+","2",")","*","3","-","1" };
        toPost(exp);
    }
}
class Stack {  
    private String[] data = new String[1000];
    int top;

    public void push(String x) { //加入東西到堆疊
        data[top++] = x;
    }
    public String pop() {   //把堆疊的東西拿出來
        return data[--top];
    }
    public boolean isEmpty() {
        return top <= 0;
    }
}