package bitOperation;
/**
 * 判断一个数是否为2的n次方
 * @author Administrator
 *
 */
public class Test {
	/*
	 * 时间复杂度为O(log n)
	 */
	public static boolean isPower(int n) {
		if(n<1) {
			return false;
		}
		int i = 1;
		while(i<=n) {
			if(i==n) {
				return true;
			}
			i<<=1;
		}
		return false;
	}
	/*
	 * 改进的算法，如果一个数是2的n次方，则它的二进制表示只有一个1，其余都为0，
	 * 例如：10,100,1000...
	 */
	public static boolean isPower2(int n) {
		if(n<1) {
			return false;
		}
		int m = n&(n-1);
		return m==0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPower(16));
		System.out.println(isPower(12));
		System.out.println("---------");
		System.out.println(isPower2(16));
		System.out.println(isPower2(12));
	}
}
