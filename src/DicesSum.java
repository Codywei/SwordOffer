import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 n �����ӵĵ���

 ��Ŀ����
 �� n ���������ڵ��ϣ��������Ϊ s �ĸ��ʡ�

 ����˼·
 1.��̬�滮�ⷨ
 ʹ��һ����ά���� dp �洢�������ֵĴ��������� dp[i][j] ��ʾǰ i �����Ӳ������� j �Ĵ�����

2. ��̬�滮�ⷨ + ��ת����
 * */
public class DicesSum {
    public List<Map.Entry<Integer, Double>> dicesSum1(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++){
             /* ʹ�� i ��������С����Ϊ i */
            for (int j = i; j <= pointNum; j++){
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }

        return ret;
    }

    public List<Map.Entry<Integer, Double>> dicesSum2(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            dp[0][i] = 1;
        }
        /* ��ת��� */
        int flag = 1;
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++) {
                 /* ��ת�������� */
                dp[flag][j] = 0;
            }

            for (int j = i; j <= pointNum; j++){
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[flag][j] += dp[1 - flag][j - k];
                }
            }
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));
        }

        return ret;
    }

    public static void main(String[] args) {
        DicesSum ds=new DicesSum();
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        ret=ds.dicesSum1(6);
        System.out.println(ret.get(0).getKey());
        System.out.println(ret.get(0).getValue());
    }

}
