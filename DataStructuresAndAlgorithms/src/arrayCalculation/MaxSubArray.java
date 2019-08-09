package arrayCalculation;
/**
 * �����������֮��
 * 
 * ���磺��������[1,-2,4,8,-4,7,-1,-5]���ԣ�
 * 	         �����������[4,8,-4,7]�����Ϊ15
 * @author Administrator
 *
 */
public class MaxSubArray {
	
	/**
	 * ������
	 * �ҳ����������飬��ͣ�ȡ���ֵ
	 * �㷨ʱ�临�Ӷ�ΪO(n^3)����������ظ�������
	 * @param arr
	 * @return
	 */
	public static int max1(int[] arr) {
		int ThisSum = 0,MaxSum = Integer.MIN_VALUE,i,j,k;
		for(i=0;i<arr.length;i++) {
			for(j=i;j<arr.length;j++) {
				ThisSum = 0;
				for(k=i;k<j;k++) {
					ThisSum+=arr[k];
				}
				if(ThisSum>MaxSum) {
					MaxSum=ThisSum;
				}
			}
		}
		return MaxSum;
	}
	
	/**
	 * ȥ���ظ������������
	 * ���磺sum[i,j] = sum[i,j-1]+arr[j]��ʡȥ���ٴμ���sum[i,j-1]��ʱ��
	 * ʱ�临�Ӷ�ΪO(n^2)
	 * @param arr
	 * @return
	 */
	public static int max2(int[] arr) {
		int MaxSum = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				if(sum>MaxSum) {
					MaxSum = sum;
				}
			}
		}
		return MaxSum;
	}
	
	/**
	 * ��̬�滮��
	 * �������һ��Ԫ��arr[n-1]�����������֮��Ĺ�ϵ��Ϊ3�����
	 * 1��������������arr[n-1]������������������arr[n-1]��β
	 * 2��arr[n-1]�����������������
	 * 3����������鲻����arr[n-1]����ת��Ϊ��Sum[1,...n-2]�ĺ�
	 * @param arr
	 * @return
	 */
	public static int max(int m,int n) {
		return m>n?m:n;
	}
	public static int max3(int[] arr) {
		int n=arr.length;
		//����������������ռ�
		int[] End = new int[n];
		int[] All = new int[n];
		End[n-1]=arr[n-1];
		All[n-1]=arr[n-1];
		End[0]=All[0]=arr[0];
		
		for(int i=1;i<n;++i) {
			End[i]=max(End[i-1]+arr[i],arr[i]);
			All[i]=max(End[i],All[i-1]);
		}
		return All[n-1];
	}
	
	public static void main(String[] args) {
		int[] array = {1,-2,4,8,-4,7,-1,-5};
		System.out.println(max1(array));
		System.out.println(max2(array));
		System.out.println(max3(array));
	}
}
