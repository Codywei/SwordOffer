/**
 矩阵中的路径（数组，动态规划）

 题目描述
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 例如下面的矩阵包含了一条 bfce 路径。

 解题思路
 回溯法
 * */
public class HasPath {

    private final static int[][] next={{0,-1},{0,1},{1,0},{-1,0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        //这里需要把hasPath中的局部变量赋值给类成员变量，这样才能在方法递归时共享这个变量
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        //遍历每一个空格，将每个空格作为起点试一下
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;


    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        //长度满足后返回
        if (pathLen == str.length) {
            return true;
        }
        //1.访问越界；2.当前访问节点与路径上对应元素不符；3.当前节点已被访问过
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        //开始标注已访问标志
        marked[r][c] = true;
        //在四个方向上回溯
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        //结束访问后恢复标志（因为还有其他起点进行backtracking，要清理好之前的现场）
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[idx++];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        char[]array={'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[]str={'b','f','c','e'};
        HasPath hp=new HasPath();
        System.out.println(hp.hasPath(array,3,4,str));
    }
}
