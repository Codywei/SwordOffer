/**
 �����˻�����

 ��Ŀ����
 ����һ������ A[0, 1,..., n-1]���빹��һ������ B[0, 1,..., n-1]������ B �е�Ԫ�� B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��Ҫ����ʹ�ó�����
 * */

public class MultiplySolution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
         /* ���������۳� */
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }

        /* ���������۳� */
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4};
        MultiplySolution ms=new MultiplySolution();
        int[] B=new int[4];
        B=ms.multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
