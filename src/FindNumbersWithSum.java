import java.util.ArrayList;
import java.util.Arrays;
/**
 ��Ϊ S ���������֣�����,˫ָ�룩

 ��Ŀ����
 ����һ����������������һ������ S���������в�����������ʹ�����ǵĺ������� S������ж�����ֵĺ͵��� S������������ĳ˻���С�ġ�

 ����˼·
 ʹ��˫ָ�룬һ��ָ��ָ��Ԫ�ؽ�С��ֵ��һ��ָ��ָ��Ԫ�ؽϴ��ֵ��ָ���СԪ�ص�ָ���ͷ��β������ָ��ϴ�Ԫ�ص�ָ���β��ͷ������
 �������ָ��ָ��Ԫ�صĺ� sum == target����ô�õ�Ҫ��Ľ����
 ��� sum > target���ƶ��ϴ��Ԫ�أ�ʹ sum ��СһЩ��
 ��� sum < target���ƶ���С��Ԫ�أ�ʹ sum ���һЩ��
 * */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i=0;
        int j=array.length-1;
        while(i<j){
            int cur=array[i]+array[j];
            if(cur==sum){
                return new ArrayList<Integer>(Arrays.asList(array[i],array[j]));
            }
            else if(cur<sum){
                i++;
            }
            else{
                j--;
            }
        }
         return new ArrayList<>();
    }


    public static void main(String[] args) {
        FindNumbersWithSum fn=new FindNumbersWithSum();
        int[] nums={1,2,3,4,5,6,9};
        ArrayList<Integer> list=new ArrayList<>();
        list=fn.FindNumbersWithSum(nums,8);
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
