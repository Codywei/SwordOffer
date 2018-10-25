/**������ʽƥ��(��̫��)

 ��Ŀ����
 ��ʵ��һ����������ƥ����� '.' �� '*' ��������ʽ��ģʽ�е��ַ� '.' ��ʾ����һ���ַ����� '*' ��ʾ��ǰ����ַ����Գ�������Σ����� 0 �Σ���

 �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ��� "aaa" ��ģʽ "a.a" �� "ab*ac*a" ƥ�䣬������ "aa.a" �� "ab*a" ����ƥ�䡣

 ����˼·
 Ӧ��ע�⵽��'.' ����������һ�������ַ����� '*' �������ظ�ǰ����ַ��������������ò�ͬ�����ܰ� '.' �����ú� '*' ������ȣ��Ӷ����������ظ�ǰ���ַ�һ�Ρ�
*/

public class Match {
    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        // a* counts as single a
                        dp[i][j] |= dp[i][j - 1];
                        // a* counts as multiple a
                        dp[i][j] |= dp[i - 1][j];
                        // a* counts as empty
                        dp[i][j] |= dp[i][j - 2];
                    } else {
                        // a* only counts as empty
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Match mat=new Match();
        char []str={'a','a','a'};
        char []pattern={'a','.','a'};
        char []pattern2={'a','b','*','a','c','a'};
        System.out.println(mat.match(str,pattern));
        System.out.println(mat.match(str,pattern2));

    }
}
