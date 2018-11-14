import java.util.Stack;
/**
 用两个栈实现队列(栈，队列)

 题目描述
 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。

 解题思路
 in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。一个元素进入 in 栈之后，出栈的顺序被反转。
 当元素要出栈时，需要先进入 out 栈，此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。

 1.判断out是否为空，若为空，则当in不为空时，将in的元素转入out中
 2.out在步骤一后依然为空则抛异常
 3.弹出out中的栈顶元素。
 * */
public class TwoStack {
    Stack<Integer> in=new Stack<Integer>();
    Stack<Integer> out=new Stack<Integer>();
    public void push(int node){
        in.push(node);
    }
    public int pop() throws Exception{
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        if(out.isEmpty()){
            throw new Exception("queue is empty");
        }
        return out.pop();
    }

    public static void main(String[] args) {
        TwoStack ts=new TwoStack();
        ts.push(1);
        ts.push(2);
        try{
            System.out.println(ts.pop());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        ts.push(3);
        try{
            System.out.println(ts.pop());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(ts.pop());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println(ts.pop());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }
}
