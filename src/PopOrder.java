import java.util.Stack;
/**
 ջ��ѹ�롢��������

 ��Ŀ����
 ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 �������� 1,2,3,4,5 ��ĳջ��ѹ��˳������ 4,5,3,2,1 �Ǹ�ѹջ���ж�Ӧ��һ���������У��� 4,3,5,1,2 �Ͳ������Ǹ�ѹջ���еĵ������С�

 ����˼·
 ʹ��һ��ջ��ģ��ѹ�뵯������,�����Ƿ��ܰ�˳����ջ�е�Ԫ����ա�
 * */
public class PopOrder {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            //���㵯��������Ԫ�س�ջ
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        PopOrder po=new PopOrder();
        int[] pushsequence={1,2,3,4,5};
        int[] popsequence={4,5,3,2,1};
        int[] popsequence2={4,3,5,1,2};
        System.out.println(po.IsPopOrder(pushsequence,popsequence));
        System.out.println(po.IsPopOrder(pushsequence,popsequence2));
    }
}
