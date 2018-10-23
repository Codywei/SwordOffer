/**
 二进制中 1 的个数

 题目描述
 输入一个整数，输出该数二进制表示中 1 的个数。

 解题思路
 n&(n-1)
 该位运算去除 n 的位级表示中最低的那一位。时间复杂度：O(M)，其中 M 表示 1 的个数。

 或者直接调用函数API
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
