import java.util.ArrayList;

/**
 顺时针打印矩阵（矩阵）


 * */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            //避免奇数行重复打印
            if (r1 != r2) {
                //注意不要重复（四角的元素）
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            //避免奇数列重复打印
            if (c1 != c2) {
                //注意不要重复（四角的元素）
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++; r2--; c1++; c2--;
        }
        return ret;
    }

    public static void main(String[] args) {
        PrintMatrix printmatrix=new PrintMatrix();
        ArrayList<Integer> ret=new ArrayList<>();
        int [][]array={{1,2,3,},{5,6,7},{9,10,11}};
        ret=printmatrix.printMatrix(array);
        for(int i=0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }

    }


}
