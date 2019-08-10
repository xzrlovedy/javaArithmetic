package arrayCalculation;

import java.util.Arrays;

/**
 * 找出数组中两两相加等于20的组合数
 * @author Administrator
 *
 */
public class FindSum {
	/*
	 * 蛮力法
	 * 算法时间复杂度为O(n^2)
	 */
	public static void find1(int[] arr,int num) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(arr[i]+arr[j] == num) {
					System.out.println(arr[i]+","+arr[j]);
				}
			}
		}
	}
	
	/*
	 * 先排序，两个数一定在arr[begin]+arr[end]>20之间
	 */
	public static void find2(int[] arr,int num) {
		Arrays.sort(arr);
		int begin = 0;
		int end = arr.length-1;
		while(begin<end) {
			if(arr[begin]+arr[end]<num) {
				begin++;
			}else if(arr[begin]+arr[end]>num) {
				end--;
			}else {
				System.out.println(arr[begin]+","+arr[end]);
				begin++;
				end--;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,7,17,3,6,14,18};
		find1(array,20);
		System.out.println("------");
		find2(array,20);
	}
}
