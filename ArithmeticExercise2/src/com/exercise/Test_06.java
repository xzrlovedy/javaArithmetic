package com.exercise;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Test_06 {
	//快慢指针，把快指针扫描到的非0的数字赋值到慢指针的位置，快指针走完就把从慢指针当前所在位置到数组尾全部赋值为0。
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
