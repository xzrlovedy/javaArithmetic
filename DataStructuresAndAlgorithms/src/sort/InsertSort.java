package sort;

import java.util.Arrays;

/**
 * 如何进行插入排序
 * @author Administrator
 *
 */
public class InsertSort {
	public static void sort(int[] a) {
		if(a!=null) {
			for(int i=1;i<a.length;i++) {
				int temp = a[i],j = i;
				if(a[j-1]>temp) {
					while(j>=1&&a[j-1]>temp) {
						a[j]=a[j-1];
						j--;
					}
				}
				a[j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arrays = {7,3,12,5,76,8};
		sort(arrays);
		System.out.println(Arrays.toString(arrays));
 	}
}
