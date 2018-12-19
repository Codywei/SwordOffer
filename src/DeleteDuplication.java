/**
 ɾ�������������ظ��Ľ�㣨����
 �� ֻҪ�ظ��ľ�ȫɾ�ˣ�

 ���˼·
 �ݹ��жϵ�ǰ�ڵ��Ƿ����һ�ڵ�ֵ���ظ����ظ��������һֱ����һ�����ظ��Ľڵ㣬����һ�����ظ��Ľڵ㵱��Ŀǰ�ݹ麯����ͷ��㣻���ظ�������ǰ�ڵ㣬����nextָ��ָ�����һ�����ظ��ڵ�
 * */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            //��Ԫ���ظ�ʱ����һ��ֵ�Ͳ����Ӻ��������next!=null�ж��Ƿ�ֹ֮��nextΪ��ʱ��next.val�׳��쳣��
            while (next != null && pHead.val == next.val) {
                    next = next.next;
            }
            return deleteDuplication(next);
        } else {
            //pHead��ͷ�����֮��Ľڵ㲻��ͬ����
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
