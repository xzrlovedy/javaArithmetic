package stringControl;
/**
 * ͳ��һ���ַ������ж��ٵ���
 * @author Administrator
 *
 */
public class WordsCount {
	public static int wordsCount(String s) {
		int word = 0;
		int count =0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == ' ') {
				word = 0;
			}else if(word == 0) {
				word = 1;
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "how are you";
		System.out.println(s+"\n���ʸ���Ϊ��"+wordsCount(s));
	}
}
