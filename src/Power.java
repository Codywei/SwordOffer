/**
 数值的整数次方

 题目描述
 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。

 解题思路
 下面的讨论中 x 代表 base，n 代表 exponent。
 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
 * */
public class Power {
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = power(base * base, exponent / 2);
        //幂为奇数，在最后的结果上乘个base
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;
    }

    public static void main(String[] args) {
        Power power=new Power();
        System.out.println(power.power(3.0,6));

    }
}
