package com.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 子字符串出现的位置
 * 
 * 给出 字符串 text 和 字符串列表 words, 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串
 * text[i]...text[j]（包括 i 和 j）属于字符串列表 words。
 * 示例 1:
 * 输入: text = "ababa", words = ["aba","ab"]
 * 输出: [[0,1],[0,2],[2,3],[2,4]]
 * 解释:
 * 注意，返回的配对可以有交叉，比如，"aba" 既在 [0,2] 中也在 [2,4] 中
 *
 * 提示:
 *     所有字符串都只包含小写字母。
 *     保证 words 中的字符串无重复。
 *     1 <= text.length <= 100
 *     1 <= words.length <= 20
 *     1 <= words[i].length <= 50
 *     按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，当第一个索引对相同时按照第二个索引对排序）。
 * 
 * 原文：https://blog.csdn.net/qq_37482202/article/details/90740721 
 */

public class Test_03 {
	/*
	 * 使用正则表达式
	 * 正则表达式不会匹配已经匹配过的位置，只会往后走，但是题目要求交叉匹配
	 * 运行结果缺少[2,4]
	 */
	public static int[][] method1(String text, String[] words) {
		List<List<Integer>> resultList =new ArrayList<>();
        List<Integer> integers=new ArrayList<>();
        for (String s:words){
            Matcher matcher = Pattern.compile(s).matcher(text);
            int needAdd=s.length()-1;
            while (matcher.find()){
                int start=matcher.start();
                integers=new ArrayList<>();
                integers.add(start);
                integers.add(start+needAdd);
                resultList.add(integers);
            }
        }
        int[][] result=new int[resultList.size()][2];
        int length=result.length;
        for (int i=0;i<length;i++){
            result[i]=new int[]{resultList.get(i).get(0),resultList.get(i).get(1)};
        }
        return result;
	}
	/*
	 * 遍历字符串，对每个位置进行子字符串的匹配，匹配不成功就下一个
	 */
	public static int[][] method2(String text, String[] words) {
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> integers = new ArrayList<>();
		int start = 0;
		while(start<text.length()) {
			for(String s:words) {
				int length = s.length();
				if(start+length>text.length()) {
					continue;
				}
				int i=0;
                for (;i<length;i++){
                    if (text.charAt(start+i)!=s.charAt(i)){
                        break;
                    }
                }
                if (i==length){
                    integers=new ArrayList<>();
                    integers.add(start);
                    integers.add(start+length-1);
                    resultList.add(integers);
                }
			}
			start++;
		}
		resultList.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> arg0, List<Integer> arg1) {
				if (arg0.get(0)==arg1.get(0)){
                    if (arg0.get(1)>arg1.get(1)){
                        return 1;
                    }else if (arg0.get(1)<arg1.get(1)){
                        return -1;
                    }else {
                        return 0;
                    }
                }else if (arg0.get(0)>arg1.get(0)){
                    return 1;
                }else {
                    return -1;
                }
			}
		});
		int[][] result=new int[resultList.size()][2];
        int length=result.length;
        for (int i=0;i<length;i++){
            result[i]=new int[]{resultList.get(i).get(0),resultList.get(i).get(1)};
        }
        return result;
	}
	public static void main(String[] args) {
		String[] str = {"aba","ab"};
		for(int i = 0;i<method1("ababa",str).length;i++) {
			System.out.println(Arrays.toString(method1("ababa",str)[i]));
		}
		System.out.println("------------------");
		for(int i = 0;i<method2("ababa",str).length;i++) {
			System.out.println(Arrays.toString(method2("ababa",str)[i]));
		}
	}
}
