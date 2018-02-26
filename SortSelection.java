import java.util.*;
class SortSelection{
	static void swap(int[] B,int i,int j){
	    int temp = B[i];
		B[i] = B[j];
		B[j] = temp;
	}
	public static void main(String[] argv){
		int[] A = {7,8,0,15,95,45,32,4,780};
		int n = A.length;
		for(int i=0;i<n-1;i++){
			int m = i;
			for(int j=i+1;j<n;j++){
			    if(A[j]<A[m]){
				    m = j;
				}
			}
		    if(m!=i){
			    swap(A,m,i);
			}
		}
		for(int k=0;k<n;k++){
		    System.out.print(A[k]+" ");
		}
	}
}