/**
 ������ֻ����һ�ε�����

 ��Ŀ����
 һ�����������������������֮�⣬���������ֶ����������Σ��ҳ�����������

 ����˼·
 ��������ȵ�Ԫ����λ����ʾ�ϱض�����һλ���ڲ�ͬ�������������Ԫ�����õ��Ľ��Ϊ�������ظ�������Ԫ�����Ľ����
 diff &= -diff �õ��� diff ���Ҳ಻Ϊ 0 ��λ��Ҳ���ǲ������ظ�������Ԫ����λ����ʾ�����Ҳ಻ͬ����һλ��������һλ�Ϳ��Խ�����Ԫ�����ֿ�����
 * */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        //diff &= -diff �õ��� diff ���Ҳ಻Ϊ 0 ��λ
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0) {
                //��ͬԪ�����������
                num1[0] ^= num;
            }
            else {
                num2[0] ^= num;
            }
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce fn=new FindNumsAppearOnce();
        int[] nums={1,2,3,4,2,1,3,5};
        int[] num1=new int[1];
        int[] num2=new int[1];

        fn.FindNumsAppearOnce(nums,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
