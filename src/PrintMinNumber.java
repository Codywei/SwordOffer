import java.util.Arrays;

/**
 �������ų���С���������飬�ַ�������

 ��Ŀ����
 ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ���������������� {3��32��321}�����ӡ���������������ųɵ���С����Ϊ 321323��

 ����˼·
 ���Կ�����һ���������⣬�ڱȽ������ַ��� S1 �� S2 �Ĵ�Сʱ��Ӧ�ñȽϵ��� S1+S2 �� S2+S1 �Ĵ�С����� S1+S2 < S2+S1����ôӦ�ð� S1 ����ǰ�棬����Ӧ�ð� S2 ����ǰ�档
 * */
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String ret = "";
        for (String str : nums) {
            ret += str;
        }
        return ret;

    }

    public static void main(String[] args) {
        PrintMinNumber pm=new PrintMinNumber();
        int[] nums={3,3,2,321,22};
        System.out.println(pm.PrintMinNumber(nums));
    }
}
