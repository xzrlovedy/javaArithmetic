package arithmeticExercise;

import java.util.Scanner;

/**
 * ��Ŀ����һ��3*3����Խ���Ԫ��֮�� 
 * @author Administrator
 *
 */
public class Test_16 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] a = new int[3][3];
		//��������
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				a[i][j] = input.nextInt();
			}
		}
		//�������
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("");
		}
		int sum = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==j) {
					sum+=a[i][j];
				}
			}
		}
		System.out.println(sum);
	}	
}
