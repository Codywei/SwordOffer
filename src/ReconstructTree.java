import java.util.HashMap;
import java.util.Map;
/**
 �ؽ�������

 ��Ŀ����
 ���ݶ�������ǰ���������������Ľ�����ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�

 ����˼·
 ǰ������ĵ�һ��ֵΪ���ڵ��ֵ��ʹ�����ֵ�������������ֳ������֣��󲿷�Ϊ�����������������������Ҳ���Ϊ������������������Ľ����

 1.��������������ÿ��Ԫ�ض�Ӧ������ֵ�����һ����ϣ��
 2.����ǰ���������������еݹ��ؽ�
 ��1��ͨ��ǰ����������õ�ǰ�����ĸ�
 ��2���øø�����������ʱ�ø�������
 ��3���������͸��������������������������õ���������С
 ��4���ݹ�ø�����������ǰ����ʼ��+1��ǰ����ֹ��Ϊǰ����ʼ��+��������С��������ʼ�㣩
 ��5���ݹ�ø�����������ǰ����ʼ��+��������С+1��ǰ����ֹ�㣬������ʼ��+��������С+1��
 * */
public class ReconstructTree {
    // ���������������ÿ��ֵ��Ӧ������
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        for(int i=0;i<in.length;i++){
            indexForInOrders.put(in[i],i);
        }
        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }

    /**
     * @param pre  ǰ���������
     * @param preL ǰ����������ڵ�ǰ��������������
     * @param preR ǰ����������ڵ�ǰ������������Ҷ�
     * @param inL  ������������ڵ�ǰ�������������ˣ����ڼ��㵱ǰ�������Ĵ�С��
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {

        if(preL>preR){
            return null;
        }
        TreeNode root=new TreeNode(pre[preL]);
        int inIndex=indexForInOrders.get(root.val);
        int LeftTreesize=inIndex-inL;
        root.left=reConstructBinaryTree(pre,preL+1,preL+LeftTreesize,inL);
        root.right=reConstructBinaryTree(pre,preL+LeftTreesize+1,preR,inL+LeftTreesize+1);
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
