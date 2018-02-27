/*
* File Name:LL.java
* ID:103213025
* Author:李柏均
* Since 2015/11/24
* Toolkit: Notepad++
*/
class Node {
    int data;
    Node next;
    Node prev;
    public Node (int data){
        this.data = data;
    }
}
class LL {
    private Node head,tail;
    private Node dummy;
    private int n;
    public LL(){
        dummy = new Node(0);
        dummy.next = dummy.prev = dummy; //設定dummy是一個想像的節點(不存資料)
    }
    public void add(int data){
        if(isEmpty()){   //如果isEmpty->只有dummy這個節點-->在dummy後新增一個node t
            Node t = new Node(data);
            t.next = dummy.next;     //t.next取代dummy.next
            t.prev = dummy;
            dummy.prev = t;
            dummy.next = t;
            head = tail = t;
        } else {     //如果不是isEmpty->在tail後面(dummy前面)新增一個node t，形成環狀結構
            Node t = new Node(data);
            t.next = tail.next;
            t.prev = tail;
            dummy.prev = t;
            tail.next = t;
            tail = t;  //node t取代成為新的tail
        }
    }
    public void push(int data) {
        if(isEmpty()){  //如果isEmpty->只有dummy這個節點-->在dummy前面新增一個node t
            Node t = new Node(data);
            t.next = dummy.next;  //t.next取代dummy.next
            t.prev = dummy;
            dummy.prev = t;
            dummy.next = t;
            head = tail = t;
        } else { //如果不是isEmpty->在dummy後面(head前面)新增一個node t，形成環狀結構
            Node t = new Node(data);
            t.next = head;
            t.prev = dummy;
            head.prev = t;
            dummy.next = t;
            head = t; //node t取代成為新的head
        }
    }
    public boolean isEmpty() {
        //判斷是不是空的,若是空的代表只有dummy node,所以dummy的左邊或右邊指向自己
        return dummy.prev == dummy;
    }
    public int remove() { //取出head的data並remove head節點，然後將下一個節點指定為head
        int rel = head.data;
        head = head.next;
        dummy.next = head;
        head.prev = dummy;
        return rel;
    }
        
    public void deleteValue(int data) {  //刪除node
        Node now = head;
        if(head == null) 
            return;
        while(now != null) {
            if(now.data == data) 
                break;
            now = now.next;
        }
        if(now==null) 
            return;
        if(now.prev!=null)
            now.prev.next = now.next;
        if(now.next!=null)
            now.next.prev = now.prev;
        if(head==now) 
            head = now.next;
        if(tail==now)
            tail = now.prev;
    }
    
    public static void main(String[] argv){
        LL stack = new LL();
        LL queue = new LL();
        for(int i = 0 ; i < 20 ; i ++ ) {
            stack.push(i);
            queue.add(i);
        }
        stack.deleteValue(0);
        stack.deleteValue(19);
        while(!stack.isEmpty()) {
            System.out.println( stack.remove() );
        }
        System.out.println();
        queue.deleteValue(0);
        queue.deleteValue(19);
        while(!queue.isEmpty()) {
            System.out.println( queue.remove() );
        }
    }
}