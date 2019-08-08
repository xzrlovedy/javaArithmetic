package bitOperation;
/**
 * ���������1�ĸ���
 * @author Administrator
 *
 */
public class Count {
	/*
	 * ʱ�临�Ӷ�ΪO(n)��n�Ƕ�����λ��
	 */
	public static int countOne1(int n) {
		int count = 0;
		while(n>0) {
			if((n&1)==1) {//�ж����һλ�Ƿ�Ϊ1
				count++;
			}
			n>>=1;
		}
		return count;
	}
	
	/*
	 * ʱ�临�Ӷ�ΪO(m)��mΪ��������1�ĸ���
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
