import java.util.LinkedList;
import java.util.Queue;

/**
 字符流中第一个不重复的字符

 题目描述
 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"

 解题思路
 用队列实现（先进先出，匹配到超过一次则从队头弹出）
 **/
public class FirstAppearingOnce {

    private int[] cnts=new int[256];
    private Queue<Character>queue=new LinkedList<>();

    public void Insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while(!queue.isEmpty()&&cnts[queue.peek()]>1){
            queue.poll();
        }

    }

    public char FirstAppearingOnce() {
       return queue.isEmpty() ? '#' : queue.peek();
    }
    public static void main(String[] args) {
        FirstAppearingOnce fa=new FirstAppearingOnce();
        char[] nums={'d','d','a','v','b','b','c','c'};
        for (int i = 0; i < nums.length; i++) {
            fa.Insert(nums[i]);
        }
        System.out.println(fa.FirstAppearingOnce());
    }
}
