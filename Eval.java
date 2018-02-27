/*
* File Name:Eval.java
* ID:103213025
* Author:���f��
* Since 2015/11/1
* Toolkit: Notepad++
*/
public class Eval {
    private static int[] isp = new int[]{1,1,2,2,3,0}; //���O�]�w+-*/^(��isp�H��icp,�Ʀr�V�j�N���u���v�V��
    private static int[] icp = new int[]{1,1,2,2,4,8};
    private static String[] opList = new String[] {"+","-","*","/","^","("};
    public static int opID (String op) {      //�Ψӧ�۹������Ÿ�
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
            if(infix[i].equals(")")) {        //�P�_:�p�G�O)�N���(�̭����F��L�X
                while(!s.isEmpty()&&!(op = s.pop()).equals("(")) {
                    System.out.print(op+"");
                }
            }else if((opid = opID(infix[i]))!=-1) {  //�P�_:�p�G���|�̭����Ÿ���ڲ{�b��W���Ÿ��h�Ű�,�N���L�X
                while(!s.isEmpty()) {
                    if(isp[opID(op = s.pop())] >= icp[opID(infix[i])]) {
                        System.out.print(op+"");
                }else {
                    s.push(op);
                    break;
                }
            }
            s.push(infix[i]);
            }else {       //�P�_:�p�G�O�Ʀr�A�h�L�X
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

    public void push(String x) { //�[�J�F�����|
        data[top++] = x;
    }
    public String pop() {   //����|���F�讳�X��
        return data[--top];
    }
    public boolean isEmpty() {
        return top <= 0;
    }
}