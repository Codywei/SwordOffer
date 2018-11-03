import java.util.LinkedList;
import java.util.Queue;

/**
 �ַ����е�һ�����ظ����ַ�

 ��Ŀ����
 ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ� "go" ʱ����һ��ֻ����һ�ε��ַ��� "g"�����Ӹ��ַ����ж���ǰ�����ַ���google" ʱ����һ��ֻ����һ�ε��ַ��� "l"
 **/
public class FirstAppearingOnce {
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
    public static void main(String[] args) {
        FirstAppearingOnce fa=new FirstAppearingOnce();
        char[] nums={'a','d','d','v','d','b','c','c'};
        for (int i = 0; i < nums.length; i++) {
            fa.Insert(nums[i]);
        }
        System.out.println(fa.FirstAppearingOnce());
    }
}
