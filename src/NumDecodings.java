/**
 把数字翻译成字符串（字符串，动态规划）

 题目描述
 给定一个数字，按照如下规则翻译成字符串：0 翻译成“a”，1 翻译成“b”... 25 翻译成“z”。一个数字有多种翻译可能，
 例如 12258 一共有 5 种，分别是 bccfi，bwfi，bczi，mcfi，mzi。实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 自下而上，动态规划，从最小的问题开始 ：
 f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=1,f(n-1)=1,求f(0)。
 递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
 其中，如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。
 因此，对于12258：
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
