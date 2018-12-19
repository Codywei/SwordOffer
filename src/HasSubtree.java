/**
树的子结构（树，递归）
 (子结构，我认为不是子树)

 递归
 * */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return false;
        }
        //将当前节点作为匹配的起点，或将左子节点作为匹配的起点，或将右子节点作为匹配的起点，这样递归的意思将整棵原树的节点都考虑进需要进行匹配的节点里。
        return isSubtreeWithRoot(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);

    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        //树的子结构匹配完了
        if(root2==null){
            return true;
        }
        //树的子结构还没匹配完，原树就匹配到头了
        if(root1==null){
            return false;
        }
        //当前子结构节点与原树节点不匹配
        if(root1.val!=root2.val){
            return false;
        }
        //当前子结构节点与原树节点匹配上了，需要再递归节点的匹配左子树和右子树
        return isSubtreeWithRoot(root1.left,root2.left)&&isSubtreeWithRoot(root1.right,root2.right);

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
