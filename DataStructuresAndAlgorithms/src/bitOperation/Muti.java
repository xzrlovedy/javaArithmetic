package bitOperation;
/**
 * λ����ʵ��m����2��n�η�
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
