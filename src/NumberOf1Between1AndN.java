/**
 从 1 到 n 整数中 1 出现的次数（秀智商）
 * */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for(int m=1;m<=n;m*=10){
            int a=n/m; int b=n%m;
            //加8是为了区分前几位“0-1”和“2-10”的情况，循环的当前位为1时，再加b+1
            cnt+=(a+8)/10*m+(a%10==1?b+1:0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Between1AndN ns=new NumberOf1Between1AndN();
        System.out.println(ns.NumberOf1Between1AndN_Solution(20));
    }
}
