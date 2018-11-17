/**
 平衡二叉树（树）

 题目描述
 平衡二叉树左右子树高度差不超过 1。
 * */
public class IsBalanced {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {

        if(root==null||!isBalanced){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        IsBalanced ib=new IsBalanced();
        System.out.println(ib.IsBalanced_Solution(t1));
    }
}
