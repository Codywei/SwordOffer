/**
 ��������˳��ʹ����λ��ż��ǰ��

 ��Ŀ����
 ��Ҫ��֤������������ż����ż��֮������λ�ò���

 ����˼·
 ���鿽�����ȼ�¼�����ĸ�����Ϊ�±꣩
 */
public class ReOrderArray {
    public void reOrderArray(int[] nums) {
        // ��������
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
