import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 最小的 K 个数（快速排序，堆排序）

 解题思路
 1.快速选择
 复杂度：O(N) + O(1)
 只有当允许修改数组元素时才可以使用
 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素。
 可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。

 2.大小为 K 的最小堆
 复杂度：O(NlogK) + O(K)
 特别适合处理海量数据
 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。

 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除

 * */
public class GetLeastNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0) {
            return ret;
        }
        findKthSmallest(nums, k - 1);
    //findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数
        for (int i = 0; i < k; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j > k) {
                h = j - 1;
            }
            else {
                l = j + 1;
            }
        }
    }

    private int partition(int[] nums, int l, int h) {
         /* 切分元素 */
        int p = nums[l];
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p){

            } ;
            while (j != l && nums[--j] > p){

            } ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        GetLeastNumber gln=new GetLeastNumber();
        int[] nums={1,3,54,6,4,5,24,8,7};
        ArrayList<Integer>list=gln.GetLeastNumbers_Solution2(nums,4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
