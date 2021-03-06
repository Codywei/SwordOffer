/**
机器人的运动范围（矩阵，深度优先遍历，回溯）

 题目描述
 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,37)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？

 解题思路
 回溯法
 * */
public class MovingCount {

    private static final int[][] next={{0,1},{0,-1},{1,0},{-1,0}};
    private int rows;
    private int cols;
    private int[][]digitSum;
    private int threshold;
    private int cnt=0;
    boolean marked[][];

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        this.marked = new boolean[rows][cols];
       //从原点开始进行一次dfs
        dfs(0, 0);
        return cnt;
    }

    private void dfs( int r, int c) {
        //访问越界或节点已被访问
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        //访问后标志不清零
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold) {
            return;
        }
        cnt++;
        for (int[] n : next) {
            dfs(r + n[0], c + n[1]);
        }
    }
    /**
     * 将数组的值转化成行和列各个位数相加的值
     * */
    private void initDigitSum() {

        int[] digitSumOne=new int[Math.max(rows,cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n=i;
            while(n>0){
                digitSumOne[i]+=n%10;
                n=n/10;
            }

        }
        this.digitSum=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j]=digitSumOne[i]+digitSumOne[j];

            }

        }
    }

    public static void main(String[] args) {
        MovingCount mc=new MovingCount();

        System.out.println(mc.movingCount(5,5,6));

        for (int i = 0; i < mc.rows; i++) {
            for (int j = 0; j < mc.cols; j++) {
                System.out.print(mc.digitSum[i][j]+" ");
            }
            System.out.println();
        }
    }
}
