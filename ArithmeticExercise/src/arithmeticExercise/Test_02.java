package arithmeticExercise;
/**
 * ��Ŀ����ӡ�����е� "ˮ�ɻ��� "����ν "ˮ�ɻ��� "��ָһ����λ�������λ���������͵��ڸ�������
 * ���磺153��һ�� "ˮ�ɻ��� "����Ϊ153=1�����η���5�����η���3�����η���
 * @author Administrator
 *
 */
public class Test_02 {
	public static void main(String[] args) {
		int a,b,c;
		for(int i =100;i<1000;i++) {
			a=i%10;
			b=i/10%10;
			c=i/100;
			if(a*a*a+b*b*b+c*c*c==i) {
				System.out.println(i);
			}
		}
	}
}
