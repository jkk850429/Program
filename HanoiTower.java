import java.util.*;
class HanoiTowerGame{               //(碟子數字越大 擺越下面)
    int count = 0;
	void go(int num){                      //包裝讓遊戲開始的
	    hanoi('A','C','B',num);
	}
    void moveDisc(char source,char target,int disc){         //disc:幾號碟子   
        System.out.println("Move disc "+disc+" from "+source+" to "+target);
		count++;
	}
    void hanoi(char a,char c,char b,int discs){         //Recursive   a:從哪 c:到哪  b:經過哪 discs:碟子數量
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
		System.out.print("請輸入碟子數量 : ");
		int a = sc.nextInt();
		
		h.go(a);
		System.out.println("總共搬動了 "+h.count+" 次");
	}
}