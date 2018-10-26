/**
 �����е����� K �����

 ����˼·
 ������ĳ���Ϊ N��������ָ�� P1 �� P2������ P1 �ƶ� K ���ڵ㣬���� N - K ���ڵ�����ƶ�����ʱ�� P1 �� P2 ͬʱ�ƶ�������֪���� P1 �ƶ��������βʱ��P2 �ƶ��� N - K ���ڵ㴦����λ�þ��ǵ����� K ���ڵ㡣
 
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
