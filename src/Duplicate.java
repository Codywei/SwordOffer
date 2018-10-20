/**
 数组中重复的数字

 题目描述
 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。

 解题思路
 这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上。
 * */
public class Duplicate {
    public boolean dupplicate(int []nums,int length ,int []duplication){
        if(nums==null||length<=0){
            return false;
        }
        for(int i = 0 ; i < length;i++){
            if(nums[i] < 0 || nums[i]>length - 1){
                return false;
            }
        }
        for(int i=0;i<length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    duplication[0]=nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    private void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

    }

    public static void main(String[] args) {
        int []num={2,3,1,0,2,5};
        int []dup=new int[6];
        Duplicate du=new Duplicate();
        System.out.println(du.dupplicate(num,6,dup));

    }
}
