import java.util.*;
public class Prime{
    public static void main(String[] argv){
	    System.out.print("請輸入數字(最小為2):");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		int j=2;
		double range = a/2.0;            //除以2.0
		boolean isPrime = true;
		for(j=2;j<=range;j++){
		    if(a%j==0) {
			    if(isPrime=true){
				    isPrime=false;
					//System.out.print(a+"不是質數");
			    }
			    else{
				    //System.out.print(a+"不是質數");
			    }
			}
	    }
		
		
		
		if(isPrime){
		    System.out.print(a+"是質數");
		}else{
		    System.out.print(a+"不是質數");
	    }
	}
}