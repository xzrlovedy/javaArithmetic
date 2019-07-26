package com.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @author Administrator
 *
 */
public class Test_02 {
	/*
	 * set和数组转换
	 */
	public int[] method1(int[] num1,int[] num2) {
		
		Set<Integer> integers = new HashSet<>();
		for(int i:num1) {
			integers.add(i);
		}
		Set<Integer> integers2 = new HashSet<>();
		for(int i:num2) {
			integers2.add(i);
		}
		integers.retainAll(integers2);
		
		int[] ints = new int[integers.size()];
		int i=0;
		for(int a:integers) {
			ints[i] = a;
			i++;
		}
		return ints;
	}
	
	/*
	 * 一个个判断元素是否存在，实际上retainAll函数内部也是这么实现的
	 */
	public int[] method2(int[] num1,int[] num2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for(int i:num1) {
			set1.add(i);
		}
		for(int i:num2) {
			if(set1.contains(i)) {
				set2.add(i);
			}
		}
		int[] ints = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            ints[i++] = integer;
        }
        return ints;
	}
	
	/*
	 * 先对其进行排序，随后再用俩指针去判断是否存在相等的元素，
	 * 这样的效率更高一些，但写起来很是麻烦，需要很多判断
	 */
	public int[] method3(int[] num1,int[] num2) {
		Arrays.sort(num1);
		Arrays.sort(num2);
		int i = 0,j = 0,k = 0;
		while(i<num1.length&&j<num2.length) {
			if (num1[i] == num2[j]) {
                num1[k++] = num1[i];
                i++;
                while (i < num1.length && num1[i] == num1[i - 1]) {
                    i++;
                }
                j++;
                while (j < num2.length && num2[j] == num2[j - 1]) {
                    j++;
                }
            } else if (num1[i] < num2[j]) {
                i++;
                while (i < num1.length && num1[i] == num1[i - 1]) {
                    i++;
                }
            } else {
                j++;
                while (j < num2.length && num2[j] == num2[j - 1]) {
                    j++;
                }
            }
		}
		int[] ints = new int[k];
        for (int l = 0; l < k; l++) {
            ints[l] = num1[l];
        }
        return ints;
	}
	public static void main(String[] args) {
		Test_02 test = new Test_02();
		int[] num1 = {1,7,7,8,9,12,45,65};
		int[] num2 = {1,5,7,7,2,8,12,34,6};
		
		//测试三个方法的结果
		System.out.println(Arrays.toString(test.method1(num1,num2)));
		System.out.println(Arrays.toString(test.method2(num1,num2)));
		System.out.println(Arrays.toString(test.method3(num1,num2)));
	}
}
