package kmpMatchingArithmetic;
/**
 * ���ص��ַ���ģʽƥ���㷨
 * @author Administrator
 *
 */
public class SimpleMatching {
	/**
	 * 
	 * @param source Ŀ�괮
	 * @param pattern ģʽ��
	 */
	public static void simpleMatch(String source, String pattern) {
        int res=0;
        int sourceLength=source.length();
        int patternLength=pattern.length();
        for(int i=0;i<=(sourceLength-patternLength);i++){
            res++;
            String str=source.substring(i, i+patternLength);
            if(str.equals(pattern)){
                System.out.println("����ģʽ��ƥ��ɹ�");
                break;
            }
        }
        System.out.println("����ģʽ��һ��ƥ��"+res+"����");
    }
	
}
