/**
数组中的逆序对（归并排序）

 题目描述
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * */
public class InversePairs {
    private long cnt = 0;
    /**
     * 在这里声明辅助数组，而不是在 merge() 递归函数中声明
     * */
    private int[] tmp;

    public int InversePairs(int[] nums) {
        tmp=new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return (int)(cnt%1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {

        if(h-l<1){
            return;
        }
        int m=l+(h-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,h);
        merge(nums,l,m,h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i=l,j=m+1,k=l;
        //注意边界条件的确定，如果这里是<而不是<= 可能执行下来就不会排序了
        while(i<=m||j<=h){
            if(i>m){
                tmp[k]=nums[j++];
            }
            else if(j>h){
                tmp[k]=nums[i++];
            }
            else if(nums[i]<=nums[j]){
                tmp[k]=nums[i++];
            }
            else{
                tmp[k]=nums[j++];
                // nums[i] >= nums[j]，说明 nums[i...mid] 都大于 nums[j]
                cnt+=m-i+1;
            }
            k++;
        }
        for (int n = l; n <=h; n++) {
          nums[n]=tmp[n];
        }
    }

    public static void main(String[] args) {
        InversePairs ip=new InversePairs();
        int[] nums={4,3,2,1};
        System.out.println(ip.InversePairs(nums));
    }
}
