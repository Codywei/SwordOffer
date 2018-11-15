import java.util.Stack;
/**
 包含 min 函数的栈（栈）

 题目描述
 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 * */
public class Minstack {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        //精髓：用表达式直接判断minStack该加入什么元素
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
