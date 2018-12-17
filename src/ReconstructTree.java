import java.util.HashMap;
import java.util.Map;
/**
 �ؽ�����������������ǰ������

 ��Ŀ����
 ���ݶ�������ǰ���������������Ľ�����ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�

 ����˼·
 ǰ������ĵ�һ��ֵΪ���ڵ��ֵ��ʹ�����ֵ�������������ֳ������֣��󲿷�Ϊ�����������������������Ҳ���Ϊ������������������Ľ����

 1.��������������ÿ��Ԫ�ض�Ӧ������ֵ�����һ����ϣ��
 2.��ǰ���������������еݹ��ؽ�
 ��1��ͨ��ǰ����������õ�ǰ�����ĸ�
 ��2���øø�����������ʱ�ø�������
 ��3���������͸��������������������������õ���������С
 ��4���ݹ�ø�����������ǰ����ʼ��+1��ǰ����ֹ��Ϊǰ����ʼ��+��������С��������ʼ�㣩
 ��5���ݹ�ø�����������ǰ����ʼ��+��������С+1��ǰ����ֹ�㣬������ʼ��+��������С+1��
 * */
public class ReconstructTree {
    // ���������������ÿ��ֵ��Ӧ������
    private Map<Integer,Integer>indexorder=new HashMap<>();
    public TreeNode reConstructBinaryTree(int[]pre,int[] in){
        for (int i = 0; i < in.length; i++) {
           indexorder.put(in[i],i);

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
        //indexΪ��ǰ�ڵ���������������е�����
        int index=indexorder.get(root.val);
        //LeftTreeSizeΪ��ǰ�ڵ����������С
        int LeftTreeSize=index-inL;
        root.left=reConstructBinaryTree(pre,preL+1,preL+LeftTreeSize,inL);
        root.right=reConstructBinaryTree(pre,preL+LeftTreeSize+1,preR,inL+LeftTreeSize+1);
        return root;
    }



    public void printtree(TreeNode node){
        if(node!=null) {
            System.out.println(node.val);
            printtree(node.left);
            printtree(node.right);
        }
    }

    public CharTreeNode reconstructreebystring(String pre,String in){
        if(pre.isEmpty()){
            return null;
        }
        CharTreeNode root=new CharTreeNode(pre.charAt(0));
        int rootindex=in.indexOf((char)root.val);
        root.left=reconstructreebystring(pre.substring(1,rootindex+1),in.substring(0,rootindex));
        root.right=reconstructreebystring(pre.substring(rootindex+1),in.substring(rootindex+1));
        return root;
    }

    public void printchartree(CharTreeNode node){
        if(node!=null) {
            System.out.println(node.val);
            printchartree(node.left);
            printchartree(node.right);
        }
    }


    public static void main(String[] args) {
//        int []pre={3,9,20,15,7};
//        int []in={9,3,15,20,7};
        ReconstructTree rt=new ReconstructTree();
//        TreeNode root=rt.reConstructBinaryTree(pre,in);
//        rt.printtree(root);
        String pre2="ABDEGCF";
        String in2="DBGEACF";
        CharTreeNode root2=rt.reconstructreebystring(pre2,in2);
        rt.printchartree(root2);
    }

}
