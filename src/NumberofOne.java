/**
 �������� 1 �ĸ���

 ��Ŀ����
 ����һ��������������������Ʊ�ʾ�� 1 �ĸ�����

 ����˼·
 n&(n-1)
 ��λ����ȥ�� n ��λ����ʾ����͵���һλ��ʱ�临�Ӷȣ�O(M)������ M ��ʾ 1 �ĸ�����

 ����ֱ�ӵ��ú���API
 */

public class NumberofOne {
    public int NumberOfone(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }

    public int NumberOfone2(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        NumberofOne noo=new NumberofOne();
        System.out.println(noo.NumberOfone(15));
        System.out.println(noo.NumberOfone2(15));
    }
}
