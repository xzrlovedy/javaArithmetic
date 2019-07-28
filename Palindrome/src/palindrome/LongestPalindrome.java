package palindrome;
/**
 * 找出最长的回文子串
 * 一个更好的办法是从中间开始判断，因为回文字符串以字符串中心对称。
 * 一个长度为N的字符串可能的对称中心有2N-1个，至于这里为什么是2N-1而不是N个，是因为可能对称的点可能是两个字符之间。
 * @author Administrator
 *
 */
public class LongestPalindrome {
	/**
	 * 判断一个字符数组从某一个或两个点开始向两端拓展，是否是回文串，是则返回该子串
	 * @param ch
	 * @param i
	 * @param j
	 * @return
	 */
	public static String getEvery(char[] ch,int i,int j) {
		while(i>=0&&j<=ch.length-1&&ch[i]==ch[j]) {
			i--;
			j++;
		}
		return String.valueOf(ch).substring(i+1,j);
	}
	/**
	 * 历原数组，提取出最长的回文子串
	 * @param s
	 * @return
	 */
	public static String getPalindrome(String s) {
		char[] ch = s.toCharArray();
		String str = " ";
		String re = "";
		for(int i=0;i<ch.length;i++) {
			re = getEvery(ch,i,i);// 当以一个字符为中轴也就是回文串为奇数时
			if(re.length()>str.length()) {
				str = re;
			}
			re = getEvery(ch,i,i+1);// 当以当前和他后一个字符为轴心，也就是回文串为偶数时
			if(re.length()>str.length()) {
				str = re;
			}
		}
		return str;
	}
	public static void main(String[] args) {
		String str = "yhdyedhyggysbchasasas";
		String result = getPalindrome(str);
		System.out.println(result);
	}
}
