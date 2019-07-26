package com.exercise;
/**
 * �ж�һ�����Ƿ�Ϊ��ȫƽ��������ʹ��Math�ⷽ��
 * @author Administrator
 *
 */
public class Test_01 {
	/*
	 * ���ֲ��� �Ƿ����һ������ƽ�����ڸ�����
	 */
	public boolean method1(int num) {
		if(num == 0) {return true;}
		int left = 1,right = (num < 46340?num:46340),temp = 0;
		while(left <= right) {
			temp = left + (right-left)/2;
			if(num > temp * temp) {
				left = temp +1;
			}else if(num == temp*temp) {
				return true;
			}else {
				right = temp-1;
			}
		}
		return false;
	}
	/*
	 * ������ѧ֪ʶ���ҹ���
	 * 1=1
	 * 4=1+3
	 * 9=1+3+5
	 * 16=1+3+5+7
	 */
	public boolean method2(int num) {
		int temp = 1;
		while(num>0) {
			num-=temp;
			temp+=2;
		}
		return num == 0;
	}
}
