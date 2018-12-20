/**
 两个链表的第一个公共结点（链表）

 解题思路
 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 * */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode l1=pHead1;
        ListNode l2=pHead2;
        while(l1!=l2){
            l1=l1==null?pHead2:l1.next;
            l2=l2==null?pHead1:l2.next;
        }
        return l1;

    }

    public static void main(String[] args) {
        FindFirstCommonNode ff=new FindFirstCommonNode();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(1);
        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(2);
        ListNode b3=new ListNode(2);
        ListNode c1=new ListNode(4);
        ListNode c2=new ListNode(5);
        a1.next=a2;
        a2.next=c1;
        c1.next=c2;
        b1.next=b2;
        b2.next=b3;
        b3.next=c1;
        System.out.println(ff.FindFirstCommonNode(a1,b1).val);
    }
}
