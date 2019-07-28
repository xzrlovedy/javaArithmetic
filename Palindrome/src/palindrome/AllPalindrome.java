package palindrome;

import java.util.ArrayList;

/**
 * ���һ���ַ��������л����Ӵ�����
 * @author Administrator
 *
 */
public class AllPalindrome {
	
	public ArrayList<ArrayList<String>> partition(String s){
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		if(s==null||s.length()==0) {
			return arr;
		}
		ArrayList<String> list = new ArrayList<String>();
		dfs(0,s,list,arr);
		return arr;
	}
	
	//���ݷ�
	private void dfs(int index,String s,ArrayList<String> preList,ArrayList<ArrayList<String>> arr) {
		if(index==s.length()) {
			arr.add(new ArrayList<String>(preList));
			return;
		}
		ArrayList<String> list = new ArrayList<String>(preList);
		for(int i = index;i!=s.length();i++) {
			if(isHui(s,index,i)) {
				list.add(s.substring(index,i+1));
				//�ݹ����
				dfs(i+1,s,list,arr);
				list.remove(list.size()-1);
			}
		}
	}
	//�ж��Ƿ��ǻ���
	private boolean isHui(String s,int start,int end) {
		while(start<=end) {
			if(s.charAt(start++)!=s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String s="iouhuoi";
		AllPalindrome ap = new AllPalindrome();
		System.out.println(ap.partition(s));
	}
}


