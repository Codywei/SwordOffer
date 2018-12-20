/**
 ������������˫��������������

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
        if(node==null){
            return;
        }
        //�ȱ���������
        inOrder(node.left);
        //��ǰ�ڵ��ǰ���ڵ���pre
        node.left=pre;

        //����ǰ���ڵ�����ָ��
        if(pre!=null){
            pre.right=node;
        }

        //�����굱ǰ�ڵ㣬��node��ֵ��pre
        pre=node;

        //ͷ�ڵ�ĸ�ֵ
        if(head==null){
            head=node;
        }

        //�����������
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
