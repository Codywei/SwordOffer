/**
 矩形覆盖

 题目描述
 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？

 解题思路
 和跳台阶思路一样
 * */
public class RectCover {
    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        RectCover rc =new RectCover();
        System.out.println(rc.RectCover(6));
    }
}
