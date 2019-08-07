package sort;

import java.util.Arrays;

/**
 * —°‘Ò≈≈–Ú
 * @author Administrator
 *
 */
public class SelectSort {
	
	public static void sort(int[] ints) {
		int i,j,temp = 0,flag = 0;
		int n = ints.length;
		for(i=0;i<n;i++) {
			temp=ints[i];
			flag=i;
			for(j=i+1;j<n;j++) {
				if(ints[j]<temp) {
					temp = ints[j];
					flag = j;
				}
			}
			if(flag!=i) {
				ints[flag] = ints[i];
				ints[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int i=0;
		int a[] = {5,4,9,8,7,6,0,1,3,2};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
