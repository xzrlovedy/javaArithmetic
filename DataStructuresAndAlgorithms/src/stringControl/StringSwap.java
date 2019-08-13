package stringControl;
/**
 * 实现字符串的反转
 * 例如：how are you反转为you are how,单词本身不能反转
 * @author Administrator
 *
 */
public class StringSwap {
	
	public void swap(char[] cArr,int front,int end) {
		while(front<end) {
			char tmp = cArr[end];
			cArr[end] = cArr[front];
			cArr[front] = tmp;
			front++;
			end--;
		}
	}
	
	public String swapWords(String s) {
		char[] cArr = s.toCharArray();
		//对整个字符串进行字符反转操作
		swap(cArr,0,cArr.length-1);
		int begin = 0;
		//对每个单词进行反转
		for(int i=1;i<cArr.length;i++) {
			if(cArr[i] == ' ') {
				swap(cArr,begin,i-1);
				begin = i+1;
			}
		}
		swap(cArr,begin,cArr.length-1);
		return new String(cArr);
	}
	
	public static void main(String[] args) {
		StringSwap ss = new StringSwap();
		String str = "how are you";
		System.out.println(ss.swapWords(str));
	}
}
