import java.util.ArrayList;
import java.util.PriorityQueue;
/**
 �������ڵ����ֵ�����飬������

 ��Ŀ����
 ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 ���磬����������� {2, 3, 4, 2, 6, 2, 5, 1} ���������ڵĴ�С 3����ôһ������ 6 ���������ڣ����ǵ����ֵ�ֱ�Ϊ {4, 4, 6, 6, 6, 5}��
 * */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1) {
            return ret;
        }
         /* �󶥶� */
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }
        ret.add(heap.peek());
        /* ά��һ����СΪ size �Ĵ󶥶� */
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
