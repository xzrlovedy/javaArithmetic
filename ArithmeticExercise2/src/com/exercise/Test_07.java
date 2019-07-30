package com.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ��λ���������б��м����������б�����ż������λ�������м���������ƽ��ֵ��
 *
 * ���磬
 * [2,3,4] ����λ���� 3
 * [2,3] ����λ���� (2 + 3) / 2 = 2.5
 *
 * ���һ��֧���������ֲ��������ݽṹ��
 *     void addNum(int num) - �������������һ�����������ݽṹ�С�
 *     double findMedian() - ����Ŀǰ����Ԫ�ص���λ����
 *
 * ʾ����
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class Test_07 {
	
    List<Integer> list = new ArrayList<Integer>();
    
    public void addNum(int num) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = list.get(mid);
            if (val < num) {
            	left = mid + 1;
            }else {
            	right = mid;
            }
        }
        if (list.size() > 0 && num > list.get(list.size() - 1)) {
        	list.add(num);
        }else{
        	list.add(left, num);
        }
    }

    public double findMedian() {
        int len = list.size();
        if (len % 2 == 1) {
        	return (double) list.get(len / 2);
        }else{
        	return list.get(len / 2) / 2.0 + list.get(len / 2 - 1) / 2.0;
        }
    }
    public static void main(String[] args) {
    	Integer[] ints = {2,3,4};
		Test_07 test = new Test_07();
		test.list.addAll(Arrays.asList(ints));
		System.out.println(test.findMedian());
		
		test.addNum(6);
		System.out.println(test.findMedian());
		
		test.addNum(2);
		System.out.println(test.findMedian());
	}
}
