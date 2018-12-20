/**
 二叉搜索树与双向链表（树，链表）

 题目描述
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * */

public class ConvertTreeList {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if(node==null){
            return;
        }
        //先遍历左子树
        inOrder(node.left);
        //当前节点的前驱节点是pre
        node.left=pre;

        //完善前驱节点向后的指针
        if(pre!=null){
            pre.right=node;
        }

        //遍历完当前节点，将node赋值给pre
        pre=node;

        //头节点的赋值
        if(head==null){
            head=node;
        }

        //后遍历右子树
        inOrder(node.right);

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);


        t1.left=t2;
        t1.right=t3;
        ConvertTreeList ct=new ConvertTreeList();
        TreeNode t4=ct.Convert(t1);
        while(t4!=null){
            System.out.println(t4.val);
            t4=t4.right;
        }
    }
}
