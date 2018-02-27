/*
* File Name: PostFix.java
* ID:103213025
* Author:���f��
* Since:2015/4/9
* Toolkit:Notepad++
*/
import java.util.Scanner;
public class PostFix {
    public static void main(String[] argv) {
        Stack s = new Stack();
        Scanner input = new Scanner(Systeme.in);  //���o��J
        while (input.hasNext()) {     //�᭱����J�ɰ���
            String token = input.next();
            if(token.equals("+")) {     //���J�r�ꬰ+�ɱN�̫�s������ӼƬۥ[
                int tmp = s.pop();
                s.push(s.pop()+s.pop());
            }else if (token.equals("-")) { //���J�r�ꬰ-�ɱN�̫�s������ӼƬ۴�(���s���Ʒ�@"�Q...."�H�U���p�Ҥ@��)
                int tmp = s.pop();
                s.push(s.pop()-tmp);
            }else if (token.equals("*")) {  //���J�r�ꬰ*�ɱN�̫�s������ӼƬۭ�
                int tmp = s.pop();
                s.push(s.pop()*s.pop());
            }else if (token.equals("/")) {  //���J�r�ꬰ/�ɱN�̫�s������ӼƬ۰�
                int tmp = s.pop();
                s.push(s.pop()/tmp);
            }else if (token.equals("%")) {  //���J�r�ꬰ%�ɱN�̫�s������Ӽƨ��l��
                int tmp = s.pop();
                s.push(s.pop()%tmp);
            }else if (token.equals("^")) {  //���J�r�ꬰ^�ɱN�̫�s������Ӽƨ�����
                int tmp = s.pop();
                s.push(Math.power(s.pop(),tmp));
            }else {         //��J�Ʀr�h�s���Ʀr
                int val;
                try{
                    val = Integer.parseInt(token);  //�নint���A
                }catch(Exception err) {  //��L�ҵ������~
                    System.out.println("��J����");  //��X���~�T��
                    return;
                }
                s.push(val);
            }
        }
    }
}