import java.util.Arrays;
/**
 

 题目描述
 五张牌，其中大小鬼为癞子，牌面大小为 0。判断这五张牌是否能组成顺子。

 解题思路
 先对数组排序，统计癞子数量，再看能否补齐。（这里直接按从小到大顺序考虑，没有考虑1和2的情况）
 * */
public class IsContinuous {
    public boolean isContinuous(int[] nums) {
        if(nums.length<5){
            return false;
        }
        int cnt=0;
        Arrays.sort(nums);
        for(int num:nums){
            if(num==0){
                cnt++;
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
           if(nums[i+1]==nums[i]){
               return false;
           }
           cnt-=nums[i+1]-nums[i]-1;
        }
        return cnt>=0;
    }

    public static void main(String[] args) {
        IsContinuous ic =new IsContinuous();
        int[] nums={0,0,1,3,5};
        System.out.println(ic.isContinuous(nums));
    }
}
