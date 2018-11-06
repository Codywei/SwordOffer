/**
 ����ת�ַ���

 ��Ŀ����
 Input:
 S="abcXYZdef"
 K=3
 Output:
 "XYZdefabc"

 ����˼·
 �Ƚ� "abc" �� "XYZdef" �ֱ�ת���õ� "cbafedZYX"��Ȼ���ٰ������ַ�����ת�õ� "XYZdefabc"��
 * */
public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (n >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void main(String[] args) {
        LeftRotateString lr=new LeftRotateString();
        String str="abcXYZdef";
        System.out.println(lr.LeftRotateString(str,3));
    }
}
