package stringControl;
/**
 * 输出字符串的所有组合
 * 
 * 例如：输入abc，这有a,b,c,ab,ac,bc,abc七种组合
 * @author Administrator
 *
 */
public class Combination {
	
	public static void combination(char[] c,int begin,int len,StringBuffer sb ) {
		if(len == 0) {
			System.out.println(sb+" ");
			return;
		}
		if(begin == c.length) {
			return;
		}
		sb.append(c[begin]);
		combination(c,begin+1,len-1,sb);
		sb.deleteCharAt(sb.length()-1);
		combination(c,begin+1,len,sb);
	}
	
	public static void main(String[] args) {
		String s = "abc";
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer("");
		int len = c.length;
		for(int i=1;i<=len;i++) {
			combination(c,0,i,sb);
		}
	}
}
