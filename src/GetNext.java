/**
 ����������һ�����

 ��Ŀ����
 ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣

 ����˼·
 ���һ���ڵ����������Ϊ�գ���ô�ýڵ����һ���ڵ���������������ڵ㣻
 ���������ҵ�һ��������ָ����������ýڵ�����Ƚڵ㡣
 * */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode.right!=null){
            pNode=pNode.right;
            while(pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        else{
           while(pNode.next!=null){
               TreeLinkNode parent=pNode.next;
               if(pNode==parent.left){
                   return parent;
               }
               pNode=pNode.next;
           }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode a1=new TreeLinkNode(1);
        TreeLinkNode a2=new TreeLinkNode(2);
        TreeLinkNode a3=new TreeLinkNode(3);
        TreeLinkNode a4=new TreeLinkNode(4);
        TreeLinkNode a5=new TreeLinkNode(5);
        a1.next=null;
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        a2.next=a1;
        a3.next=a1;
        a4.next=a2;
        a5.next=a2;

        GetNext gt=new GetNext();
        System.out.println(gt.GetNext(a1).val);
        System.out.println(gt.GetNext(a2).val);
        System.out.println(gt.GetNext(a4).val);
    }
}
