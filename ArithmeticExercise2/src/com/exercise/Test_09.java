package com.exercise;

import java.util.ArrayList;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class Test_09 {
	/*
	 * 第一个方法就是循环，不断把每一位取出来放到list里面，最后加和，
	 * 你也可以自己定义变量在分离每一位的时候就进行加和并最后进行赋值操作。
	 */
	public static int method1(int num) {
		ArrayList<Integer> listNum = new ArrayList<Integer>();
		while(num>9) {
			while(num!=0) {
				listNum.add(num%10);
				num/=10;
			}
			for(int a:listNum) {
				num+=a;
			}
			listNum.clear();
		}
		return num;
	}
	/*
	 * 当然我们要挑战一下进阶条件，不适用循环和递归，并在时间复杂度0(1)解决这个问题，那这就需要找寻规律了。
	 * 当num小于9，即只有一位时，直接返回num，大于9时，如果能被9整除，则返回9，
	 *  如果不能被整除，就返回被9除的余数。
	 */
	public static int method2(int num) {
		if(num>9) {
			num%=9;
			if(num==0) {
				return 9;
			}
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(method1(123));
		System.out.println(method2(123));
		System.out.println("---------");
		System.out.println(method1(621));
		System.out.println(method2(621));
	}
}
