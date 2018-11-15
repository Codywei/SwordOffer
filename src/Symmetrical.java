/**
 ¶Ô³ÆµÄ¶þ²æÊ÷£¨Ê÷£¬µÝ¹é£©

 µÝ¹é
 * */
public class Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {

        if(pRoot==null){
            return true;
        }
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {

        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        if(t1.val!=t2.val){
            return false;
        }
        return isSymmetrical(t1.left,t2.right)&&isSymmetrical(t1.right,t2.left);

    }

    public static void main(String[] args) {
        Symmetrical symmetrical=new Symmetrical();
        TreeNode t7=new TreeNode(4);
        TreeNode t8=new TreeNode(6);
        TreeNode t9=new TreeNode(6);
        TreeNode t10=new TreeNode(8);
        TreeNode t11=new TreeNode(9);
        TreeNode t12=new TreeNode(9);
        TreeNode t13=new TreeNode(8);
        t7.left=t8;
        t7.right=t9;
        t8.left=t10;
        t8.right=t11;
        t9.left=t12;
        t9.right=t13;
        System.out.println(symmetrical.isSymmetrical(t7));

    }

}
