/**
�����ӽṹ

 �ݹ�
 * */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtreeWithRoot(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(5);
        TreeNode t4=new TreeNode(6);
        TreeNode t5=new TreeNode(7);
        TreeNode t6=new TreeNode(8);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;

        TreeNode t7=new TreeNode(4);
        TreeNode t8=new TreeNode(6);
        TreeNode t9=new TreeNode(7);
        t7.left=t8;
        t7.right=t9;

        HasSubtree hs=new HasSubtree();
        System.out.println(hs.HasSubtree(t1,t7));



    }
}
