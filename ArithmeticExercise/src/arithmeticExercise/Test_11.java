package arithmeticExercise;

/**
 * ��Ŀ�����ӳ������⣺���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬����񫣬�ֶ����һ��
 * �ڶ��������ֽ�ʣ�µ����ӳԵ�һ�룬�ֶ����һ�����Ժ�ÿ�����϶�����ǰһ��ʣ��
 * ��һ����һ��������10���������ٳ�ʱ����ֻʣ��һ�������ˡ����һ�칲ժ�˶���?
 * 
 * @author Administrator
 *
 */
public class Test_11 {
	public static void main(String[] args) {
		int temp = 1;
		for (int i = 10; i > 1; i--) {
			temp = (temp + 1) * 2;
		}
		System.out.println(temp);
	}
}
