/**
 �������ظ�������

 ��Ŀ����
 ��һ������Ϊ n ����������������ֶ��� 0 �� n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м����������ظ��ģ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�

 ����˼·
 ��������Ԫ���� [0, n-1] ��Χ�ڵ����⣬���Խ�ֵΪ i ��Ԫ�ص������� i ��λ���ϡ�
 * */
public class Duplicate {
    public boolean dupplicate(int []nums,int length ,int []duplication){
        if(nums==null||length<=0){
            return false;
        }
        for(int i = 0 ; i < length;i++){
            if(nums[i] < 0 || nums[i]>length - 1){
                return false;
            }
        }
        for(int i=0;i<length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    private void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

    }

    public static void main(String[] args) {
        int []num={2,3,1,0,2,5};
        int []dup=new int[6];
        Duplicate du=new Duplicate();
        System.out.println(du.dupplicate(num,6,dup));

    }
}
