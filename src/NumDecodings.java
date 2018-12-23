/**
 �����ַ�����ַ������ַ�������̬�滮��

 ��Ŀ����
 ����һ�����֣��������¹�������ַ�����0 ����ɡ�a����1 ����ɡ�b��... 25 ����ɡ�z����һ�������ж��ַ�����ܣ�
 ���� 12258 һ���� 5 �֣��ֱ��� bccfi��bwfi��bczi��mcfi��mzi��ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����

 ���¶��ϣ���̬�滮������С�����⿪ʼ ��
 f(r)��ʾ��rΪ��ʼ��r��Сȡ0�������Ҷ�����ɵ������ܹ�������ַ��������������ڳ���Ϊn�����֣�f(n)=1,f(n-1)=1,��f(0)��
 ���ƹ�ʽΪ f(r-2) = f(r-1)+g(r-2,r-1)*f(r)��
 ���У����r-2��r-1�ܹ�������ַ�����g(r-2,r-1)=1������Ϊ0��
 ��ˣ�����12258��
 f(5) = 1
 f(4) = 1
 f(3) = f(4)+1 = 1
 f(2) = f(3)+f(4) = 2
 f(1) = f(2)+f(3) = 3
 f(0) = f(1)+f(2) = 5
 * */
public class NumDecodings {
    public  int getTranslationCount(int number){
        if(number<0) {
            return 0;
        }
        return getTranslationCount(Integer.toString(number));
    }
    public int getTranslationCount(String number) {

        int f1=1,f2=1,g=0;
        int temp=0;
        for (int i = number.length()-2; i >=0; i--) {
             if(Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))>26){
                 g=0;
             }
             else{
                 g=1;
             }
             temp=f2;
             f2=f2+g*f1;
             f1=temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        NumDecodings nd=new NumDecodings();
        int test=12258;
        System.out.println(nd.getTranslationCount(test));
    }
}
