package rodCutMethods;
/**
 * 
 * @author Administrator
 *
 */
public class RodCutMethods {
	/**
	 * �Զ��������
	 * @param p �۸��int����������
	 * @param n �����ܳ���
	 * @return
	 */
	public static int MEMOIZED_CUT_ROD(int[] p, int n) {
		int[] arr = new int[n + 1];// ��¼��ͬ���ȵ����Ž�
		for (int i = 0; i <= n; i++) {
			arr[i] = -1;// ��ʼ�����Ž�
		}
		return MEMOIZED_CUT_ROD_AUX(p, n, arr);
	}

	public static int MEMOIZED_CUT_ROD_AUX(int[] p, int n, int[] arr) {
		int max;// �洢���Ž��ֵ
		if (arr[n] >= 0) {
			return arr[n];
		}
		if (n == 0) {
			max = 0;
		} else {
			max = -1;
			for (int i = 1; i <= n; i++) {
				max = Math.max(max, p[i] + MEMOIZED_CUT_ROD_AUX(p, n - i, arr));
			}
		}
		arr[n] = max;
		return max;
	}

	public static void main(String[] args) {
		//�۸���±����������ȣ�ֵΪ�۸�
		int [] p = {0,1,5,8,9,10,17,17,20,24,30};
		//�����ܳ���
		int n = 9;
		int max = MEMOIZED_CUT_ROD(p, n);
		System.out.print("����Ϊ" + n + "�ĸ�������и���������Ϊ��" + max);
	}
}
