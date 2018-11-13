/**
 ��ת����˳����

 ��Ŀ����
 Input:
 "I am a student."
 Output:
 "student. a am I"

 ����˼·
 ��ĿӦ����һ���������������ǲ����ö���Ŀռ䡣��Ȼ Java ����Ŀ�������Ϊ String ���ͣ���Ҫ�ȴ���һ���ַ�����ʹ�ÿռ临�Ӷ�Ϊ O(N)��������ȷ�Ĳ�������Ӧ�ú�ԭ��һ����Ϊ�ַ����飬����ֻ��ʹ�ø��ַ�����Ŀռ䡣
 �κ�ʹ���˶���ռ�Ľⷨ������ʱ�������ۿۣ������ݹ�ⷨ��
 ��ȷ�ĽⷨӦ���Ǻ�����һ��������תÿ�����ʣ�����ת�����ַ�����
 * */
public class ReverseSentence {
    public String ReverseSentence(String str) {

        int n=str.length();
        char[] chars=str.toCharArray();
        int i=0;
        int j=0;
        while(j<=n){
            if(j==n||chars[j]==' '){
                reverse(chars,i,j-1);
                i=j+1;
            }
            j++;
        }
        reverse(chars,0,n-1);
        return  new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
//        while (i < j) {
//            swap(c, i++, j--);
//        }
        while(i<j){
            swap(c,i++,j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        String str="I am a student.";
        ReverseSentence rs=new ReverseSentence();
        System.out.println(rs.ReverseSentence(str));
    }
}
