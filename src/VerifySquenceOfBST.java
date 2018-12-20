/**
 二叉搜索树的后序遍历序列（树，后序遍历）

 题目描述
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 例如，下图是后序遍历序列 1,3,2 所对应的二叉搜索树。（这里指的是二叉搜索树，不是平衡二叉搜索树。）
 * */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return verify(sequence,0,sequence.length-1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        //如果last和first相邻，无论大还是小都可以接受，所以返回true
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int cutIndex = first;
        //找到比当前节点大的第一个节点
        while (cutIndex < last && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        //如果之后的节点有一个比当前节点小，就报错
        for (int i = cutIndex; i < last; i++){
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        //递归判断当前节点的左右子树
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);

    }

    public static void main(String[] args) {
        VerifySquenceOfBST vs=new VerifySquenceOfBST();
        int[] sequence={1,3,2};
        System.out.println(vs.VerifySquenceOfBST(sequence));

    }
}
