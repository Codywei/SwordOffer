import java.util.ArrayList;
/**
二叉树中和为某一值的路径(树，回溯)

 题目描述
 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 下图的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
 * */
public class FindEqualSumPath {

    private ArrayList<ArrayList<Integer>> ret=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        backtracking(root,target,new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            //底下注释的是错误的写法，这里以path参数必须新建一个ArrayList，,如果直接把path加入ret,之后对path的操作会直接影响ret里的path。
            ret.add(new ArrayList<>(path));
            //ret.add(path);
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        //添加（遍历）当前节点后回退
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(12);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        FindEqualSumPath fp=new FindEqualSumPath();
        ArrayList<ArrayList<Integer>> list=fp.FindPath(t1,22);
        for (int i = 0; i<list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();

        }

    }
}
