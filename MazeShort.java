/*
* File Name:MazeShort.java
* ID:103213025
* Author:���f��
* Since 2015/11/10
* Toolkit: Notepad++
*/
import java.util.Scanner;
public class MazeShort {
    public static void main(String[] argv) {
        // a �ΨӪ�ܲ{�b����m  next�ΨӪ�ܤU�Ӫ���m
        int x,y;
        int a;
        int next;
        int dir[] = {-12,-11,-10,1,12,11,10,-1};   //8�Ӥ�V
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
        int[] visited = new int[map.length]; //�]�m�@�Ӹ�map�@�ˤj���}�C�A�ΨӰO���O�_���L
        for (int i=0;i<visited.length;i++) {       
            visited[i] = -1;  //�S���L���ȳ]��-1
        }
        Queue q = new Queue();
        Scanner input = new Scanner(System.in);   //��J
        x = input.nextInt();
        y = input.nextInt();
        q.add(x+y*11);            //��@�ӤG���y�� �ন�@������
        visited[x+y*11] = 0;      
        while (!q.isEmpty()) {    //�p�G���|���O�Ū��A��Lremove�X��
            a = q.remove();       
            for(int i=0;i<8;i++) {
                next = a + dir[i]; //�C�Ӥ�V���@��        
                if (map[next].equals("0") && visited[next] == -1) {   //�i�H���A�٨S���L���a��
                    q.add(next);
                    visited[next]=visited[a]+1;
                }
            }
        }
        for(int i=0;i<121;i++) {
            if(map[i].equals("W") && visited[i] == -1) { //�p�G�O��� (���ਫ��:1.��� 2.����O�ӹL��)
                System.out.print("��");
            }else if(map[i].equals("0")&&visited[i] == -1) {  //�p�G�O�����쪺�a��
                System.out.print("��");
            }else {                                  
                if(visited[i]<10 && visited[i] != -1){ //�p�G�����O���� 
                    System.out.print(" ");       //����
                    System.out.print(visited[i]);  //�L�X�B��
                } else {
                    System.out.print(visited[i]); //�L�X�B��
                }
                
            }
            if(i%11==10)        //����
                System.out.println();
        }
    }
}
class Queue{         //Queue���|
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