package arithmeticExercise;

import java.util.Scanner;
/**
 * ��Ŀ����������������m��n���������Լ������С��������
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
		System.out.println("��С������:"+result);
		System.out.println("��󹫱���:"+a*b/result);
	}
	/**
	 * ��ѭ���У�ֻҪ����������0���ýϴ������Խ�С��������С��һ������Ϊ��һ��ѭ���Ĵ�����
	 * ȡ�õ�������Ϊ��һ��ѭ���Ľ�С���������ѭ��ֱ����С������ֵΪ0�����ؽϴ������
	 * ������Ϊ���Լ������С������Ϊ����֮���������Լ����
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
