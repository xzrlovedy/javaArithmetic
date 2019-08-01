package com.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ��λ��
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�
 *
 * ʾ�� 1:
 * ����: s = "eat", t = "tea"
 * ���: true
 *
 * ʾ�� 2:
 * ����: s = "rat", t = "hat"
 * ���: false
 */
public class Test_08 {
	/*
	 * ת��Ϊ�ַ����飬�����򡢱Ƚ�
	 */
	public static boolean method1(String s,String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		return Arrays.equals(sc, tc);
	}
	/*
	 * ��Map��ÿ����ĸ�ĳ��ִ�������ͳ���ټ����һ���ַ��������ѣ������Map�Ƿ�Ϊ��
	 */
	public static boolean method2(String s, String t) {
		Map<Character,Integer> map = new HashMap<>();
		for(char ch:s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		for(char ch:t.toCharArray()) {
			Integer count = map.get(ch);
			if(count == null) {
				return false;
			}else if(count>1) {
				map.put(ch, count - 1);
			}else {
				map.remove(ch);
			}
		}
		return map.isEmpty();
	}
	public static void main(String[] args) {
		System.out.println(method1("eat","tea"));
		System.out.println(method1("hat","rat"));
		System.out.println(method2("eat","tea"));
		System.out.println(method2("hat","rat"));
	}
}
