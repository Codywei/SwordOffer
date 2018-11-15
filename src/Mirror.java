/**
 ¶þ²æÊ÷µÄ¾µÏñ£¨Ê÷£¬µÝ¹é£©

 µÝ¹é
 * */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root==null){
            return ;
        }
        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
    }

    public void scan(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            scan(root.left);
            scan(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t7=new TreeNode(4);
        TreeNode t8=new TreeNode(6);
        TreeNode t9=new TreeNode(7);
        t7.left=t8;
        t7.right=t9;

        Mirror mirror=new Mirror();
        mirror.Mirror(t7);
        mirror.scan(t7);
    }
}
