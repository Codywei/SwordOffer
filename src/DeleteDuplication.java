/**
 删除有序链表中重复的结点（链表）
 （ 只要重复的就全删了）

 解决思路
 递归判断当前节点是否和下一节点值相重复。重复则清除并一直找下一个不重复的节点，将第一个不重复的节点当成目前递归函数的头结点；不重复则保留当前节点，并把next指针指向对下一个不重复节点
 * */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            //当元素重复时，下一个值就不断延后（这里加上next!=null判断是防止之后next为空时，next.val抛出异常）
            while (next != null && pHead.val == next.val) {
                    next = next.next;
            }
            return deleteDuplication(next);
        } else {
            //pHead的头结点与之后的节点不相同则保留
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }


    public static void main(String[] args) {
         DeleteDuplication dd=new DeleteDuplication();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(1);
        ListNode a3=new ListNode(2);
        ListNode a4=new ListNode(2);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        ListNode head=dd.deleteDuplication(a1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
