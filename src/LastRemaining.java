/**
 ԲȦ�����ʣ�µ������ݹ飩

 ��Ŀ����
 ��С������Χ��һ����Ȧ��Ȼ�����ָ��һ���� m���ñ��Ϊ 0 ��С���ѿ�ʼ������
 ÿ�κ��� m-1 ���Ǹ�С����Ҫ���г��׸裬Ȼ���������Ʒ�����������ѡ������Ҳ��ٻص�Ȧ�У���������һ��С���ѿ�ʼ������ 0...m-1 ���� .... ������ȥ .... ֱ��ʣ�����һ��С���ѣ����Բ��ñ��ݡ�

 ����˼·
 Լɪ�򻷣�ԲȦ����Ϊ n �Ľ���Կ��ɳ���Ϊ n-1 �Ľ��ټ��ϱ����ĳ��� m����Ϊ��ԲȦ�����������Ҫ�� n ȡ�ࡣ
 * */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {

         /* ��������Ĵ��� */
        if (n == 0) {
            return -1;
        }
        /* �ݹ鷵������ */
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;

    }

    public static void main(String[] args) {
        LastRemaining lr=new LastRemaining();
        System.out.println(lr.LastRemaining_Solution(4,2));
    }
}
