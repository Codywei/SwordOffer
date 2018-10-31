/**
 ������������˫������

 ��Ŀ����
 ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * */
public class ConvertTreeList {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
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
