package com.exercise;

import java.util.Arrays;

/**
 * 消失的数
 * 
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 示例 :
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
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
