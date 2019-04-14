package arithmeticExercise;

import java.util.Scanner;
/**
 * 
 * @author Administrator
 *
 */
public class Test_03 {
	public static void main(String[] args) {
		System.out.println("输入一个数：");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = 2;
		while(n>=k) {
			if(n==k) {
				System.out.println(k);
				break;
			}else if(n%k==0) {
				System.out.println(k);
				n=n/k;
			}else {
				k++;
			}
		}
	}
}
