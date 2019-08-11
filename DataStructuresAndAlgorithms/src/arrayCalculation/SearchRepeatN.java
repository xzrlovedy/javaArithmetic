package arrayCalculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * �ҳ��������ظ���Ԫ�أ��ظ��������ظ�λ��
 * @author Administrator
 *
 */
public class SearchRepeatN {
	public Map getIndex(String[] str) {
		//keyֵ�м�¼�ظ����ַ�����value��¼�ظ��Ĵ�����λ��
		Map<String,Map<Integer,ArrayList<Integer>>> map = new HashMap<String,Map<Integer,ArrayList<Integer>>>();
		int i = 0;
		for(String s:str) {
			if(map.get(s) == null) {
				//key��¼�ظ��ַ������ֵĴ�����value��¼�ظ��ַ�����λ��
				Map<Integer,ArrayList<Integer>> countWhere = new HashMap<Integer,ArrayList<Integer>>();
				//�ظ��ַ���������
				int count = 0;
				ArrayList<Integer> list = new ArrayList<Integer>();
				//�ظ��ַ����±�
				list.add(i);
				countWhere.put(count, list);
				map.put(s, countWhere);
				i++;
			}else {
				for(int c:map.get(s).keySet()) {
					ArrayList<Integer> index = map.get(s).get(c);
					//���ӳ���index��λ��
					index.add(i);
					c++;
					//���¼��������±���Ϣ
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
			throw new Exception("��������Ϊ�գ����������룡");
		}
		Map<String,HashMap<Integer,ArrayList<Integer>>> map = getIndex(array);
		//��ȡ�ַ������ֵĴ���
		ArrayList<Integer> count = new ArrayList<Integer>();
		//ѭ����ȡ��¼�ַ����ظ�������λ��map
		for(Map.Entry<String, HashMap<Integer,ArrayList<Integer>>> key:map.entrySet()) {
			//ѭ����ȡ��¼�ַ����ظ�����
			for (Map.Entry<Integer,ArrayList<Integer>> map1 : key.getValue().entrySet()){
				count.add(map1.getKey());
			}
		}
		//�Լ�������Ĭ�����������һ�����ظ���������
		Collections.sort(count);
		//ѭ����ȡ���е��ظ��ַ���
		for (String key : map.keySet()){
			//ѭ����ȡ�ظ��ַ����Ĵ���
			for (int c:map.get(key).keySet()){
				//������ظ������Աȣ���Ⱦʹ���ǰ���ַ������ظ����������Ǹ�
				if(c==count.get(count.size()-1)){
					 System.out.printf("�ظ����������ַ����ǣ�%s,�ظ�����%d,����λ�ã�%s\n",key,c,map.get(key).get(c));
				}
			}
		}
		//���ָ���ظ��������ַ�����Ϣ
		for(String key:map.keySet()) {
			for(int c:map.get(key).keySet()) {
				if(c==5||c==6||c==1) {
					System.out.printf("�ظ��ַ�����%s,�ظ�������%d,�ظ��ַ�������λ�ã�%s\n",key,c,map.get(key).get(c));
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
