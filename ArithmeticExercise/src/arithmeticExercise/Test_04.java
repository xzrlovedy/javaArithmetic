package arithmeticExercise;

import java.util.Scanner;
/**
 * ��Ŀ�����������������Ƕ������ɴ��⣺
 * ѧϰ�ɼ�> =90�ֵ�ͬѧ��A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ��
 * @author Administrator
 *
 */
public class Test_04 {
	public static void main(String[] args) {
		System.out.println("���������");
		Scanner input = new Scanner(System.in);
		int score = input.nextInt();
		char grade=score>90?'A':score>60?'B':'C';
		System.out.println(grade);
	}
}
