/**
 链表中环的入口结点（链表）


 题目描述
 一个链表中包含环，请找出该链表的环的入口结点。要求不能使用额外的空间。

 解题思路
 使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。因为存在环，所以两个指针必定相遇在环中的某个节点上。
 fast 移动的节点数为 x+Ky+(K-1)z（K>=2），slow 为 x+y，由于 fast 速度比 slow 快一倍，因此 x+Ky+(K-1)z=2(x+y)，得到 x=(K-2)(y+z)+z。[(K-2)(y+z)表示若干圈]

 在相遇点，slow 要到环的入口点还需要移动 z 个节点(或者n圈+z个节点)，如果让 fast 重新从头开始移动，并且速度变为每次移动一个节点，那么它到环入口点还需要移动 x 个节点。在上面已经推导出 x=(K-2)(y+z)+z，因此 fast 和 slow 将在环入口点相遇。
 * */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
       do{
           fast=fast.next.next;
           slow=slow.next;
           //这里应该加个判断，考虑链表无环的情况
           if(fast==null){
               return null;
           }
       }while(slow!=fast);
       fast=pHead;
       while(fast!=slow){
           fast=fast.next;
           slow=slow.next;
       }
       return slow;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop el=new EntryNodeOfLoop();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);

        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a3;

        System.out.println(el.EntryNodeOfLoop(a1).val);
    }
}
