import java.util.Stack;
/**
 栈的压入、弹出序列

 题目描述
 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 例如序列 1,2,3,4,5 是某栈的压入顺序，序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。

 解题思路
 使用一个栈来模拟压入弹出操作,看看是否能按顺序将新栈中的元素清空。
 * */
public class PopOrder {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            //满足弹出条件的元素出栈
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
