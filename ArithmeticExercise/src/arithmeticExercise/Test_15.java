package arithmeticExercise;

import java.util.Scanner;

/**
 * ��Ŀ��һ��5λ�����ж����ǲ��ǻ���������12321�ǻ���������λ����λ��ͬ��ʮλ��ǧλ��ͬ��
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
