package bitOperation;
/**
 * 位操作实现m乘以2的n次方
 * @author Administrator
 *
 */
public class Muti {
	public static int powerN(int m,int n) {
		for(int i=0;i<n;i++) {
			m=m<<1;
		}
		return m;
	}
	
	public static void main(String[] args) {
		System.out.println("3 * 2^3 = "+powerN(3,3));
		System.out.println("4 * 2^4 = "+powerN(4,4));
	}
}
