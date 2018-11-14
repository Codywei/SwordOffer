import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 从尾到头打印链表（链表，栈，递归，集合）

 题目描述
 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。

 解题思路
 1.栈（后进先出） 2.递归   3.头插法  4.Collections.reverse
 */

public class ListTailtoHead {
    /**
     使用栈
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }



    /**
     使用递归
     * */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead2(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     使用头插法
     头结点和第一个节点的区别：
     头结点是在头插法中使用的一个额外节点，这个节点不存储值；
     第一个节点就是链表的第一个真正存储值的节点。
     * */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     使用Collections.reverse
     * */
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (listNode != null) {
            ret.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        ListTailtoHead lth=new ListTailtoHead();
        ArrayList<Integer> list=lth.printListFromTailToHead(n1);
        ArrayList<Integer> list2=lth.printListFromTailToHead2(n1);
        ArrayList<Integer> list3=lth.printListFromTailToHead3(n1);
        ArrayList<Integer> list4=lth.printListFromTailToHead4(n1);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        for(int i=0;i<list2.size();i++){
            System.out.println(list2.get(i));
        }
        for(int i=0;i<list3.size();i++){
            System.out.println(list3.get(i));
        }
        for(int i=0;i<list4.size();i++){
            System.out.println(list4.get(i));
        }




    }



}
