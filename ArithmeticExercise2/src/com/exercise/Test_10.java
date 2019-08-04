package com.exercise;
/**
 * ͳ������С�ڷǸ����� n ��������������
 *
 * ʾ��:
 * ����: 10
 * ���: 4
 * ����: С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
 */
public class Test_10 {
	public static void method1(int n) {
		for(int i=2;i<n;i++) {
			boolean isPrime = true;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(i);
			}
		}
	}
	
	public static void method2(int n) {
		boolean[] isPrime = new boolean[n];
		for(int i=2;i<n;i++) {
			isPrime[i] = true;
		}
		for(int i=2;i*i<n;i++) {
			if(!isPrime[i]) {
				continue;
			}
			for(int j=i*i;j<n;j+=i) {
				isPrime[j]=false;
			}
		}
		for(int i=2;i<n;i++) {
			if(isPrime[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		method1(100);
		method2(100);
	}
}
