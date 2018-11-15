/**
 打印从 1 到最大的 n 位数（回溯）
 题目描述
 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。

 解题思路
 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 使用回溯法得到所有的数。
 */

public class Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            //递归得到下一位的数
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        //如果当前位上的数是0则不输出
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits pd=new Print1ToMaxOfNDigits();
        pd.print1ToMaxOfNDigits(2);
    }
}
