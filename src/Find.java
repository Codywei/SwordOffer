/**
 ��ά�����еĲ���

 ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * */
public class Find {
    public boolean find(int target, int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rows=matrix.length;
        int cols=matrix.length;
        int r=0;
        int c=cols-1;
        while(r<=rows-1&&c>=1){
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
        System.out.println(find.find(20,mat));


    }
}
