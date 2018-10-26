/**
 调整数组顺序使奇数位于偶数前面

 题目描述
 需要保证奇数和奇数，偶数和偶数之间的相对位置不变

 解题思路
 数组拷贝（先记录奇数的个数作为下标）
 */
public class ReOrderArray {
    public void reOrderArray(int[] nums) {
        // 奇数个数
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            }
            else {
                nums[j++] = num;
            }
        }
    }

    public static void main(String[] args) {
        ReOrderArray ro=new ReOrderArray();
        int[] nums={1,2,3,4,5,6,7};
        ro.reOrderArray(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
