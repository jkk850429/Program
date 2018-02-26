import java.util.*;
class HanoiTowerGame{               //(�Фl�Ʀr�V�j �\�V�U��)
    int count = 0;
	void go(int num){                      //�]�����C���}�l��
	    hanoi('A','C','B',num);
	}
    void moveDisc(char source,char target,int disc){         //disc:�X���Фl   
        System.out.println("Move disc "+disc+" from "+source+" to "+target);
		count++;
	}
    void hanoi(char a,char c,char b,int discs){         //Recursive   a:�q�� c:���  b:�g�L�� discs:�Фl�ƶq
        if(discs==1){
		    moveDisc(a,c,discs);
			return;
		}else{
		    hanoi(a,b,c,discs-1);
			moveDisc(a,c,discs);
			hanoi(b,c,a,discs-1);
		}
	}  

}
public class HanoiTower{
    public static void main(String[] argv){
	    HanoiTowerGame h = new HanoiTowerGame();
		Scanner sc = new Scanner(System.in);
		System.out.print("�п�J�Фl�ƶq : ");
		int a = sc.nextInt();
		
		h.go(a);
		System.out.println("�`�@�h�ʤF "+h.count+" ��");
	}
}