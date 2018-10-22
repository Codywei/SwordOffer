/**
 ��ת�������С����

 ��Ŀ����
 ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת������һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 �������� {3, 4, 5, 1, 2} Ϊ {1, 2, 3, 4, 5} ��һ����ת�����������СֵΪ 1��

 ����˼·
 ��һ�����������в���һ��Ԫ�ؿ����ö��ֲ��ң����ֲ���Ҳ��Ϊ�۰���ң�ÿ�ζ��ܽ�����������룬�����۰����Ե��㷨ʱ�临�Ӷȶ�Ϊ O(logN)��

 ��������޸Ķ��ֲ����㷨������⣺

 �� nums[m] <= nums[h] ������£�˵������ [l, m] ֮�䣬��ʱ�� h = m��
 ������� [m + 1, h] ֮�䣬�� l = m + 1��

 �������Ԫ�������ظ��Ļ�����ô�ͻ����һ������������nums[l] == nums[m] == nums[h]����ô��ʱ�޷�ȷ�������ĸ����䣬��Ҫ�л���˳����ҡ�
 ����������� {1,1,1,0,1}��l��m �� h ָ�������Ϊ 1����ʱ�޷�֪����С���� 0 ���ĸ����䡣
 * */
public class RotateArray {
    public int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, l, h);
            }
            else if (nums[m] <= nums[h]) {
                h = m;
            }
            else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    private int minNumber(int[] nums, int l, int h){
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
            return nums[l];

    }

    public static void main(String[] args) {
        int[] dp={3,4,5,1,2};
        RotateArray ra=new RotateArray();
        System.out.println(ra.minNumberInRotateArray(dp));
    }



}
