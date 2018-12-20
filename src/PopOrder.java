import java.util.Stack;
/**
 ջ��ѹ�롢�������У�ջ��

 ��Ŀ����
 ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
 �������� 1,2,3,4,5 ��ĳջ��ѹ��˳������ 4,5,3,2,1 �Ǹ�ѹջ���ж�Ӧ��һ���������У��� 4,3,5,1,2 �Ͳ������Ǹ�ѹջ���еĵ������С�

 ����˼·
 ʹ��һ��ջ��ģ��ѹ�뵯������,�����Ƿ��ܰ�˳����ջ�е�Ԫ����ա�
 * */
public class PopOrder {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {

        int n=pushSequence.length;
        Stack<Integer> stack=new Stack<>();
        if(n!=popSequence.length){
            return false;
        }
        int popindex=0;
        for(int i=0;i<n;i++){
            stack.push(pushSequence[i]);
            //�ж�popindex�Ƿ��ڳ�ջ����������Χ�ڣ��жϵ�ǰ��ջ����Ԫ���Ƿ�ͺ�ջ��Ԫ����ͬ
            while(popindex<n&&popSequence[popindex]==stack.peek()){
                stack.pop();
                popindex++;
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
