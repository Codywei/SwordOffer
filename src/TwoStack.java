import java.util.Stack;
/**
 ������ջʵ�ֶ���(ջ������)

 ��Ŀ����
 ������ջ��ʵ��һ�����У���ɶ��е� Push �� Pop ������

 ����˼·
 in ջ����������ջ��push��������out ջ���������ջ��pop��������һ��Ԫ�ؽ��� in ջ֮�󣬳�ջ��˳�򱻷�ת��
 ��Ԫ��Ҫ��ջʱ����Ҫ�Ƚ��� out ջ����ʱԪ�س�ջ˳����һ�α���ת����˳�ջ˳��ͺ��ʼ��ջ˳������ͬ�ģ��Ƚ����Ԫ�����˳�������Ƕ��е�˳��

 1.�ж�out�Ƿ�Ϊ�գ���Ϊ�գ���in��Ϊ��ʱ����in��Ԫ��ת��out��
 2.out�ڲ���һ����ȻΪ�������쳣
 3.����out�е�ջ��Ԫ�ء�
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
