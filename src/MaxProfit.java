/**
 ��Ʊ���������̰�ģ�

 ��Ŀ����
 ������һ�������һ����������ô���������ǰ����������档

 ����˼·
 ʹ��̰�Ĳ��ԣ������ i �ֽ���������������������۸�Ӧ���� i ֮ǰ���Ҽ۸���͡�
 * */
public class MaxProfit {
    public int maxProfit(int[] prices) {

        if(prices==null||prices.length==0){
            return 0;
        }
        int soFarmin=prices[0];
        int MaxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            soFarmin=Math.min(soFarmin,prices[i]);
            MaxProfit=Math.max(MaxProfit,prices[i]-soFarmin);
        }
        return MaxProfit;
    }

    public static void main(String[] args) {
        MaxProfit mp=new MaxProfit();
        int[] nums={1,2,4,5,6,6,7,4,3,4};
        System.out.println(mp.maxProfit(nums));
    }
}
