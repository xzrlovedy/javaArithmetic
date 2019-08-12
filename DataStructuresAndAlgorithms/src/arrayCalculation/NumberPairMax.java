package arrayCalculation;

/**
 * 求数组中一个数减去它右边子数组的一个数的最大值
 * 如：[1,4,17,3,5,6,2,9],最大值是17-2=15
 * 
 * @author Administrator
 *
 */
public class NumberPairMax {
	/*
	 * 蛮力法 求出所有差值，取最大的
	 */
	public static int getMax1(int[] a) {
		if (a == null) {
			return Integer.MIN_VALUE;
		}
		int len = a.length;
		if (len <= 1) {
			return Integer.MIN_VALUE;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (a[i] - a[j] > max)
					max = a[i] - a[j];
			}
		}
		return max;
	}
	
	/*
	 * 动态规划法
	 */
	public static int max(int m,int n) {
		return (m>n)?m:n;
	}
	public static int getMax2(int[] a) {
		if (a == null) {
			return Integer.MIN_VALUE;
		}
		int len = a.length;
		if (len <= 1) {
			return Integer.MIN_VALUE;
		}
		int[] diff = new int[len];
		int[] max = new int[len];
		diff[0] = Integer.MIN_VALUE;
		max[0] = a[0];
		for(int i=1;i<len;i++) {
			diff[i] = max(diff[i-1],max[i-1]-a[i]);
			max[i] = max(max[i-1],a[i]);
		}
		return diff[len-1];
	}

	public static void main(String[] args) {
		int[] a = { 1, 4, 17, 3, 2, 9 };
		System.out.println(getMax1(a));
		System.out.println(getMax2(a));
	}
}
