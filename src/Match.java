/**
 ������ʽƥ�䣨������ʽ��

 ��Ŀ����
 ��ʵ��һ����������ƥ����� '.' �� '*' ��������ʽ��ģʽ�е��ַ� '.' ��ʾ����һ���ַ����� '*' ��ʾ��ǰ����ַ����Գ�������Σ����� 0 �Σ���

 �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ��� "aaa" ��ģʽ "a.a" �� "ab*ac*a" ƥ�䣬������ "aa.a" �� "ab*a" ����ƥ�䡣

 ����˼·������ ţ���� ��������Ľ�𣬼���׶����ޣ�
 ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
 1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
 2����� �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��

 ����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
 ����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
 1��ģʽ����2�ַ����൱��x*�����ԣ�
 2���ַ�������1�ַ���ģʽ����2�ַ���
 3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ
*/

public class Match {

        public boolean match(char[] str, char[] pattern) {
            if (str == null || pattern == null) {
                return false;
            }
            int strIndex = 0;
            int patternIndex = 0;
            return matchCore(str, strIndex, pattern, patternIndex);
        }

        public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
            //��Ч�Լ��飺str��β��pattern��β��ƥ��ɹ�
            if (strIndex == str.length && patternIndex == pattern.length) {
                return true;
            }
            //pattern�ȵ�β��ƥ��ʧ��
            if (strIndex != str.length && patternIndex == pattern.length) {
                return false;
            }
            //ģʽ��2����*�����ַ�����1����ģʽ��1��ƥ��,��3��ƥ��ģʽ���粻ƥ�䣬ģʽ����2λ
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
                if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                    return matchCore(str, strIndex, pattern, patternIndex + 2)//ģʽ����2����Ϊx*ƥ��0���ַ�
                            || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//��Ϊģʽƥ��1���ַ�
                            || matchCore(str, strIndex + 1, pattern, patternIndex);//*ƥ��1������ƥ��str�е���һ��
                } else {
                    return matchCore(str, strIndex, pattern, patternIndex + 2);
                }
            }
            //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }
            return false;
        }


    public static void main(String[] args) {
        Match mat=new Match();
        char []str={'a','a','a'};
        char []pattern={'a','.','a','*'};
        char []pattern2={'a','b','*','a','c','a'};
        System.out.println(mat.match(str,pattern));
        System.out.println(mat.match(str,pattern2));

    }
}
