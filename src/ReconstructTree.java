import java.util.HashMap;
import java.util.Map;
/**
 �ؽ�������

 ��Ŀ����


 ���ݶ�������ǰ���������������Ľ�����ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�


 ����˼·
 ǰ������ĵ�һ��ֵΪ���ڵ��ֵ��ʹ�����ֵ�������������ֳ������֣��󲿷�Ϊ�����������������������Ҳ���Ϊ������������������Ľ����
 * */
public class ReconstructTree {
    // ���������������ÿ��ֵ��Ӧ������
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    public void printtree(TreeNode node){
        if(node!=null) {
            System.out.println(node.val);
            printtree(node.left);
            printtree(node.right);
        }
    }

    public static void main(String[] args) {
        int []pre={3,9,20,15,7};
        int []in={9,3,15,20,7};
        ReconstructTree rt=new ReconstructTree();
        TreeNode root=rt.reConstructBinaryTree(pre,in);
        rt.printtree(root);
    }

}
