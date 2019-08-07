package sort;

import java.util.Arrays;

/**
 * ц╟ещеепР
 * @author Administrator
 *
 */
public class BubbleSort {
	public static void sort(int array[]) {
		int i,j;
		int len = array.length;
		int temp;
		for(i=0;i<len-1;i++) {
			for(j=len-1;j>i;--j) {
				if(array[j]<array[j-1]) {
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = {8,2,3,5,2,6,2,7};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
