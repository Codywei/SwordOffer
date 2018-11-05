import java.util.BitSet;
/**
 ��һ��ֻ����һ�ε��ַ�λ��

 ��Ŀ����
 ��һ���ַ������ҵ���һ��ֻ����һ�ε��ַ�������������λ�á�

 ����˼·
 ��ֱ�۵Ľⷨ��ʹ�� HashMap �Գ��ִ�������ͳ�ƣ����ǿ��ǵ�Ҫͳ�Ƶ��ַ���Χ���ޣ���˿���ʹ������������� HashMap��
 ����ʵ�ֵĿռ临�ӶȻ��������ŵġ����ǵ�ֻ��Ҫ�ҵ�ֻ����һ�ε��ַ�����ô��Ҫͳ�ƵĴ�����Ϣֻ�� 0,1,����ʹ����������λ���ܴ洢��Щ��Ϣ��
 * */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                // 0 0 -> 0 1
                bs1.set(c);
            }
            else if (bs1.get(c) && !bs2.get(c)) {
                // 0 1 -> 1 1
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar fa=new FirstNotRepeatingChar();
        String str="adfawaf";
        System.out.println(fa.FirstNotRepeatingChar(str));
        System.out.println(fa.FirstNotRepeatingChar2(str));
    }
}
