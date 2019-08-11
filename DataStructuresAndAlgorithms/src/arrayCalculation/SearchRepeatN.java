package arrayCalculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的元素，重复次数和重复位置
 * @author Administrator
 *
 */
public class SearchRepeatN {
	public Map getIndex(String[] str) {
		//key值中记录重复的字符串，value记录重复的次数和位置
		Map<String,Map<Integer,ArrayList<Integer>>> map = new HashMap<String,Map<Integer,ArrayList<Integer>>>();
		int i = 0;
		for(String s:str) {
			if(map.get(s) == null) {
				//key记录重复字符串出现的次数，value记录重复字符串的位置
				Map<Integer,ArrayList<Integer>> countWhere = new HashMap<Integer,ArrayList<Integer>>();
				//重复字符串计数器
				int count = 0;
				ArrayList<Integer> list = new ArrayList<Integer>();
				//重复字符串下标
				list.add(i);
				countWhere.put(count, list);
				map.put(s, countWhere);
				i++;
			}else {
				for(int c:map.get(s).keySet()) {
					ArrayList<Integer> index = map.get(s).get(c);
					//增加出现index的位置
					index.add(i);
					c++;
					//更新计数器和下标信息
					map.get(s).put(c, index);
					map.get(s).remove(--c);
				}
				i++;
			}
		}
		return map;
	}
	
	public void display(String[] array) throws Exception {
		if(array == null) {
			throw new Exception("输入数组为空，请重新输入！");
		}
		Map<String,HashMap<Integer,ArrayList<Integer>>> map = getIndex(array);
		//存取字符串出现的次数
		ArrayList<Integer> count = new ArrayList<Integer>();
		//循环获取记录字符串重复次数和位置map
		for(Map.Entry<String, HashMap<Integer,ArrayList<Integer>>> key:map.entrySet()) {
			//循环获取记录字符串重复次数
			for (Map.Entry<Integer,ArrayList<Integer>> map1 : key.getValue().entrySet()){
				count.add(map1.getKey());
			}
		}
		//对集合排序，默认是升序，最后一个是重复次数最多的
		Collections.sort(count);
		//循环获取所有的重复字符串
		for (String key : map.keySet()){
			//循环获取重复字符串的次数
			for (int c:map.get(key).keySet()){
				//和最大重复次数对比，相等就代表当前的字符串是重复次数最多的那个
				if(c==count.get(count.size()-1)){
					 System.out.printf("重复次数最多的字符串是：%s,重复次数%d,所在位置：%s\n",key,c,map.get(key).get(c));
				}
			}
		}
		//输出指定重复次数的字符串信息
		for(String key:map.keySet()) {
			for(int c:map.get(key).keySet()) {
				if(c==5||c==6||c==1) {
					System.out.printf("重复字符串：%s,重复次数：%d,重复字符串出现位置：%s\n",key,c,map.get(key).get(c));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] array = {"aa","bb","c","aa","adasd","afwe","bb","aa"};
		SearchRepeatN sr = new SearchRepeatN();
		try {
			sr.display(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
