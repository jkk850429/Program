/*
* File Name:MazeShort.java
* ID:103213025
* Author:李柏均
* Since 2015/11/10
* Toolkit: Notepad++
*/
import java.util.Scanner;
public class MazeShort {
    public static void main(String[] argv) {
        // a 用來表示現在的位置  next用來表示下來的位置
        int x,y;
        int a;
        int next;
        int dir[] = {-12,-11,-10,1,12,11,10,-1};   //8個方向
        String[] map = {"W","W","W","W","W","W","W","W","W","W","W",    
                        "W","0","0","0","0","0","0","0","0","W","W", 
                        "W","0","W","0","0","0","0","W","0","0","W", 
                        "W","0","0","W","W","W","0","0","0","0","W", 
                        "W","0","0","W","0","W","0","0","0","W","W", 
                        "W","0","0","W","W","W","0","0","0","0","W", 
                        "W","0","0","0","0","0","0","0","0","W","W", 
                        "W","0","0","W","0","0","0","W","0","0","W", 
                        "W","0","W","0","0","0","0","0","0","0","W", 
                        "W","0","0","0","0","W","W","0","0","W","W", 
                        "W","W","W","W","W","W","W","W","W","W","W"};
        int[] visited = new int[map.length]; //設置一個跟map一樣大的陣列，用來記錄是否走過
        for (int i=0;i<visited.length;i++) {       
            visited[i] = -1;  //沒走過的值設為-1
        }
        Queue q = new Queue();
        Scanner input = new Scanner(System.in);   //輸入
        x = input.nextInt();
        y = input.nextInt();
        q.add(x+y*11);            //丟一個二維座標 轉成一維的值
        visited[x+y*11] = 0;      
        while (!q.isEmpty()) {    //如果堆疊不是空的，把他remove出來
            a = q.remove();       
            for(int i=0;i<8;i++) {
                next = a + dir[i]; //每個方向掃一次        
                if (map[next].equals("0") && visited[next] == -1) {   //可以走，還沒走過的地方
                    q.add(next);
                    visited[next]=visited[a]+1;
                }
            }
        }
        for(int i=0;i<121;i++) {
            if(map[i].equals("W") && visited[i] == -1) { //如果是牆壁 (不能走的:1.牆壁 2.不能是來過的)
                System.out.print("■");
            }else if(map[i].equals("0")&&visited[i] == -1) {  //如果是走不到的地方
                System.out.print("∞");
            }else {                                  
                if(visited[i]<10 && visited[i] != -1){ //如果都不是的話 
                    System.out.print(" ");       //換行
                    System.out.print(visited[i]);  //印出步數
                } else {
                    System.out.print(visited[i]); //印出步數
                }
                
            }
            if(i%11==10)        //換行
                System.out.println();
        }
    }
}
class Queue{         //Queue堆疊
    int[] data = new int[1000];
    int front,rear,size;
    public Queue() {
    }
    public void add(int x) {
        if(size==data.length) {
            //allocate new array
            int[] tmp = new int[data.length*2];
            //copy to new array
            for(int i=0;i<size;i++) {
                tmp[i] = data[front++];
                front %= data.length;
            }
            //reset front and rear
            front = 0;
            rear = 0;
            data = tmp;
        }
        data[rear++] = x;
        rear %= data.length;
    }
    public int remove() {
        int tmp = data[front++];
        front %= data.length;
        return tmp;
    }
    public boolean isEmpty() {
        return front == rear;
    }
}