package bitOperation;
/**
 * 求二进制中1的个数
 * @author Administrator
 *
 */
public class Count {
	/*
	 * 时间复杂度为O(n)，n是二进制位数
	 */
	public static int countOne1(int n) {
		int count = 0;
		while(n>0) {
			if((n&1)==1) {//判断最后一位是否为1
				count++;
			}
			n>>=1;
		}
		return count;
	}
	
	/*
	 * 时间复杂度为O(m)，m为二进制中1的个数
	 */
	public static int countOne2(int n) {
		int count = 0;
		while(n>0) {
			if(n!=0) {
				n=n&(n-1);
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countOne1(7));
		System.out.println(countOne1(8));
		System.out.println("------");
		System.out.println(countOne2(7));
		System.out.println(countOne2(8));
	}
}
