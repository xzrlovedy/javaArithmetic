package arrayCalculation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FindMostFrequentInArray {
	public static int find(int[] arr) {
		int result = 0;
		int size = arr.length;
		//记录每个元素出现的次数
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(int i=0;i<size;i++) {
			if(m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i])+1);
			}else {
				m.put(arr[i], 1);
			}
		}
		
		//找出出现次数最多的元素
		int most = 0;
		Iterator<Entry<Integer, Integer>> iter = m.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>)iter.next();
			int key = entry.getKey();
			int val = entry.getValue();
			if(val>most) {
				result = key;
				most = val;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1,5,4,3,4,4,5,3,5,5,4,6,6};
		System.out.println(find(array));
	}
}
