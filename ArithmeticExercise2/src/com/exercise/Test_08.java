package com.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 * 输入: s = "eat", t = "tea"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "hat"
 * 输出: false
 */
public class Test_08 {
	/*
	 * 转换为字符数组，在排序、比较
	 */
	public static boolean method1(String s,String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		return Arrays.equals(sc, tc);
	}
	/*
	 * 用Map对每个字母的出现次数进行统计再检查另一个字符串，消费，看最后Map是否为空
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
