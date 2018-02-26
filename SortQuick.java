import java.util.*;
class SortQuick{
    static void swap(int[] B,int i,int j){
	    int temp = B[i];
		B[i] = B[j];
		B[j] = temp;
	}
	static int partition(int[] Array,int l,int r){
        int pivot = Array[r];
		int i = l-1;
		for(int j=l;j<r;j++){
		    if(Array[j]<pivot){
			    i++;
				swap(Array,i,j);
			}
		}
		swap(Array,i+1,r);
	}
	static void Quick(int[] A,int p,int r){
	    if(p<=r){
			int q = partition(A,p,r);
			Quick(A,p,q-1);
			Quick(A,q+1,r);
		}
	}
	public static void main(String[] argv){
		int[] A = {7,8,0,15,95,45,32,4,780};
		Quick(A,0,8);
	}
}