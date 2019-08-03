package com.exercise;

import java.util.ArrayList;

/**
 * ����һ���Ǹ����� num������������λ�ϵ�������ӣ�ֱ�����Ϊһλ����
 * 
 * ʾ��:
 * ����: 38
 * ���: 2
 * ����: ��λ��ӵĹ���Ϊ��3 + 8 = 11, 1 + 1 = 2�� ���� 2 ��һλ�������Է��� 2��
 *
 * ����:
 * ����Բ�ʹ��ѭ�����ߵݹ飬���� O(1) ʱ�临�Ӷ��ڽ�����������
 */
public class Test_09 {
	/*
	 * ��һ����������ѭ�������ϰ�ÿһλȡ�����ŵ�list���棬���Ӻͣ�
	 * ��Ҳ�����Լ���������ڷ���ÿһλ��ʱ��ͽ��мӺͲ������и�ֵ������
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
	 * ��Ȼ����Ҫ��սһ�½���������������ѭ���͵ݹ飬����ʱ�临�Ӷ�0(1)���������⣬�������Ҫ��Ѱ�����ˡ�
	 * ��numС��9����ֻ��һλʱ��ֱ�ӷ���num������9ʱ������ܱ�9�������򷵻�9��
	 *  ������ܱ��������ͷ��ر�9����������
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
