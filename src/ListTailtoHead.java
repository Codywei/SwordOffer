import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 从尾到头打印链表（链表，栈，递归，集合）

 题目描述
 输入链表的第一个节点，从尾到头反过来打印出每个结点的值。

 解题思路
 1.栈（后进先出） 2.递归   3.循环控制  4.Collections.reverse
 */

public class ListTailtoHead {
    /**
     使用栈
     * */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer>stack=new Stack<>();
        while(listNode!=null){
            stack.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> ret=new ArrayList<>();
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }



    /**
     使用递归
     * */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {

        ArrayList<Integer> ret=new ArrayList<>();
        if(listNode!=null){
            ret.addAll(printListFromTailToHead2(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     使用Collections.reverse
     * */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (listNode != null) {
            ret.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;

    }

    /**
     使用循环控制
     需要维护两个节点（当前头结点curHead，和新的头结点newHead）
     * */
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {

        ListNode newHead=null;
        ListNode curHead=listNode;
        while(curHead!=null){
            ListNode next= curHead.next;
            curHead.next=newHead;
            newHead=curHead;
            curHead=next;
        }
        ArrayList<Integer> ret=new ArrayList<>();
        while(newHead!=null){
            ret.add(newHead.val);
            newHead=newHead.next;
        }
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
