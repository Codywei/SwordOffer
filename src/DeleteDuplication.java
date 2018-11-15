/**
 ɾ�������������ظ��Ľ�㣨����
 �� ֻҪ�ظ��ľ�ȫɾ�ˣ�

 * */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            //��Ԫ���ظ�ʱ����һ��ֵ�Ͳ����Ӻ�
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
