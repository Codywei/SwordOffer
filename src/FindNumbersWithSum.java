import java.util.ArrayList;
import java.util.Arrays;
/**
 和为 S 的两个数字（数组,双指针）

 题目描述
 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。

 解题思路
 使用双指针，一个指针指向元素较小的值，一个指针指向元素较大的值。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
 如果 sum > target，移动较大的元素，使 sum 变小一些；
 如果 sum < target，移动较小的元素，使 sum 变大一些。
 * */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i=0;
        int j=array.length-1;
        while(i<j){
            int cur=array[i]+array[j];
            if(cur==sum){
                return new ArrayList<Integer>(Arrays.asList(array[i],array[j]));
            }
            else if(cur<sum){
                i++;
            }
            else{
                j--;
            }
        }
         return new ArrayList<>();
    }


    public static void main(String[] args) {
        FindNumbersWithSum fn=new FindNumbersWithSum();
        int[] nums={1,2,3,4,5,6,9};
        ArrayList<Integer> list=new ArrayList<>();
        list=fn.FindNumbersWithSum(nums,8);
        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
