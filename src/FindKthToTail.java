/**
 链表中倒数第 K 个结点

 解题思路
 设链表的长度为 N。设两个指针 P1 和 P2，先让 P1 移动 K 个节点，则还有 N - K 个节点可以移动。此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到 N - K 个节点处，该位置就是倒数第 K 个节点。
 
 * */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode P1 = head;
        while (P1 != null && k-- > 0) {
            P1 = P1.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode P2 = head;
        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public static void main(String[] args) {
        FindKthToTail ft=new FindKthToTail();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        System.out.println(ft.FindKthToTail(a1,2).val);
    }
}
