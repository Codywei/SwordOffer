/**
 斐波那契数列（动态规划）

 题目描述
 求斐波那契数列的第 n 项，n <= 39。

 解题思路
 如果使用递归求解，会重复计算一些子问题。例如，计算 f(10) 需要计算 f(9) 和 f(8)，计算 f(9) 需要计算 f(8) 和 f(7)，可以看到 f(8) 被重复计算了。
 递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。

 * */
public class Fibonacci {
        private int[] fib = new int[40];

        public Fibonacci() {
            fib[1] = 1;
            fib[2] = 2;
            for (int i = 2; i < fib.length; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }

        public int fibonacci(int n) {
            return fib[n];
        }

    public static void main(String[] args) {
        Fibonacci fb=new Fibonacci();
        System.out.println(fb.fibonacci(0));
    }

}
