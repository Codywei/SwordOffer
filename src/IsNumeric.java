/**
 ��ʾ��ֵ���ַ���

 ��Ŀ����
 true
 "+100"
 false
 "12e"

 ����˼·
 ʹ��������ʽ����ƥ�䡣

 []  �� �ַ�����
 ()  �� ����
 ?   �� �ظ� 0 ~ 1
 +   �� �ظ� 1 ~ n
 *   �� �ظ� 0 ~ n
 .   �� �����ַ�
 \\. �� ת���� .
 \\d �� ����

 * */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        IsNumeric in=new IsNumeric();
        String str="+1000";
        System.out.println(in.isNumeric(str.toCharArray()));
    }
}
