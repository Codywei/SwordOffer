/**
���������������г��ֵĴ��������飬��������

 ��Ŀ����
 Input:
 nums = 1, 2, 3, 3, 3, 3, 4, 6
 K = 3
 Output:
 4
 * */
public class GetNumberOfK {
    public int GetNumberOfK(int[] nums, int K) {

        int first=binarySearch(nums,K);
        int last=binarySearch(nums,K+1);
        //fisrtԽ�����nums[first]��ֵ����K
        return(first==nums.length||nums[first]!=K)?0:last-first;
    }

    private int binarySearch(int[] nums, int K) {
        int l=0;
        int h=nums.length;
        while(l<h){
            int m=l+(h-l)/2;
            if(nums[m]>=K){
                h=m;
            }else{
                //�߽�����һ��Ҫȷ��������nums[m]<K��˵��Kһ�����������������l=m+1
                l=m+1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums={1,2,2,3,3,3,3,4,5};
        GetNumberOfK gk=new GetNumberOfK();
        System.out.println(gk.GetNumberOfK(nums,3));
    }
}
