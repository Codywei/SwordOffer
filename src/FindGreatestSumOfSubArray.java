/**
连续子数组的最大和（动态规划）

 题目描述
 {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 * */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int greatnum=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            //如果之前的sum为0，则直接从当前位开始重新计算
            sum=sum<=0?nums[i]:sum+nums[i];
            greatnum=Math.max(greatnum,sum);

        }
        return greatnum;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray fgss=new FindGreatestSumOfSubArray();
        int[] nums={6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(fgss.FindGreatestSumOfSubArray(nums));
    }
}
