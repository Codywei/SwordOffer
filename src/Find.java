/**
 二维数组中的查找(数组，矩阵，查找)

 题目描述
 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 解题思路
 从右上角开始查找。矩阵中的一个数，它左边的数都比它小，下边的数都比它大。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间。
 * */
public class Find {
    public boolean find(int target, int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        //从右上角开始
        int r=0;
        int c=cols-1;
        while(r<=rows-1&&c>=0){
            if(matrix[r][c]==target){
                return true;
            }
            else if(matrix[r][c]>target){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]mat={ {1,   4,  7, 11, 15}, {2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        Find find=new Find();
        System.out.println(find.find(3,mat));


    }
}
