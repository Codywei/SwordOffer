/**
 쳲��������У���̬�滮��

 ��Ŀ����
 ��쳲��������еĵ� n �n <= 39��

 ����˼·
 ���ʹ�õݹ���⣬���ظ�����һЩ�����⡣���磬���� f(10) ��Ҫ���� f(9) �� f(8)������ f(9) ��Ҫ���� f(8) �� f(7)�����Կ��� f(8) ���ظ������ˡ�
 �ݹ��ǽ�һ�����⻮�ֳɶ����������⣬��̬�滮Ҳ����ˣ����Ƕ�̬�滮���������Ľ⻺���������Ӷ������ظ���������⡣

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
