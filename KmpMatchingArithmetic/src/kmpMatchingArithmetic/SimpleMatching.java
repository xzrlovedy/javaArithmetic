package kmpMatchingArithmetic;
/**
 * 朴素的字符串模式匹配算法
 * @author Administrator
 *
 */
public class SimpleMatching {
	/**
	 * 
	 * @param source 目标串
	 * @param pattern 模式串
	 */
	public static void simpleMatch(String source, String pattern) {
        int res=0;
        int sourceLength=source.length();
        int patternLength=pattern.length();
        for(int i=0;i<=(sourceLength-patternLength);i++){
            res++;
            String str=source.substring(i, i+patternLength);
            if(str.equals(pattern)){
                System.out.println("朴素模式：匹配成功");
                break;
            }
        }
        System.out.println("朴素模式：一共匹配"+res+"次数");
    }
	
}
