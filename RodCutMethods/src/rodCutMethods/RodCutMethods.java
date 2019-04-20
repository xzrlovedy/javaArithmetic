package rodCutMethods;
/**
 * 
 * @author Administrator
 *
 */
public class RodCutMethods {
	/**
	 * 自顶向下求解
	 * @param p 价格表，int类型数组存放
	 * @param n 钢条总长度
	 * @return
	 */
	public static int MEMOIZED_CUT_ROD(int[] p, int n) {
		int[] arr = new int[n + 1];// 记录不同长度的最优解
		for (int i = 0; i <= n; i++) {
			arr[i] = -1;// 初始化最优解
		}
		return MEMOIZED_CUT_ROD_AUX(p, n, arr);
	}

	public static int MEMOIZED_CUT_ROD_AUX(int[] p, int n, int[] arr) {
		int max;// 存储最优解的值
		if (arr[n] >= 0) {
			return arr[n];
		}
		if (n == 0) {
			max = 0;
		} else {
			max = -1;
			for (int i = 1; i <= n; i++) {
				max = Math.max(max, p[i] + MEMOIZED_CUT_ROD_AUX(p, n - i, arr));
			}
		}
		arr[n] = max;
		return max;
	}

	public static void main(String[] args) {
		//价格表，下标代表钢条长度，值为价格
		int [] p = {0,1,5,8,9,10,17,17,20,24,30};
		//钢条总长度
		int n = 9;
		int max = MEMOIZED_CUT_ROD(p, n);
		System.out.print("长度为" + n + "的钢条最佳切割所得利润为：" + max);
	}
}
