package com.exercise;

import java.util.Arrays;

/**
 * ��ʧ����
 * 
 * ����һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����
 * ʾ�� :
 * ����: [9,6,4,2,3,5,7,0,1]
 * ���: 8
 *
 * ˵��:
 * ����㷨Ӧ��������ʱ�临�Ӷȡ����ܷ��ʹ�ö��ⳣ���ռ���ʵ��?
 */
public class Test_05 {
    public static void method1(int[] nums) {
        Arrays.sort(nums);
        int j=nums[0];
        for (int i = 0;i<nums.length;i++,j++){
            if (nums[i]!=j){
            	System.out.println(j);
            	i--;
            	
            }
        }
    }
    public static void main(String[] args) {
    	int[] ints = {9,6,3,2,5,7,1};
    	//1,2,3,5,6,7,9
    	//1,2,3,4,5,6,7,8,9
		method1(ints);
	}
}
