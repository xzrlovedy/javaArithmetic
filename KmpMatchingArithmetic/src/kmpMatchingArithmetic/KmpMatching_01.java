package kmpMatchingArithmetic;
/**
 * KMP算法
 * 对于模式串T中的前j个字符组成的子串，设置数组next[j]存放一个值，
 * 当模式串T匹配至第j个字符时与主串不相等，则i指针不变，将j指针置为next[j]的值，然后继续进行比较。
 * @author Administrator
 *
 */
public class KmpMatching_01 {
	/**
     * 求出一个字符数组的next数组。
     * 当模式串T匹配至第j个字符时匹配失败，i指针不变，将j指针置为next[j]的值，
     * 若j的值为-1，则将i和j同时加1。随后继续进行逐个的比较。
     * @param t 字符数组
     * @return next数组
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    k = next[k];
                }
                //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
                next[j] = 0;  
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     * @param source 主串
     * @param pattern 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String source, String pattern){
        char[] source_arr = source.toCharArray();
        char[] pattern_arr = pattern.toCharArray();
        int[] next = getNextArray(pattern_arr);
        int i = 0, j = 0;
        while (i<source_arr.length && j<pattern_arr.length){
            if(j == -1 || source_arr[i]==pattern_arr[j]){
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }
        if(j == pattern_arr.length)
            return i-j;
        else
            return -1;
    }
}
