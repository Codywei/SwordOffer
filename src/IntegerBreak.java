/**
 �����ӣ�̰�ģ���̬�滮��

 ��Ŀ����
 ��һ�����Ӽ��ɶ�Σ�����ʹ��ÿ�εĳ��ȳ˻����

 ����˼·
 1.̰��
 �����ܶ������Ϊ 3 �����ӣ����Ҳ������г���Ϊ 1 �����ӳ��֡���������ˣ��ʹ��Ѿ��кó���Ϊ 3 ���������ó�һ���볤��Ϊ 1 ������������ϣ��������г����γ���Ϊ 2 �����ӡ�
 ֤������ n >= 5 ʱ��3(n - 3) - 2(n - 2) = n - 5 >= 0����˰ѳ��ȴ��� 5 �������г����Σ�������һ�γ���Ϊ 3 ����ʹ�����εĳ˻����

 2.��̬�滮
 * */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++) {

                //�������������dp[i]���ϴε������������ֵ��j * (i - j)��ָ��ǰ����ֱ����˵Ľ����dp[j] * (i - j)),��dp[j]��������ֵ�Ļ����ٳˣ�i-j����
                //����dp[2]=1,������j * (i - j)���㣬dp[3]=2,����dp[j] * (i - j))������dp[3]=1��ȡ�ϴ�ļ�������
               dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));


            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        IntegerBreak ib=new IntegerBreak();
        System.out.println(ib.integerBreak(3));
        System.out.println(ib.integerBreak2(7));
    }

}
