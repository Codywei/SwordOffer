/**
 ��̨��

 ��Ŀ����
 һֻ����һ�ο������� 1 ��̨�ף�Ҳ�������� 2 ���������������һ�� n ����̨���ܹ��ж�����������

 ����˼·
 ��ȥ����һ����Ծ�����԰�ǰ1����ǰ2�����������
 * */
public class JumpFloor {
    public int JumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
         JumpFloor jf=new JumpFloor();
        System.out.println(jf.JumpFloor(6));
    }
}
