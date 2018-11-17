/**
 ���������ڵ����͹������ȣ������ݹ飩

 ����˼·
 ���������:����������У������ڵ� p, q �Ĺ������� root ���� root.val >= p.val && root.val <= q.val��
 ��ͨ�������������������в����Ƿ���� p ���� q����� p �� q �ֱ������������У���ô��˵�����ڵ������͹������ȡ�
 * */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor2(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor2(root.right,p,q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lc=new LowestCommonAncestor();
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(1);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        System.out.println(lc.lowestCommonAncestor2(t1,t2,t3).val);
    }

}
