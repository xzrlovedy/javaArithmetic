package arithmeticExercise;

import java.util.Scanner;
/**
 * ��Ŀ������һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
 * @author Administrator
 *
 */
public class Test_06 {
	public static void main(String[] args) {
		int abcCount=0;
		int spaceCount=0;
		int numCount=0;
		int otherCount=0;
		
		Scanner input = new Scanner(System.in);
		String toString = input.nextLine();
		char[] ch = toString.toCharArray();
		
		for(int i =0;i<ch.length;i++) {
			if(Character.isLetter(ch[i])) {
				abcCount++;
			}else if(Character.isDigit(ch[i])) {
				numCount++;
			}else if(Character.isSpaceChar(ch[i])) {
				spaceCount++;
			}else {
				otherCount++;
			}
		}
		System.out.println("abcCount:"+abcCount);
		System.out.println("spaceCount:"+spaceCount);
		System.out.println("numCount:"+numCount);
		System.out.println("otherCount:"+otherCount);
	}
}
