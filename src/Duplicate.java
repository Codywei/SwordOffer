/**
 �������ظ�������

 ��Ŀ����
 ��һ������Ϊ n ����������������ֶ��� 0 �� n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м����������ظ��ģ�Ҳ��֪��ÿ�������ظ����Ρ�
 ���ҳ�����������һ���ظ������֡�

 ����˼·
 ��������Ԫ���� [0, n-1] ��Χ�ڵ�����(ע�ⷶΧ�������÷�Χ�޷��ڵ�ǰ��������ɽ���)�����Խ�ֵΪ i ��Ԫ�ص������� i ��λ���ϡ�
 ��Ҫ��������һ���滻����
 * */
public class Duplicate {
    public boolean dupplicate(int []nums,int length ,int []duplication) {
        if (nums == null || length <= 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            //��iλ�õ�ֵ����iʱ�Ͳ��Ͻ���(ʹ��while)
            while(nums[i]!=i){
                //��ǰλ�ϵ�ֵ��nums[i]λ��ֵ�ظ�
                if(nums[i]==nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }
                //�ѵ�ǰiλ���ϵ�ֵ������nums[i]λ��
                swap(nums,nums[i],i);
            }
        }
        return true;
    }

    private void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

    }

    public static void main(String[] args) {
        int []num={2,3,1,0,2,5};
        int []dup=new int[1];
        Duplicate du=new Duplicate();
        System.out.println(du.dupplicate(num,6,dup));
        System.out.println(dup[0]);

    }
}
