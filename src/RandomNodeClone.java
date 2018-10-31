/**
 复杂链表的复制

 题目描述
 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的 head。

 解题思路
 第一步，在每个节点的后面插入复制的节点。
 第二步，对复制节点的 random 链接进行赋值。
 第三步，拆分。

 * */
public class RandomNodeClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立 random 链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 拆分
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
