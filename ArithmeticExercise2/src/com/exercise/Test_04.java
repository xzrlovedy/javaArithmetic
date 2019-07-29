package com.exercise;

/**
 * 位运算计算两数之和
 * 
 * @author Administrator
 *
 */
public class Test_04 {
	public static int getSum(int a, int b) {
		int sum, carry;
		sum = a ^ b;
		carry = (a & b) << 1;
		if (carry != 0) {
			return getSum(sum, carry);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(getSum(12, 32));
		System.out.println(getSum(10,-4));
	}
}
