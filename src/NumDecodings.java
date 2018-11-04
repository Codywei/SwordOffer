/**
 �����ַ�����ַ���

 ��Ŀ����
 ����һ�����֣��������¹�������ַ�����0 ����ɡ�a����1 ����ɡ�b��... 25 ����ɡ�z����һ�������ж��ַ�����ܣ�
 ���� 12258 һ���� 5 �֣��ֱ��� bccfi��bwfi��bczi��mcfi��mzi��ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 * */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumDecodings nd=new NumDecodings();
        String test="12258";
        System.out.println(nd.numDecodings(test));
    }
}
