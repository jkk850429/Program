import java.util.*;
public class Prime{
    public static void main(String[] argv){
	    System.out.print("�п�J�Ʀr(�̤p��2):");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		int j=2;
		double range = a/2.0;            //���H2.0
		boolean isPrime = true;
		for(j=2;j<=range;j++){
		    if(a%j==0) {
			    if(isPrime=true){
				    isPrime=false;
					//System.out.print(a+"���O���");
			    }
			    else{
				    //System.out.print(a+"���O���");
			    }
			}
	    }
		
		
		
		if(isPrime){
		    System.out.print(a+"�O���");
		}else{
		    System.out.print(a+"���O���");
	    }
	}
}