/**
 ���θ���

 ��Ŀ����
 ���ǿ����� 2*1 ��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ������� n �� 2*1 ��С�������ص��ظ���һ�� 2*n �Ĵ���Σ��ܹ��ж����ַ�����

 ����˼·
 ����̨��˼·һ��
 * */
public class RectCover {
    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        RectCover rc =new RectCover();
        System.out.println(rc.RectCover(6));
    }
}
