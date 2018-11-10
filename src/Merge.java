/**
 合并两个排序的链表

 递归和迭代
 * */
public class Merge {
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }

    }

    public ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;

    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(3);
        ListNode a3=new ListNode(5);
        ListNode a4=new ListNode(7);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;

        ListNode a5=new ListNode(2);
        ListNode a6=new ListNode(4);
        ListNode a7=new ListNode(6);
        a5.next=a6;
        a6.next=a7;

        Merge merge=new Merge();
        ListNode head=merge.Merge2(a1,a5);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
