package com.exercise;

import java.util.Arrays;

/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 * ʾ��:
 * ����: [0,1,0,3,12]
 * ���: [1,3,12,0,0]
 *
 * ˵��:
 * ������ԭ�����ϲ��������ܿ�����������顣
 * �������ٲ���������
 */
public class Test_06 {
	//����ָ�룬�ѿ�ָ��ɨ�赽�ķ�0�����ָ�ֵ����ָ���λ�ã���ָ������ͰѴ���ָ�뵱ǰ����λ�õ�����βȫ����ֵΪ0��
	public static int[] method1(int[] nums) {
		int fast = 0,slow = 0,count = 0;
		for(;fast<nums.length;fast++) {
			if(nums[fast]!=0) {
				count++;
				if(fast!=slow) {
					nums[slow] = nums[fast];
				}
				slow++;
			}
		}
		for(int i=count;i<nums.length;i++) {
			nums[i]=0;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] ints = {0,1,0,3,12};
		System.out.println(Arrays.toString(method1(ints)));
	}
}
