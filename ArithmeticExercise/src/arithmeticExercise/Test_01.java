package arithmeticExercise;
/**
 * ��Ŀ���ж�101-200֮���ж��ٸ����������������������
 * ����������ж������ķ�������һ�����ֱ�ȥ��2��sqrt(�����)��
 * ����ܱ������� ���������������������֮��������
 * @author Administrator
 *
 */
public class Test_01 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1;i<200;i++) {
			boolean flag = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					flag=false;
					break;
				}
			}
			if(flag==true) {
				count++;
				System.out.print(i+"\t");
				if(count%10==0) {
					System.out.println();
				}
			}
		}
		System.out.println("\n���У�"+count+"������");
	}
}
