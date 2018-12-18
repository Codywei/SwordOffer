/**
 ��ʾ��ֵ���ַ������ַ�����������ʽ��

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


/*
���¶�������н���:
[\\+\\-]?            -> ���򸺷��ų������
\\d*                 -> ���������Ƿ���֣���-.34 �� +3.34������
(\\.\\d+)?           -> �������С���㣬��ôС���������������֣�
                    ����һ�𲻳���
([eE][\\+\\-]?\\d+)? -> �������ָ�����֣���ôe��E�϶����֣�+��-���Բ����֣�
                    �����ű�����������������������ֶ�������
*/
        //return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }


    public boolean isNumeric2(char[] str) {

        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                // e����һ��Ҫ������
                if (i == str.length-1) {
                    return false;
                }
                // ����ͬʱ��������e
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // �ڶ��γ���+-���ţ�����������e֮��
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                // ��һ�γ���+-���ţ��Ҳ������ַ�����ͷ����Ҳ���������e֮��
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e���治�ܽ�С���㣬С���㲻�ܳ�������
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                // ���Ϸ��ַ�
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsNumeric in=new IsNumeric();
        String str="+.80e+21";
        System.out.println(in.isNumeric2(str.toCharArray()));
    }
}
