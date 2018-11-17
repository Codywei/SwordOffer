/**
 ����������ĵ�K����㣨�������������

 ����˼·
 ���ö���������������������ص㡣
 * */
public class KthNode {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {

        if(root==null||cnt>k){
            return;
        }
        inOrder(root.left,k);
        cnt++;
        if(cnt==k){
            ret=root;
        }
        inOrder(root.right,k);
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        KthNode kn=new KthNode();
        System.out.println(kn.KthNode(t1,2).val);

    }

}
