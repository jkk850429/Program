import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Node {
    String key,value;
    Node next;
}
public class Hash {
    int n;
    Node[] data;
    public Hash(){
        n = 10;
        data = new Node[10];//�إ߸�ư}�C
    }
    public void put(String key,String value){//��J���
        int slot;//�إߴ���
        if(key.hashCode() < 0)//�p�G�O�t��
            slot = -key.hashCode() % n;//�[�t�������A�o��l��
        else 
            slot = key.hashCode() %n;
        Node tmp;
        for (tmp = data[slot]; tmp != null; tmp = tmp.next)
            if (tmp.key.equals(key))
                break;
        if (tmp != null) {//duplicate key
            tmp.value = value;
            return;
        }
        tmp = new Node();
        tmp.key = key;
        tmp.value = value;
        tmp.next = data[slot];//���Ʊ��W
        data[slot] = tmp;
    }
    public String get(String key){//����
        int slot;
		if(key.hashCode() < 0)//�p�G�O�t��
            slot = -key.hashCode() % n;//�[�t�������A�o��l��
        else 
            slot = key.hashCode() %n;
        Node tmp;//�n�䪺��
        for (tmp = data[slot]; tmp != null; tmp = tmp.next)
            if (tmp.key.equals(key))
                break;
        if (tmp != null)
            return tmp.value;
        return null;
    }
    public void remove(String key) {//�������
        int slot;
        if (key.hashCode() < 0)//�p�G�O�t��
            slot = -key.hashCode() % n;//�[�t�������A�o��l��
        else
            slot = key.hashCode() % n;
        Node tmp, prev;
        tmp = prev = null;
        //�ΰj��h��nremove����
        for (tmp = data[slot]; tmp != null; tmp = tmp.next) { 
            if (tmp.key.equals(key)) {
                break;
            }
            prev = tmp;
        }
        if (tmp == null){
            return;
        }
        if (prev == null) {
            data[slot] = tmp.next;
        } else {
            prev.next = tmp.next;//�N�e�@��ƻP�᭱��Ƭ۳s��
        }
    }
    public static void main(String[] argv) throws IOException{//�i�����
		Hash h = new Hash();
        h.init();
    }
	public void init()throws IOException{
	    String str1;
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("�п�J�B��X�G");
        //str1 = scanner.nextLine();
		//Hash h = new Hash();
		FileReader input;
		String s;
		input = new FileReader("d:\\program\\OPcode.txt");
		BufferedReader br = new BufferedReader(input);
		while((s=br.readLine())!=null) {  
			String[] arrayA = s.split("\\s+");
		    put(arrayA[0],arrayA[1]);
		}
        //System.out.println("OPcode��:" + get("LDA"));
	}
}            
            