package arrayCalculation;

import java.util.Arrays;

/**
 * 将数组循环右移K位
 * 例如：12345678右移两位变成 78 123456
 * 有两段顺序不变即：78和123456
 * 右移两位就是将这两段交换
 * 1、逆序数组子序列123456，变成：654321
 * 2、逆序数组子序列78，变成：87
 * 3、再全部逆序：78 654321
 * 算法时间复杂度O(n)
 * 
 * @author Administrator
 *
 */
public class MoveK {
	/*
	 * 数组从下标b到e逆序
	 */
	public static void reverse(int[] a, int b, int e) {
		for (; b < e; b++, e--) {
			int temp = a[e];
			a[e] = a[b];
			a[b] = temp;
		}
	}

	public static void shift_k(int[] a, int k) {
		k = k % a.length; // 防止k比数组a的长度大，右移k位和右移k%a.length位是一样的
		reverse(a, a.length - k, a.length - 1);
		reverse(a, 0, a.length - k - 1);
		reverse(a, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		shift_k(array,2);
		System.out.println(Arrays.toString(array));
	}
}
