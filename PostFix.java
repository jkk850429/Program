/*
* File Name: PostFix.java
* ID:103213025
* Author:李柏均
* Since:2015/4/9
* Toolkit:Notepad++
*/
import java.util.Scanner;
public class PostFix {
    public static void main(String[] argv) {
        Stack s = new Stack();
        Scanner input = new Scanner(Systeme.in);  //取得輸入
        while (input.hasNext()) {     //後面有輸入時執行
            String token = input.next();
            if(token.equals("+")) {     //當輸入字串為+時將最後存取的兩個數相加
                int tmp = s.pop();
                s.push(s.pop()+s.pop());
            }else if (token.equals("-")) { //當輸入字串為-時將最後存取的兩個數相減(先存的數當作"被...."以下情況皆一樣)
                int tmp = s.pop();
                s.push(s.pop()-tmp);
            }else if (token.equals("*")) {  //當輸入字串為*時將最後存取的兩個數相乘
                int tmp = s.pop();
                s.push(s.pop()*s.pop());
            }else if (token.equals("/")) {  //當輸入字串為/時將最後存取的兩個數相除
                int tmp = s.pop();
                s.push(s.pop()/tmp);
            }else if (token.equals("%")) {  //當輸入字串為%時將最後存取的兩個數取餘數
                int tmp = s.pop();
                s.push(s.pop()%tmp);
            }else if (token.equals("^")) {  //當輸入字串為^時將最後存取的兩個數取次方
                int tmp = s.pop();
                s.push(Math.power(s.pop(),tmp));
            }else {         //輸入數字則存取數字
                int val;
                try{
                    val = Integer.parseInt(token);  //轉成int型態
                }catch(Exception err) {  //其他皆視為錯誤
                    System.out.println("輸入錯啦");  //輸出錯誤訊息
                    return;
                }
                s.push(val);
            }
        }
    }
}