import java.util.Stack;
/**
 ���� min ������ջ

 ��Ŀ����
 ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص� min ������
 * */
public class Minstack {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Minstack ms=new Minstack();
        ms.push(1);
        ms.push(2);
        ms.push(4);
        ms.push(3);
        ms.push(3);
        System.out.println(ms.min());
    }
}
