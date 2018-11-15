/**
 删除有序链表中重复的结点（链表）
 （ 只要重复的就全删了）

 * */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            //当元素重复时，下一个值就不断延后
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }


    public static void main(String[] args) {
         DeleteDuplication dd=new DeleteDuplication();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(2);
        ListNode a4=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        dd.deleteDuplication(a1);
        while(a1!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }
    }
}
