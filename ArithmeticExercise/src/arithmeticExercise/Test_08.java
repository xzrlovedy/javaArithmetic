package arithmeticExercise;
/**
 * ��Ŀ��һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻�����£�
 * ������ ��10�����ʱ�������������ף���10�η�����ߣ�
 * @author Administrator
 *
 */
public class Test_08 {
	public static void main(String[] args) {
		double h = 100;
		double s = 100;
		for(int i=1;i<=10;i++) {
			h=h/2;
			s+=2*h;
		}
		System.out.println(s);
		System.out.println(h);
	}
}
