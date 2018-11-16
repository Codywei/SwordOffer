import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 ��С�� K �������������򣬶�����

 ����˼·
 1.����ѡ��
 ���Ӷȣ�O(N) + O(1)
 ֻ�е������޸�����Ԫ��ʱ�ſ���ʹ��
 ��������� partition() �������᷵��һ������ j ʹ�� a[l..j-1] С�ڵ��� a[j]���� a[j+1..h] ���ڵ��� a[j]����ʱ a[j] ��������ĵ� j ��Ԫ�ء�
 ����������������ҳ�����ĵ� K ��Ԫ�أ������ҵ� K ��Ԫ�ص��㷨��Ϊ����ѡ���㷨��

 2.��СΪ K ����С��
 ���Ӷȣ�O(NlogK) + O(K)
 �ر��ʺϴ���������
 Ӧ��ʹ�ô󶥶���ά����С�ѣ�������ֱ�Ӵ���һ��С���Ѳ�����һ����С����ͼ��С�����е�Ԫ�ض�����СԪ�ء�

 ά��һ����СΪ K ����С�ѹ������£������һ��Ԫ��֮������󶥶ѵĴ�С���� K����ô��Ҫ���󶥶ѵĶѶ�Ԫ��ȥ��

 * */
public class GetLeastNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0) {
            return ret;
        }
        findKthSmallest(nums, k - 1);
    //findKthSmallest ��ı����飬ʹ��ǰ k ����������С�� k ����
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
         /* �з�Ԫ�� */
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
