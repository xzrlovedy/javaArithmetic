package nQueenArithmetic;
/**
 * n皇后是由八皇后问题演变而来的。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：
 * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，
 * 问有多少种摆法。
 * 
 * 按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，
 * 就退回一步重新选择，这种走不通就退回再走的技术为回溯法。
 * @author Administrator
 *
 */
public class NQueen {
	private int n;
    private long count;
    /*棋盘坐标上一般会想到用二维数组来表示，如定义二维数组a[8][8],
               则a[0][0]=1代表棋盘第一行第一列有棋子，a[3][4]=0代表棋盘第4行第5列无棋子……
               但实际上只用一个一维数组可以解决该问题。
               例如，使用a[8]来表示棋盘坐标时，假设a[0]=7，即表示第1行第7列有棋子，
      a[1]=2即表示第2行第2列有棋子，而且这种方法无须再判断两皇后是否在同一行。
     */
    private int[] arr;

    public NQueen(int n){
        this.n = n;
        count = 0;
        arr = new int[n];
    }
    /**
     * 
     * @param row 当前行
     * @param col 当前列
     * @return
     */
    public boolean Check(int row, int col){
        for(int i = 0; i < row; i++){ //比较之前的row-1列
            if(col == arr[i] || Math.abs(row - i) == Math.abs(col - arr[i])) //在同一列或者在同一斜线。一定不在同一行
                return false;
        }
        return true;
    }

    public void FindNQueen(int k) {
        if (k == n) {   //求出一种解， count+1
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (Check(k, i)) {   //检查是否满足条件
                arr[k] = i;      //记录
                FindNQueen(k + 1);   //递归查找
            }
        }

    }

    public static void main(String args[]){
        NQueen nQueen = new NQueen(8);
        nQueen.FindNQueen(0);
        System.out.println(nQueen.count);
    }
}
