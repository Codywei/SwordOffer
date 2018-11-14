import java.util.Arrays;

/**
 变态跳台阶（动态规划）

 题目描述
 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 解题思路
 比跳台阶需要多储存一个数组记录前几跳的种数，而不是两个数
 * */
public class JumpFloorII {
    public int JumpFloorII(int target) {
      int[] dp = new int[target];
      Arrays.fill(dp,1);
      for(int i=1;i<target;i++){
          for(int j=0;j<i;j++){
              dp[i]+=dp[j];
          }
      }
      return dp[target-1];
}

    public static void main(String[] args) {
        JumpFloorII jptwo=new JumpFloorII();
        System.out.println(jptwo.JumpFloorII(4));
    }
}
