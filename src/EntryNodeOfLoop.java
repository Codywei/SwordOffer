/**
 �����л�����ڽ��


 ��Ŀ����
 һ�������а����������ҳ�������Ļ�����ڽ�㡣Ҫ����ʹ�ö���Ŀռ䡣

 ����˼·
 ʹ��˫ָ�룬һ��ָ�� fast ÿ���ƶ������ڵ㣬һ��ָ�� slow ÿ���ƶ�һ���ڵ㡣��Ϊ���ڻ�����������ָ��ض������ڻ��е�ĳ���ڵ��ϡ� fast �ƶ��Ľڵ���Ϊ x+2y+z��slow Ϊ x+y������ fast �ٶȱ� slow ��һ������� x+2y+z=2(x+y)���õ� x=z��

 �������㣬slow Ҫ��������ڵ㻹��Ҫ�ƶ� z ���ڵ㣬����� fast ���´�ͷ��ʼ�ƶ��������ٶȱ�Ϊÿ���ƶ�һ���ڵ㣬��ô��������ڵ㻹��Ҫ�ƶ� x ���ڵ㡣�������Ѿ��Ƶ��� x=z����� fast �� slow ���ڻ���ڵ�������
 * */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        FindKthToTail ft=new FindKthToTail();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);
        ListNode a6=new ListNode(6);

        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        System.out.println(ft.FindKthToTail(a1,2).val);
    }
}
