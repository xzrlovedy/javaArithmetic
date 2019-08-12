package arrayCalculation;
/**
 * 求解数组中反序对的个数，即a[i]>a[j]但是i<j的被称为反序对
 * 例如：[1,5,3,2,6]，反序对有(5,3)(5,2)(3,2)
 * @author Administrator
 *
 */
public class ReverseCount {
	/*
	 * 蛮力法
	 */
	public static int reverseCount(int[] arr) {
		int count = 0;
		int len = arr.length;
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(arr[i]>arr[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	/*
	 * 分治归并法，在归并排序的基础上，额外使用一个计数器来记录逆序对
	 */
	public static int reverseCount = 0;
	public static void merge(int[] arr,int begin,int mid,int end) {
		int i,j,k,n1,n2;
		n1=mid-begin+1;
		n2=end-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i=0,k=begin;i<n1;i++,k++) {
			L[i]=arr[k];
		}
		for(i=0,k=mid+1;i<n2;i++,k++) {
			R[i]=arr[k];
		}
		for(k=begin,i=0,j=0;i<n1&&j<n2;k++) {
			if(L[i]<R[j]) {
				arr[k] = L[i++];
			}else {
				reverseCount += mid-i+1;
				arr[k]=R[j++];
			}
		}
		if(i<n1) {
			for(j=i;j<n1;j++,k++) {
				arr[k]=L[j];
			}
		}
		if(j<n2) {
			for(i=j;i<n2;i++,k++) {
				arr[k]=R[i];
			}
		}
	}
	
	public static void mergeSort(int[] a,int begin,int end) {
		if(begin<end) {
			int mid = (end+begin)/2;
			mergeSort(a,begin,mid);
			mergeSort(a,mid+1,end);
			merge(a,begin,mid,end);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,5,3,2,6};
		int count = reverseCount(array);
		System.out.println(count);
		System.out.println("----");
		mergeSort(array,0,array.length-1);
		System.out.println(reverseCount);
	}
}
