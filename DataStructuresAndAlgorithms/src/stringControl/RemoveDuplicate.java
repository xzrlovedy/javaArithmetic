package stringControl;
/**
 * É¾³ý×Ö·û´®ÖÐÖØ¸´µÄ×Ö·û
 * @author Administrator
 *
 */
public class RemoveDuplicate {
	public static String reverse(String str) {
		StringBuffer sb = new StringBuffer(str);
		sb = sb.reverse();
		return sb.toString();
	}
	public static String removeDuplicate(String str) {
		str = reverse(str);
		str = str.replaceAll("(?s)(.)(?=.*\\1)","");
		str = reverse(str);
		return str;
	}
	public static void main(String[] args) {
		String str = "adafafasdfdvad";
		str = removeDuplicate(str);
		System.out.println(str);
	}
}
