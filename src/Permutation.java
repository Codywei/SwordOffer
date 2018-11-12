import java.util.ArrayList;
import java.util.Arrays;
/**
 �ַ���������

 ��Ŀ����
 ����һ���ַ��������ֵ����ӡ�����ַ������ַ����������С����������ַ��� abc�����ӡ�����ַ� a, b, c �������г����������ַ��� abc, acb, bac, bca, cab �� cba��
 * */
public class Permutation {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // ��֤���ظ�(�硰abbc���еġ�b��)
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ret=new ArrayList<>();
        String str="abbc";
        Permutation permutation=new Permutation();
        ret=permutation.Permutation(str);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));

        }

    }
}
