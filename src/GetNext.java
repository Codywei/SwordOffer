/**
 二叉树的下一个结点

 题目描述
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

 解题思路
 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
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
