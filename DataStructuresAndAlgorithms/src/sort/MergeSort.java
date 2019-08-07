package sort;

import java.util.Arrays;

/**
 * 如何进行归并排序
 * @author Administrator
 *
 */
public class MergeSort {
	
	public static void Merge(int array[],int p,int q,int r) {
		int i,j,k,n1,n2;
		n1 = q-p+1;
		n2 = r-q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i=0,k=p;i<n1;i++,k++) {
			L[i] = array[k];
		}
		for(i=0,k=q+1;i<n2;i++,k++) {
			R[i] = array[k];
		}
		for(k=p,i=0,j=0;i<n1&&j<n2;k++) {
			if(L[i]>R[j]) {
				array[k] = L[i];
				i++;
			}else {
				array[k] = R[j];
				j++;
			}
		}
		
		if(i<n1) {
			for(j=i;j<n1;j++,k++) {
				array[k] = L[j];
			}
		}
		if(i<n2) {
			for(i=j;i<n2;i++,k++) {
				array[k] = R[i];
			}
		}
	}
	
	public static void Sort(int[] array,int p,int r) {
		if(p<r) {
			int q = (p+r)/2;
			Sort(array,p,q);
			Sort(array,q+1,r);
			Merge(array,p,q,r);
		}
	}
	
	public static void main(String[] args) {
		int i=0;
		int a[] = {5,4,9,8,7,6,0,3,1,2};
		int len = a.length;
		Sort(a,0,len-1);
		System.out.println(Arrays.toString(a));
	}
}
