package arithmeticExercise;
/**
 * ��Ŀ��һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ "���� "��
 * ����6=1��2��3.�ҳ�1000���ڵ�����������
 * @author Administrator
 *
 */
public class Test_07 {
	public static void main(String[] args) {
		for(int i=1;i<=1000;i++) {
			int temp = 0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					temp+=j;
				}
			}
			if(temp==i) {
				System.out.print(i+":");
				for(int k=1;k<i;k++) {
					if(i%k==0) {
						System.out.print(k+" ");
					}
				}
				System.out.println();
			}
		}
	}
}
