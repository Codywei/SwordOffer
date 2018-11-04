/**
���������������

 ��Ŀ����
 {6, -3, -2, 7, -15, 1, 2, 2}�����������������Ϊ 8���ӵ� 0 ����ʼ������ 3 ��Ϊֹ����
 * */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray fgss=new FindGreatestSumOfSubArray();
        int[] nums={6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(fgss.FindGreatestSumOfSubArray(nums));
    }
}
