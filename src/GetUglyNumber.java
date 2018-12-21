/**
 ��������̬�滮��

 ��Ŀ����
 ��ֻ�������� 2��3 �� 5 ��������������Ugly Number�������� 6��8 ���ǳ������� 14 ���ǣ���Ϊ���������� 7��ϰ�������ǰ� 1 �����ǵ�һ���������󰴴�С�����˳��ĵ� N ��������
 * */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int N) {

        if(N<=6){
            return N;
        }
        int[] dp=new int[N];
        dp[0]=1;
        int i2=0,i3=0,i5=0;
        for (int i = 1; i < dp.length; i++) {
            //ÿ�ζ���2��3��5�����ǻ�δ��Ϲ�����СԪ����ϣ��õ���ǰ��ϵ���СԪ�ء�
            int next2=dp[i2]*2,next3=dp[i3]*3,next5=dp[i5]*5;
            dp[i]=Math.min(next2,Math.min(next3,next5));
            if(dp[i]==next2){
                i2++;
            }
            if(dp[i]==next3){
                i3++;
            }
            if(dp[i]==next5){
                i5++;
            }

        }
        return dp[N-1];

    }

    public static void main(String[] args) {
        GetUglyNumber gu=new GetUglyNumber();
        System.out.println(gu.GetUglyNumber_Solution(8));
    }

}
