/**
 不用加减乘除做加法（位运算）

 题目描述
 写一个函数，求两个整数之和，要求不得使用 +、-、*、/ 四则运算符号。

 解题思路
 a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
 递归会终止的原因是 (a & b) << 1 最右边会多一个 0，那么继续递归，进位最右边的 0 会慢慢增多，最后进位会变为 0，递归终止。
 * */
public class AddSolution {
    public int Add(int a, int b) {

        return b==0?a:Add(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        AddSolution as=new AddSolution();
        System.out.println(as.Add(6,7));
    }
}
