package arrayCalculation;

import java.util.Arrays;

/**
 * ������ѭ������Kλ
 * ���磺12345678������λ��� 78 123456
 * ������˳�򲻱伴��78��123456
 * ������λ���ǽ������ν���
 * 1����������������123456����ɣ�654321
 * 2����������������78����ɣ�87
 * 3����ȫ������78 654321
 * �㷨ʱ�临�Ӷ�O(n)
 * 
 * @author Administrator
 *
 */
public class MoveK {
	/*
	 * ������±�b��e����
	 */
	public static void reverse(int[] a, int b, int e) {
		for (; b < e; b++, e--) {
			int temp = a[e];
			a[e] = a[b];
			a[b] = temp;
		}
	}

	public static void shift_k(int[] a, int k) {
		k = k % a.length; // ��ֹk������a�ĳ��ȴ�����kλ������k%a.lengthλ��һ����
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
