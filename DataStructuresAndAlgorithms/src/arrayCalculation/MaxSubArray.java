package arrayCalculation;
/**
 * 求最大子数组之和
 * 
 * 例如：对于数组[1,-2,4,8,-4,7,-1,-5]而言，
 * 	         最大子数组是[4,8,-4,7]，结果为15
 * @author Administrator
 *
 */
public class MaxSubArray {
	
	/**
	 * 蛮力法
	 * 找出所有子数组，求和，取最大值
	 * 算法时间复杂度为O(n^3)，许多数组重复计算了
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
	 * 去除重复计算的子数组
	 * 例如：sum[i,j] = sum[i,j-1]+arr[j]，省去了再次计算sum[i,j-1]的时间
	 * 时间复杂度为O(n^2)
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
	 * 动态规划法
	 * 根据最后一个元素arr[n-1]与最大子数组之间的关系分为3种情况
	 * 1、最大子数组包含arr[n-1]，即最大子数组可能以arr[n-1]结尾
	 * 2、arr[n-1]单独构成最大子数组
	 * 3、最大子数组不包含arr[n-1]，可转换为求Sum[1,...n-2]的和
	 * @param arr
	 * @return
	 */
	public static int max(int m,int n) {
		return m>n?m:n;
	}
	public static int max3(int[] arr) {
		int n=arr.length;
		//额外申请两个数组空间
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
