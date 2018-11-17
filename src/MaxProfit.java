/**
 股票的最大利润（贪心）

 题目描述
 可以有一次买入和一次卖出，那么买入必须在前。求最大收益。

 解题思路
 使用贪心策略，假设第 i 轮进行卖出操作，买入操作价格应该在 i 之前并且价格最低。
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
