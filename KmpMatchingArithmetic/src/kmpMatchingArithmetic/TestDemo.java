package kmpMatchingArithmetic;

public class TestDemo {
	public static void main(String[] args) {
		SimpleMatching.simpleMatch("abcabaabaabcacb", "abaabcac");
		System.out.println("###################");
		System.out.println("KMPģʽ��ƥ��"+KmpMatching_01.kmpMatch("abcabaabaabcacb", "abaabcac")+"��");
	}
}
