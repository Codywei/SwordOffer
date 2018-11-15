/**
 �� O(1) ʱ����ɾ������ڵ㣨����

 ����˼·
 �� ����ýڵ㲻��β�ڵ㣬��ô����ֱ�ӽ���һ���ڵ��ֵ�����ýڵ㣬Ȼ����ýڵ�ָ�����¸��ڵ㣬��ɾ����һ���ڵ㣬ʱ�临�Ӷ�Ϊ O(1)��
 �� ���򣬾���Ҫ�ȱ��������ҵ��ڵ��ǰһ���ڵ㣬Ȼ����ǰһ���ڵ�ָ�� null��ʱ�临�Ӷ�Ϊ O(N)��


 ���ϣ�������� N �β�������ô��Լ��Ҫ�����ڵ�Ĵ���Ϊ N-1+N=2N-1������ N-1 ��ʾ N-1 ������β�ڵ��ÿ���ڵ��� O(1) ��ʱ�临�ӶȲ����ڵ���ܴ�����
 N ��ʾ 1 ��β�ڵ��� O(N) ��ʱ�临�ӶȲ����ڵ���ܴ�����(2N-1)/N ~ 2����˸��㷨��ƽ��ʱ�临�Ӷ�Ϊ O(1)��
 * */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        if (head == null || tobeDelete == null) {
            return null;
        }
        if (tobeDelete.next != null) {
            // Ҫɾ���Ľڵ㲻��β�ڵ�
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else {
            ListNode cur = head;
            while (cur.next != tobeDelete) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteNode dn=new DeleteNode();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        dn.deleteNode(a1,a4);
        while(a1!=null){
            System.out.println(a1.val);
            a1=a1.next;
        }

    }
}
