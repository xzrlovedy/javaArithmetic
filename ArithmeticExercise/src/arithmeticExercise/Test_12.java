package arithmeticExercise;
/**
 * ��Ŀ����һ�������У�2/1��3/2��5/3��8/5��13/8��21/13...���������е�ǰ20��֮�͡�
 * @author Administrator
 *
 */
public class Test_12 {
	public static int f(int n) {
		if(n==1||n==2) {
			return n;
		}
		return f(n-1)+f(n-2);
	}
	public static void main(String[] args) {
		float temp = 0;
		for(int i=1;i<=20;i++) {
			temp+=(float)f(i+1)/f(i);
		}
		System.out.println(temp);
	}
}
