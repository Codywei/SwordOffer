import java.util.Arrays;

/**
 ��̬��̨�ף���̬�滮��

 ��Ŀ����
 һֻ����һ�ο������� 1 ��̨�ף�Ҳ�������� 2 ��... ��Ҳ�������� n ���������������һ�� n ����̨���ܹ��ж�����������

 ����˼·
 ����̨����Ҫ�ഢ��һ�������¼ǰ������������������������
 * */
public class JumpFloorII {
    public int JumpFloorII(int target) {
      int[] dp = new int[target];
      Arrays.fill(dp,1);
      for(int i=1;i<target;i++){
          for(int j=0;j<i;j++){
              dp[i]+=dp[j];
          }
      }
      return dp[target-1];
}

    public static void main(String[] args) {
        JumpFloorII jptwo=new JumpFloorII();
        System.out.println(jptwo.JumpFloorII(4));
    }
}
