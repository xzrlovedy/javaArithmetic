package arithmeticExercise;
/**
 * ��Ŀ��һ��������������100����һ����ȫƽ�������ټ���168����һ����ȫƽ���������ʸ����Ƕ��٣�
 * @author Administrator
 *
 */
public class Test_09 {
	public static void main(String[] args) {
		for(int i=-100;i<10000;i++) {
			if(Math.sqrt(i+100)%1==0&&Math.sqrt(i+268)%1==0) {
				System.out.println(i);
			}
		}
	}
}
