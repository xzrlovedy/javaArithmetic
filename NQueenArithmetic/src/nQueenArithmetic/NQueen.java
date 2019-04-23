package nQueenArithmetic;
/**
 * n�ʺ����ɰ˻ʺ������ݱ�����ġ��������ǹ����������������˹����ɪ����1848�������
 * ��8��8��Ĺ��������ϰڷŰ˸��ʺ�ʹ�䲻�ܻ��๥���������������ʺ󶼲��ܴ���ͬһ�С�ͬһ�л�ͬһб���ϣ�
 * ���ж����ְڷ���
 * 
 * ��ѡ��������ǰ�������ԴﵽĿ�ꡣ����̽����ĳһ��ʱ������ԭ��ѡ�񲢲��Ż�ﲻ��Ŀ�꣬
 * ���˻�һ������ѡ�������߲�ͨ���˻����ߵļ���Ϊ���ݷ���
 * @author Administrator
 *
 */
public class NQueen {
	private int n;
    private long count;
    /*����������һ����뵽�ö�ά��������ʾ���綨���ά����a[8][8],
               ��a[0][0]=1�������̵�һ�е�һ�������ӣ�a[3][4]=0�������̵�4�е�5�������ӡ���
               ��ʵ����ֻ��һ��һά������Խ�������⡣
               ���磬ʹ��a[8]����ʾ��������ʱ������a[0]=7������ʾ��1�е�7�������ӣ�
      a[1]=2����ʾ��2�е�2�������ӣ��������ַ����������ж����ʺ��Ƿ���ͬһ�С�
     */
    private int[] arr;

    public NQueen(int n){
        this.n = n;
        count = 0;
        arr = new int[n];
    }
    /**
     * 
     * @param row ��ǰ��
     * @param col ��ǰ��
     * @return
     */
    public boolean Check(int row, int col){
        for(int i = 0; i < row; i++){ //�Ƚ�֮ǰ��row-1��
            if(col == arr[i] || Math.abs(row - i) == Math.abs(col - arr[i])) //��ͬһ�л�����ͬһб�ߡ�һ������ͬһ��
                return false;
        }
        return true;
    }

    public void FindNQueen(int k) {
        if (k == n) {   //���һ�ֽ⣬ count+1
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (Check(k, i)) {   //����Ƿ���������
                arr[k] = i;      //��¼
                FindNQueen(k + 1);   //�ݹ����
            }
        }

    }

    public static void main(String args[]){
        NQueen nQueen = new NQueen(8);
        nQueen.FindNQueen(0);
        System.out.println(nQueen.count);
    }
}
