/**
 ���������ֵ����̬�滮��
 ��һ�� m*n �����̵�ÿһ���񶼷���һ�����ÿ�����ﶼ��һ����ֵ������ 0���������Ͻǿ�ʼ�����ÿ�����һ������ƶ�һ��ֱ�����½ǽ���������һ�����̣����õ����������ֵ�����磬������������

 1    10   3    8
 12   2    9    6
 5    7    4    11
 3    7    16   5
 ����˼·
 Ӧ���ö�̬�滮��⣬���������������������������������ڸ��ӣ��������Ž⡣
 * */
public class GetMost {
    public int getMost(int[][] values) {
        if(values==null||values.length==0||values[0].length==0){
            return 0;
        }
        int n=values[0].length;
        int[] dp=new int[n];
        for(int[] value : values){
            dp[0]+=value[0];
            for (int i = 1; i < n; i++) {
               dp[i]=Math.max(dp[i],dp[i-1])+value[i];

            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[][] nums={{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        GetMost gm=new GetMost();
        System.out.println(gm.getMost(nums));
    }
}
