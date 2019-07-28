package palindrome;
/**
 * �ҳ���Ļ����Ӵ�
 * һ�����õİ취�Ǵ��м俪ʼ�жϣ���Ϊ�����ַ������ַ������ĶԳơ�
 * һ������ΪN���ַ������ܵĶԳ�������2N-1������������Ϊʲô��2N-1������N��������Ϊ���ܶԳƵĵ�����������ַ�֮�䡣
 * @author Administrator
 *
 */
public class LongestPalindrome {
	/**
	 * �ж�һ���ַ������ĳһ���������㿪ʼ��������չ���Ƿ��ǻ��Ĵ������򷵻ظ��Ӵ�
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
	 * ��ԭ���飬��ȡ����Ļ����Ӵ�
	 * @param s
	 * @return
	 */
	public static String getPalindrome(String s) {
		char[] ch = s.toCharArray();
		String str = " ";
		String re = "";
		for(int i=0;i<ch.length;i++) {
			re = getEvery(ch,i,i);// ����һ���ַ�Ϊ����Ҳ���ǻ��Ĵ�Ϊ����ʱ
			if(re.length()>str.length()) {
				str = re;
			}
			re = getEvery(ch,i,i+1);// ���Ե�ǰ������һ���ַ�Ϊ���ģ�Ҳ���ǻ��Ĵ�Ϊż��ʱ
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
