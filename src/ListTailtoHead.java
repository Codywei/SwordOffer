import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 ��β��ͷ��ӡ����

 ��Ŀ����
 ��������ĵ�һ���ڵ㣬��β��ͷ��������ӡ��ÿ������ֵ��
 */

public class ListTailtoHead {
    /**
     ʹ��ջ
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
     ʹ�õݹ�
     * */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    /**
     ʹ��ͷ�巨
     * */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        // ͷ�巨������������
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // ���� ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     ʹ��Collections.reverse
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
        ArrayList<Integer> list2=lth.printListFromTailToHead(n1);
        ArrayList<Integer> list3=lth.printListFromTailToHead(n1);
        ArrayList<Integer> list4=lth.printListFromTailToHead(n1);
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
