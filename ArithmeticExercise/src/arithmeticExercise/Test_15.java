package arithmeticExercise;

import java.util.Scanner;

/**
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 * @author Administrator
 *
 */
public class Test_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(ver(num));
	}
	public static boolean ver(int num) {
		if(num<0||(num!=0&&num%10==0)) {
			return false;
		}
		int ver = 0;
		while(num>ver) {
			ver=ver*10+num%10;
			num=num/10;
		}
		return (num==ver||num==ver/10);
	}
}
