import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 滑动窗口的最大值

 题目描述
 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 * */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
         /* 大顶堆 */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        /* 维护一个大小为 size 的大顶堆 */
        for (int i = 0, j = size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;

    }

    public static void main(String[] args) {
        MaxInWindows miw=new MaxInWindows();
        int[] nums={2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> ret=new ArrayList<>();
        ret=miw.maxInWindows(nums,3);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));

        }

    }
}
