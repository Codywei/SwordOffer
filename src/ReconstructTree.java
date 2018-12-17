import java.util.HashMap;
import java.util.Map;
/**
 重建二叉树（二叉树，前序，中序）

 题目描述
 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 解题思路
 前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。

 1.将中序遍历结果和每个元素对应的索引值缓存成一个哈希表；
 2.用前序遍历结果对树进行递归重建
 （1）通过前序遍历数组获得当前子树的根
 （2）用该根获得中序遍历时该根的索引
 （3）将索引和该子树中序遍历的最左索引相减得到左子树大小
 （4）递归该根的左子树（前序起始点+1，前序终止点为前序起始点+左子树大小，中序起始点）
 （5）递归该根的右子树（前序起始点+左子树大小+1，前序终止点，中序起始点+左子树大小+1）
 * */
public class ReconstructTree {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer,Integer>indexorder=new HashMap<>();
    public TreeNode reConstructBinaryTree(int[]pre,int[] in){
        for (int i = 0; i < in.length; i++) {
           indexorder.put(in[i],i);

        }
        return reConstructBinaryTree(pre,0,pre.length-1,0);
    }



    /**
     * @param pre  前序遍历数组
     * @param preL 前序遍历数组在当前遍历区间的最左端
     * @param preR 前序遍历数组在当前遍历区间的最右端
     * @param inL  中序遍历数组在当前遍历区间的最左端（用于计算当前左子树的大小）
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if(preL>preR){
            return null;
        }
        TreeNode root=new TreeNode(pre[preL]);
        //index为当前节点在中序遍历数组中的索引
        int index=indexorder.get(root.val);
        //LeftTreeSize为当前节点的左子树大小
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
