/**
 ��������ĵ�һ��������㣨����

 ����˼·
 �� A �ĳ���Ϊ a + c��B �ĳ���Ϊ b + c������ c Ϊβ���������ֳ��ȣ���֪ a + c + b = b + c + a��
 ���������� A ��ָ����ʵ�����β��ʱ������������ B ��ͷ�����¿�ʼ�������� B��ͬ���أ����������� B ��ָ����ʵ�����β��ʱ������������ A ��ͷ�����¿�ʼ�������� A���������ܿ��Ʒ��� A �� B ���������ָ����ͬʱ���ʵ����㡣
 * */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode l1=pHead1;
        ListNode l2=pHead2;
        while(l1!=l2){
            l1=l1==null?pHead2:l1.next;
            l2=l2==null?pHead1:l2.next;
        }
        return l1;

    }

    public static void main(String[] args) {
        FindFirstCommonNode ff=new FindFirstCommonNode();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(1);
        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(2);
        ListNode b3=new ListNode(2);
        ListNode c1=new ListNode(4);
        ListNode c2=new ListNode(5);
        a1.next=a2;
        a2.next=c1;
        c1.next=c2;
        b1.next=b2;
        b2.next=b3;
        b3.next=c1;
        System.out.println(ff.FindFirstCommonNode(a1,b1).val);
    }
}
