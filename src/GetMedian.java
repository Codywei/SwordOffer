import java.util.PriorityQueue;

/**
�������е���λ��

 ��Ŀ����
 ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * */
public class GetMedian {
    /* �󶥶ѣ��洢����Ԫ�� */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* С���ѣ��洢�Ұ��Ԫ�أ������Ұ��Ԫ�ض��������� */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* ��ǰ�����������Ԫ�ظ��� */
    private int N = 0;

    public void Insert(Integer val) {
    /* ����Ҫ��֤�����Ѵ���ƽ��״̬ */
        if (N % 2 == 0) {
        /* N Ϊż��������²��뵽�Ұ�ߡ�
         * ��Ϊ�Ұ��Ԫ�ض�Ҫ�������ߣ������²����Ԫ�ز�һ��������Ԫ�����Ĵ�
         * �����Ҫ�Ƚ�Ԫ�ز������ߣ�Ȼ����������Ϊ�󶥶ѵ��ص㣬ȡ���Ѷ�Ԫ�ؼ�Ϊ���Ԫ�أ���ʱ�����Ұ�� */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0) {
            return (left.peek() + right.peek()) / 2.0;
        }
        else {
            return (double) right.peek();
        }
    }

    public static void main(String[] args) {
        GetMedian gm=new GetMedian();
        int[] nums={1,2,3,4,5,6,7,8};
        for (int i = 0; i < nums.length; i++) {
            gm.Insert(nums[i]);
        }
        System.out.println(gm.GetMedian());
    }
}
