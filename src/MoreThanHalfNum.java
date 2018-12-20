/**
�����г��ִ�������һ������֣����飩

 ����˼·
 ����ͶƱ���⣬�������� Boyer-Moore Majority Vote Algorithm �����������⣬ʹ��ʱ�临�Ӷ�Ϊ O(N)��

 ʹ�� cnt ��ͳ��һ��Ԫ�س��ֵĴ���������������Ԫ�غ�ͳ��Ԫ�����ʱ���� cnt++�������� cnt--�����ǰ������� i ��Ԫ�أ��� cnt == 0��˵��ǰ i ��Ԫ��û�� majority��
 ������ majority�����ǳ��ֵĴ������� i / 2 ����Ϊ������� i / 2 �Ļ� cnt ��һ������Ϊ 0 ����ʱʣ�µ� n - i ��Ԫ���У�majority ����Ŀ��Ȼ���� (n - i) / 2����˼������Ҿ����ҳ� majority��
 * */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        //��ͷ������֤majority����
        for (int val : nums) {
            if (val == majority) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? majority : 0;
    }

    public static void main(String[] args) {
        MoreThanHalfNum mh =new MoreThanHalfNum();
        int[] nums={0,1,4,5,1,2,1,1,1,1};
        System.out.println(mh.MoreThanHalfNum_Solution(nums));
    }
}
