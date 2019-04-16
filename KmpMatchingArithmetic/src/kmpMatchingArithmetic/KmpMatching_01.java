package kmpMatchingArithmetic;
/**
 * KMP�㷨
 * ����ģʽ��T�е�ǰj���ַ���ɵ��Ӵ�����������next[j]���һ��ֵ��
 * ��ģʽ��Tƥ������j���ַ�ʱ����������ȣ���iָ�벻�䣬��jָ����Ϊnext[j]��ֵ��Ȼ��������бȽϡ�
 * @author Administrator
 *
 */
public class KmpMatching_01 {
	/**
     * ���һ���ַ������next���顣
     * ��ģʽ��Tƥ������j���ַ�ʱƥ��ʧ�ܣ�iָ�벻�䣬��jָ����Ϊnext[j]��ֵ��
     * ��j��ֵΪ-1����i��jͬʱ��1����������������ıȽϡ�
     * @param t �ַ�����
     * @return next����
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
                //��k==-1������ѭ��ʱ��next[j] = 0������next[j]����break֮ǰ����ֵ
                next[j] = 0;  
            }
        }
        return next;
    }

    /**
     * ������s��ģʽ��t����KMPģʽƥ��
     * @param source ����
     * @param pattern ģʽ��
     * @return ��ƥ��ɹ�������t��s�е�λ�ã���һ����ͬ�ַ���Ӧ��λ�ã�����ƥ��ʧ�ܣ�����-1
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
