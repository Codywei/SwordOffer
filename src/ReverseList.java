/**
 反转链表（链表）

 递归或迭代
 * */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode newHead=ReverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;

    }

    public ListNode ReverseList2(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    public ListNode ReverseList3(ListNode head) {
        ListNode newHead = null;
        ListNode curHead =head;
        while (curHead != null) {
            ListNode next = curHead.next;
            curHead.next = newHead;
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        ReverseList rl=new ReverseList();
        ListNode head=rl.ReverseList(a1);
        while(head!=null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}
