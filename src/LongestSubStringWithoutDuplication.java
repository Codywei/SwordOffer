import java.util.Arrays;
/**
 ������ظ��ַ������ַ���

 ��Ŀ����
 ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ������ַ�����ֻ�����ӡ�a������z�����ַ������磬���ַ����С�arabcacfr��������ظ����ַ���Ϊ��acfr��������Ϊ4��

����˼·
 ʹ�ö�̬�滮����¼��ǰ�ַ�֮ǰ������ظ����ַ�������f(i-1)������iΪ��ǰ�ַ���λ�á�ÿ�α�����ǰ�ַ�ʱ�������������
 1������ǰ�ַ���һ�γ��֣�������ظ����ַ�������f(i) = f(i-1)+1��
 2������ǰ�ַ����ǵ�һ�γ��֣������ȼ��㵱ǰ�ַ������ϴγ���λ��֮��ľ���d����d����f(i-1)����˵��ǰһ�����ظ����ַ�����û�а�����ǰ�ַ����������ӵ�ǰ�ַ���ǰһ�����ظ����ַ����У�
 ���ԣ�f(i) = f(i-1)+1����dС�ڻ����f(i-1)����˵��ǰһ�����ظ����ַ������Ѿ�������ǰ�ַ����򲻿�����ӵ�ǰ�ַ������ԣ�f(i) = d��

 * */
public class LongestSubStringWithoutDuplication {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        //��ʼ��Ϊ-1��������ʾû���ֹ�
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            //��ǰ�ַ���һ�γ��֣�����ǰһ�����ظ����ַ�����û�а�����ǰ�ַ�
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                //��������ظ����ַ����ĳ���
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            //�����ַ����ֵ�λ��
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;

    }

    public static void main(String[] args) {
        LongestSubStringWithoutDuplication ls=new LongestSubStringWithoutDuplication();
        System.out.println(ls.longestSubStringWithoutDuplication("arabcacfr"));
    }
}
