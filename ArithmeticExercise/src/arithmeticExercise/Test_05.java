package arithmeticExercise;

import java.util.Scanner;
/**
 * 题目：输入两个正整数m和n，求其最大公约数和最小公倍数。
 * @author Administrator
 *
 */
public class Test_05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		
		Test_05 test = new Test_05();
		int result = test.gongYinShu(a, b);
		System.out.println("最小公因数:"+result);
		System.out.println("最大公倍数:"+a*b/result);
	}
	/**
	 * 在循环中，只要除数不等于0，用较大数除以较小的数，将小的一个数作为下一轮循环的大数，
	 * 取得的余数作为下一轮循环的较小的数，如此循环直到较小的数的值为0，返回较大的数，
	 * 此数即为最大公约数，最小公倍数为两数之积除以最大公约数。
	 * @param a
	 * @param b
	 * @return
	 */
	public int gongYinShu(int a,int b) {
		if(a<b) {
			int temp=b;
			b=a;
			a=temp;
		}
		while(b!=0) {
			if(a==b) {
				return a;
			}
			int temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}
}
