import java.util.Arrays;
/**
 

 ��Ŀ����
 �����ƣ����д�С��Ϊ��ӣ������СΪ 0���ж����������Ƿ������˳�ӡ�

 ����˼·
 �ȶ���������ͳ������������ٿ��ܷ��롣������ֱ�Ӱ���С����˳���ǣ�û�п���1��2�������
 * */
public class IsContinuous {
    public boolean isContinuous(int[] nums) {
        if(nums.length<5){
            return false;
        }
        int cnt=0;
        Arrays.sort(nums);
        for(int num:nums){
            if(num==0){
                cnt++;
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
           if(nums[i+1]==nums[i]){
               return false;
           }
           cnt-=nums[i+1]-nums[i]-1;
        }
        return cnt>=0;
    }

    public static void main(String[] args) {
        IsContinuous ic =new IsContinuous();
        int[] nums={0,0,1,3,5};
        System.out.println(ic.isContinuous(nums));
    }
}
