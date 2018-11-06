/**
 ��Ʊ���������

 ��Ŀ����
 ������һ�������һ����������ô���������ǰ����������档

 ����˼·
 ʹ��̰�Ĳ��ԣ������ i �ֽ���������������������۸�Ӧ���� i ֮ǰ���Ҽ۸���͡�
 * */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit mp=new MaxProfit();
        int[] nums={1,2,4,5,6,6,7,4,3,4};
        System.out.println(mp.maxProfit(nums));
    }
}
