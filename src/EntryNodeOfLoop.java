/**
 �����л�����ڽ�㣨����


 ��Ŀ����
 һ�������а����������ҳ�������Ļ�����ڽ�㡣Ҫ����ʹ�ö���Ŀռ䡣

 ����˼·
 ʹ��˫ָ�룬һ��ָ�� fast ÿ���ƶ������ڵ㣬һ��ָ�� slow ÿ���ƶ�һ���ڵ㡣��Ϊ���ڻ�����������ָ��ض������ڻ��е�ĳ���ڵ��ϡ�
 fast �ƶ��Ľڵ���Ϊ x+Ky+(K-1)z��K>=2����slow Ϊ x+y������ fast �ٶȱ� slow ��һ������� x+Ky+(K-1)z=2(x+y)���õ� x=(K-2)(y+z)+z��[(K-2)(y+z)��ʾ����Ȧ]

 �������㣬slow Ҫ��������ڵ㻹��Ҫ�ƶ� z ���ڵ�(����nȦ+z���ڵ�)������� fast ���´�ͷ��ʼ�ƶ��������ٶȱ�Ϊÿ���ƶ�һ���ڵ㣬��ô��������ڵ㻹��Ҫ�ƶ� x ���ڵ㡣�������Ѿ��Ƶ��� x=(K-2)(y+z)+z����� fast �� slow ���ڻ���ڵ�������
 * */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
       do{
           fast=fast.next.next;
           slow=slow.next;
           //����Ӧ�üӸ��жϣ����������޻������
           if(fast==null){
               return null;
           }
       }while(slow!=fast);
       fast=pHead;
       while(fast!=slow){
           fast=fast.next;
           slow=slow.next;
       }
       return slow;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop el=new EntryNodeOfLoop();
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(3);
        ListNode a4=new ListNode(4);
        ListNode a5=new ListNode(5);

        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a5.next=a3;

        System.out.println(el.EntryNodeOfLoop(a1).val);
    }
}
