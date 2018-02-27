/*
* File Name:Sorted Permutation.java
* ID:103213025
* Author:���f��
* Since 2015/10/11
* Toolkit: Notepad++
*/
import java.util.Scanner;
public class SortedPermutation{
    //�C�Xdatat�Ҧ����ƦC
    public static void perm(char[] data) {
        perm(data,0);
    }
    //data:�n�ƦC���}�C
    //pos:��pos�o�Ӧ�m�H�᪺�����@�ƦC
    public static  void perm(char[] data,int pos) {
        //�פ����
        if(pos == data.length-1) {
            for (int i = 0;i < data.length;i++)
                System.out.print(data[i]);
            System.out.println();
            return;
        }
        //��²
        //��pos~data.length - 1�������������D�@�ө��pos��m�W
        for(int i = pos; i < data.length;i++) {
        //���δ��J�k
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
        char[] d = {'�B','��','�@'};
        perm(d);
    }
}