/**
 �����е�·�������飬��̬�滮��

 ��Ŀ����
 �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ�
 ��������ľ��������һ�� bfce ·����

 ����˼·
 ���ݷ�
 * */
public class HasPath {

    private final static int[][] next={{0,-1},{0,1},{1,0},{-1,0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        //������Ҫ��hasPath�еľֲ�������ֵ�����Ա���������������ڷ����ݹ�ʱ�����������
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        //����ÿһ���ո񣬽�ÿ���ո���Ϊ�����һ��
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
        //��������󷵻�
        if (pathLen == str.length) {
            return true;
        }
        //1.����Խ�磻2.��ǰ���ʽڵ���·���϶�ӦԪ�ز�����3.��ǰ�ڵ��ѱ����ʹ�
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        //��ʼ��ע�ѷ��ʱ�־
        marked[r][c] = true;
        //���ĸ������ϻ���
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        //�������ʺ�ָ���־����Ϊ��������������backtracking��Ҫ�����֮ǰ���ֳ���
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
