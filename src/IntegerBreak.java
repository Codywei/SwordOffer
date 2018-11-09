/**
 剪绳子

 题目描述
 把一根绳子剪成多段，并且使得每段的长度乘积最大。

 解题思路
 1.贪心
 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1 的绳子重新组合，把它们切成两段长度为 2 的绳子。
 证明：当 n >= 5 时，3(n - 3) - 2(n - 2) = n - 5 >= 0。因此把长度大于 5 的绳子切成两段，令其中一段长度为 3 可以使得两段的乘积最大。

 2.动态规划
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
        System.out.println(dp[2]);
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++) {
                //dp[i]或j*(i-j)或dp[j]*[i-j]
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));

            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak ib=new IntegerBreak();
        System.out.println(ib.integerBreak(7));
        System.out.println(ib.integerBreak2(7));
    }

}
