/**
 ��������˳��ʹ����λ��ż��ǰ�棨���飩

 ��Ŀ����
 ��Ҫ��֤������������ż����ż��֮������λ�ò���

 ����˼·
 ���鿽�����ȼ�¼�����ĸ�����Ϊ�±꣩
 ���ñ���Ҳ�ǻ����������ͣ��ڽ��з�������ʱ������ñ������и��ơ�
 */
public class ReOrderArray {
    public void reOrderArray(int[] nums) {
        // ��¼��������
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        //�����������ڱ���
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


/**
 * �����������ʾ������ģ��������뽨һ��copy�����飬�����copy�����ϵ�����Ԫ��˳���������һ��nums=copy��������copy��ֵ��nums�������
 * nums��������main�����е�nums��nums������ñ����ڷ������õ�ʱ������һ�ݣ����Ըķ����е����ñ�������Ч��(����������)
 * */
//        int cnt=0;
//        for(int val:nums){
//            if(val%2==1){
//                cnt++;
//            }
//        }
//        int[] copy=new int[nums.length];
//        int i=0;
//        int j=cnt;
//        for(int val:nums){
//            if(val%2==1){
//                copy[i++]=val;
//            }else{
//                copy[j++]=val;
//            }
//        }
        //����������ʾnums������ñ�������ֵ������û�б��õ�
//        nums=Arrays.copyOf(copy,copy.length);
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
