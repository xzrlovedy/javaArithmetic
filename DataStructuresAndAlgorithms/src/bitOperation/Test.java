package bitOperation;
/**
 * �ж�һ�����Ƿ�Ϊ2��n�η�
 * @author Administrator
 *
 */
public class Test {
	/*
	 * ʱ�临�Ӷ�ΪO(log n)
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
	 * �Ľ����㷨�����һ������2��n�η��������Ķ����Ʊ�ʾֻ��һ��1�����඼Ϊ0��
	 * ���磺10,100,1000...
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
