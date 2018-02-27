/*
* File Name:LL.java
* ID:103213025
* Author:���f��
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
        dummy.next = dummy.prev = dummy; //�]�wdummy�O�@�ӷQ�����`�I(���s���)
    }
    public void add(int data){
        if(isEmpty()){   //�p�GisEmpty->�u��dummy�o�Ӹ`�I-->�bdummy��s�W�@��node t
            Node t = new Node(data);
            t.next = dummy.next;     //t.next���Ndummy.next
            t.prev = dummy;
            dummy.prev = t;
            dummy.next = t;
            head = tail = t;
        } else {     //�p�G���OisEmpty->�btail�᭱(dummy�e��)�s�W�@��node t�A�Φ��������c
            Node t = new Node(data);
            t.next = tail.next;
            t.prev = tail;
            dummy.prev = t;
            tail.next = t;
            tail = t;  //node t���N�����s��tail
        }
    }
    public void push(int data) {
        if(isEmpty()){  //�p�GisEmpty->�u��dummy�o�Ӹ`�I-->�bdummy�e���s�W�@��node t
            Node t = new Node(data);
            t.next = dummy.next;  //t.next���Ndummy.next
            t.prev = dummy;
            dummy.prev = t;
            dummy.next = t;
            head = tail = t;
        } else { //�p�G���OisEmpty->�bdummy�᭱(head�e��)�s�W�@��node t�A�Φ��������c
            Node t = new Node(data);
            t.next = head;
            t.prev = dummy;
            head.prev = t;
            dummy.next = t;
            head = t; //node t���N�����s��head
        }
    }
    public boolean isEmpty() {
        //�P�_�O���O�Ū�,�Y�O�Ū��N��u��dummy node,�ҥHdummy������Υk����V�ۤv
        return dummy.prev == dummy;
    }
    public int remove() { //���Xhead��data��remove head�`�I�A�M��N�U�@�Ӹ`�I���w��head
        int rel = head.data;
        head = head.next;
        dummy.next = head;
        head.prev = dummy;
        return rel;
    }
        
    public void deleteValue(int data) {  //�R��node
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