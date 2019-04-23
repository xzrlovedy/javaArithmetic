package arithmeticExercise;

/**
 * 题目：求1+2!+3!+...+20!的和
 * @author Administrator
 */
public class Test_13 {
	public static void main(String[] args) {
		long sum = 0, ver = 1;
		for (int i = 1; i <= 20; i++) {
			ver = ver * i;
			sum += ver;
		}
		System.out.println(sum);
	}
}
