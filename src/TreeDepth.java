/**
 二叉树的深度（树）

 题目描述
 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {

        return root==null?0:1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t6.left=t8;

        TreeDepth td=new TreeDepth();
        System.out.println(td.TreeDepth(t1));
    }
}
