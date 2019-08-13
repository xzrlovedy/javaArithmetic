package stringControl;
/**
 * 统计一行字符串中有多少单词
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
		System.out.println(s+"\n单词个数为："+wordsCount(s));
	}
}
