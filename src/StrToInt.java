/**
 ���ַ���ת��������

 ��Ŀ����
 ��һ���ַ���ת����һ���������ַ�������һ���Ϸ�����ֵ�򷵻� 0��Ҫ����ʹ���ַ���ת�������Ŀ⺯����

 Iuput:
 +2147483647
 1a33
 Output:
 2147483647
 0
 * */
public class StrToInt {
    public int StrToInt(String str) {

        if(str==null||str.length()==0){
            return 0;
        }
        boolean isNegative=str.charAt(0)=='-';
        int ret=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(i==0&&(c=='+'||c=='-')){
                continue;
            }
            if(c<'0'||c>'9'){
                return 0;
            }
            ret=ret*10+(c-'0');
        }
        return isNegative? -ret:ret;
    }

    public static void main(String[] args) {
        StrToInt sti=new StrToInt();
        String str="12324";
        System.out.println(sti.StrToInt(str));
    }
}
