/**
 ��������ĸ���

 ��Ŀ����
 ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ�������� head��

 ����˼·
 ��һ������ÿ���ڵ�ĺ�����븴�ƵĽڵ㡣
 �ڶ������Ը��ƽڵ�� random ���ӽ��и�ֵ��
 ����������֡�

 * */
public class RandomNodeClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // �����½ڵ�
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // ���� random ����
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // ���
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
    }

    public static void main(String[] args) {
        RandomListNode r1=new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        RandomListNode r4=new RandomListNode(4);
        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r1.random=r3;
        r2.random=r4;
        r3.random=r1;
        r4.random=r2;
        RandomNodeClone rn=new RandomNodeClone();
        RandomListNode ret=rn.Clone(r1);
        while(ret!=null){
            System.out.print(ret.label);
            System.out.println(" "+ret.random.label);
            ret=ret.next;
        }
    }
}
