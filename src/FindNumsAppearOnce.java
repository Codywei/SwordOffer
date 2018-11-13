/**
 数组中只出现一次的数字

 题目描述
 一个整型数组里除了两个数字之外，其他的数字都出现了两次，找出这两个数。

 解题思路
 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
 diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
 * */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //diff &= -diff 得到出 diff 最右侧不为 0 的位
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                //相同元素在异或后抵消
                num1[0] ^= num;
            }
            else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce fn=new FindNumsAppearOnce();
        int[] nums={1,2,3,4,2,1,3,5};
        int[] num1=new int[1];
        int[] num2=new int[1];

        fn.FindNumsAppearOnce(nums,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
